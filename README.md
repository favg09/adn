
1. Descargue el programa desde github 
https://github.com/favg09/adn

2. Una vez descargado, éste puede ser importado en su IDE (p.e. Eclipse) como un proyecto maven. (Este paso no es mandatorio)

3. Compile el proyecto usando el comando:
mvn clean package

o utilice el build de su IDE. (Nota: utilice Java 8)

4. Ejecute la clase com.magneto.adn.AdnApplication.java 

5. Usando CURL o alguna aplicación para el testing de API REST, invoque el siguiente servicio: 

http://localhost:8080/mutant

curl --location --request POST 'http://localhost:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna":["TTGCGA","CAGTGC","TTATGT","AGAAAG","CACCTA","TCACTG"]
}'

POST → /mutant/
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","CCCATA"]
}

La respuesta en caso de verificar un mutante será un HTTP 200-OK, en caso contrario un 403-Forbidden

6. Cada vez que se invoque el servicio /mutant/, se almacenará en la base de datos el resultado del analisis realizado sobre el ADN. La estadisticas puedes ser consultadas mediante el siguiente servicio:

http://localhost:8080/stats
(No parametros)

curl --location --request POST 'http://localhost:8080/stats'

La respuesta será un JSon con el siguiente formato:
{
    "count_mutant_dna": 2.0,
    "count_human_dna": 4.0,
    "ratio": 0.5
}

7. Para ejecutar los servicios hosteados en Google Cloud, utilice las siguientes URLs de la misma forma que en los numerales 5 y 6:

https://green-analog-308419.rj.r.appspot.com/mutant

curl --location --request POST 'https://green-analog-308419.rj.r.appspot.com/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","CCCCTA"]
}'


https://green-analog-308419.rj.r.appspot.com/stats

curl --location --request POST 'https://green-analog-308419.rj.r.appspot.com/stats' \
--data-raw ''


