# Vendas Application
Projeto do curso de Spring Boot Api Rest, Jpa e Jwt

* Pre Requisitos

    Java 11
    
    Docker

    MariaDB com HSQL ou PowerBranch

Comando para baixar e rodar o mariaDB


NÃO FUNCIONA NESSA IMAGEM. PRECISA CONFIGURAR CONFORME DOCUMENTACAO.
Use o mariadb.

docker run --detach --name mariadb -p 3306:3306 --env MARIADB_USER=root --env MARIADB_PASSWORD=1234 --env MARIADB_ROOT_PASSWORD=1234  mariadb:latest


# Teste

API de cliente

curl --location --request POST 'localhost:8080/api/clientes/' \
--header 'Content-Type: application/json' \
--data-raw '{
"nome" : "Junior",
"cpf" : "42756661864"
}'


API de Produto

curl --location --request POST 'localhost:8080/api/produtos/' \
--header 'Content-Type: application/json' \
--data-raw '{
"descricao" : "IPhone",
"preco" : 10000.00
}'


API de Pedidos

curl --location --request POST 'localhost:8080/api/pedidos/' \
--header 'Content-Type: application/json' \
--data-raw '{
"cliente": 1,
"total": 10000.00,
"items":
[
{
"produto": 2,
"quantidade": 1
}
]
}'


PATH

curl --location --request PATCH 'localhost:8080/api/pedidos/3' \
--header 'Content-Type: application/json' \
--data-raw '{
"novoStatus" : "CANCELADO"
}'

AUTORIZATION
POST USER

curl --location --request POST 'localhost:8080/api/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
"login":"adcorrea",
"senha":"1234",
"admin":true
}'


POST TOKEN

curl --location --request POST 'localhost:8080/api/usuarios/auth' \
--header 'Content-Type: application/json' \
--data-raw '{
"login" : "adcorrea",
"senha" : "1234"
}'



SWAGGER

http://localhost:8080/swagger-ui.html


comando para gerar JAR

mvn clean package

com perfil

mvn clean package -P dev ou prod


rodar o jar

java -jar .\vendas-0.0.1-SNAPSHOT.jar