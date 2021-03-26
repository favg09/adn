# Test DNA

## Pasos para la ejecución del proyecto

1. Clone el siguiente repositorio y ubiquese en el branch "develop"
```
https://github.com/favg09/adn
```

2. Una vez descargado, éste puede ser importado en su IDE (p.e. Eclipse) como un proyecto maven.

3. Compile el proyecto usando el comando:
```
mvn clean package
```
o utilice el build de su IDE. (Nota: utilice Java 8)

4. Ejecute la clase com.magneto.adn.AdnApplication.java 

5. Usando CURL o alguna aplicación para el testing de API REST, invoque el siguiente servicio: 
```
http://localhost:8080/mutant
```
o desde una consola de comandos:
```
curl --location --request POST 'http://localhost:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna":["TTGCGA","CAGTGC","TTATGT","AGAAAG","CACCTA","TCACTG"]
}'
```

POST → /mutant/
{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","CCCATA"]
}

{
    "dna":["ATGCGG","CAGTGC","TTAGGT","AGGAGG","CGCCTA","GCACTG"]
}

La respuesta en caso de verificar un mutante será un HTTP 200-OK, en caso contrario un 403-Forbidden

6. Cada vez que se invoque el servicio /mutant/, se almacenará en la base de datos el resultado del analisis realizado sobre el ADN. Las estadisticas pueden ser consultadas mediante el siguiente servicio:
```
http://localhost:8080/stats
(No parametros)
```
o desde una consola de comandos:
```
curl --location --request POST 'http://localhost:8080/stats'
```

La respuesta será un JSON con el siguiente formato:
{
    "count_mutant_dna": 2.0,
    "count_human_dna": 4.0,
    "ratio": 0.5
}

7. Para ejecutar los servicios hosteados en Google Cloud, utilice las siguientes URLs de la misma forma que en los numerales 5 y 6:
```
https://green-analog-308419.rj.r.appspot.com/mutant
```
o desde una consola de comandos:
```
curl --location --request POST 'https://green-analog-308419.rj.r.appspot.com/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{
    "dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","CCCCTA"]
}'
```

```
https://green-analog-308419.rj.r.appspot.com/stats
```
o desde una consola de comandos:
```
curl --location --request POST 'https://green-analog-308419.rj.r.appspot.com/stats' \
--data-raw ''
```


## Comentarios adicionales

- El algoritmo que analiza el ADN para las consultas que tienen que ver con las diagonales de la matriz, sólamente las realiza sobre las dos diagonales mayores de la matriz, por ejemplo (X):
```
X O X
O X O
X O X
```

- No se alcanzan a realizar los test. Se deja instalado el plugin de Jacoco y se hace un test de prueba



 
