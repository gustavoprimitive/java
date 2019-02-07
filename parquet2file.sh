#!/bin/bash
#Extrae a un fichero, a partir del path HDFS en que se encuentran los ficheros Parquet, su contenido.
#Gustavo Tejerina

#Path en que se dejará el fichero con los datos de la consulta
OUTPATH="/home/vagrant"

#Output de uso de script
usage() {
	echo "Usage:"
	echo -e "\t$0 /hdfs_path"
}

#Validación de parámetro
if [[ $# -ne 1 ]]; then
	usage
	exit 1
fi

if [[ $(hdfs dfs -ls "$1" 2>/dev/null |wc -l) -eq 0 ]]; then
	echo "ERROR. No se encuentra el fichero HDFS $1"
	exit 2
fi

OUTFILE=$(echo $1 |awk -F'/' '{print $NF}')

#Consulta sobre Parquet desde spark-shell
spark-shell << EOF |tee "$OUTPATH/${OUTFILE}.out"
//Dataframe
val df = sqlContext.read.parquet("$1")
//Descripción de entidad: campos, tipos de datos y nullable
//df.printSchema
//Registro de tabla temporal
df.registerTempTable("tempTab")
//Consulta sobre tabla
sqlContext.sql("SELECT * FROM tempTab").show(false)
:q
EOF

if [[ -f "$OUTPATH/$OUTFILE.out" ]]; then
	echo "Se ha generado el fichero: $OUTPATH/$OUTFILE.out"
fi	

exit 0
