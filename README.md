Sistema Escolar API 📚
Esta API foi desenvolvida como parte do Check Point 2 da disciplina de Microservices and Web Engineering (2026). O objetivo do projeto é evoluir uma aplicação Spring Boot para uma API RESTful completa, com persistência de dados em um banco de dados relacional (MySQL) utilizando Docker.  

🚀 Tecnologias Utilizadas
Java 24 (OpenJDK)  

Spring Boot 4.0.3

  

Spring Data JPA

  

MySQL 9.7

  

Docker

  

Swagger/OpenAPI 3.0 (Documentação)  

Maven (Gerenciador de dependências)  

📋 Requisitos do Projeto
A aplicação atende aos seguintes critérios técnicos:

Entidades: Possui as entidades Aluno e Curso, cada uma com pelo menos 5 atributos e mapeamento para tabelas no plural (alunos e cursos).  

Persistência: Implementação de JpaRepository para ambas as entidades.  

CRUD Completo: Endpoints para Criar, Ler (Buscar todos e por ID), Atualizar e Deletar.  

Porta: A aplicação está configurada para rodar obrigatoriamente na porta 8080.  

🛠️ Como Executar a Aplicação
1. Subir o Banco de Dados (Docker)
Para que a API funcione corretamente, é necessário subir uma instância do MySQL via Docker. Utilize o comando abaixo para iniciar o container:

Bash
docker run -d --name mysql --rm -e MYSQL_ROOT_PASSWORD=root_pwd -e MYSQL_USER=new_user -e MYSQL_PASSWORD=my_pwd -p 3306:3306 mysql
Nota: O banco de dados será criado automaticamente com o nome api (conforme configurado no application.properties).

2. Executar a API
Certifique-se de que a porta 8080 está livre em sua máquina. No diretório raiz do projeto, execute:

Bash
mvn spring-boot:run
3. Acessar a Documentação (Swagger)
Com a aplicação rodando, você pode testar todos os endpoints e visualizar os modelos de dados através do Swagger UI no link:

http://localhost:8080/swagger-ui.html

🏗️ Estrutura de Endpoints
Alunos
GET /alunos: Lista todos os alunos registrados.

GET /alunos/{id}: Busca um aluno específico pelo ID.

POST /alunos: Registra um novo aluno.

PUT /alunos/{id}: Atualiza os dados de um aluno existente.

DELETE /alunos/{id}: Remove um aluno do sistema.

Cursos
GET /cursos: Lista todos os cursos registrados.

GET /cursos/{id}: Busca um curso específico pelo ID.

POST /cursos: Registra um novo curso.

PUT /cursos/{id}: Atualiza os dados de um curso existente.

DELETE /cursos/{id}: Remove um curso do sistema.

👥 Autores
David - Repositório GitHub

Professor: Antonio Carlos de Lima Júnior  

FIAP - 2026
