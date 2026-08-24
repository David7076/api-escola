# Sistema Escolar API

Esta API foi desenvolvida como parte do Check Point 2 da disciplina de Microservices and Web Engineering (2026). O objetivo do projeto é evoluir uma aplicação Spring Boot para uma API RESTful completa, com persistência de dados em um banco de dados relacional (MySQL) utilizando Docker.

## 📋 Pré-requisitos

Para executar o projeto localmente, você precisará ter instalado:

- Java
- Maven
- MySQL
- Docker (opcional)

---

📋 Requisitos do Projeto
A aplicação atende aos seguintes critérios técnicos:

Entidades: Possui as entidades Aluno e Curso, cada uma com pelo menos 5 atributos e mapeamento para tabelas no plural (alunos e cursos).

Persistência: Implementação de JpaRepository para ambas as entidades.

CRUD Completo: Endpoints para Criar, Ler (Buscar todos e por ID), Atualizar e Deletar.

Porta: A aplicação está configurada para rodar obrigatoriamente na porta 8080.
---

---
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
---

---

## 🚀 Execução local

### 1. Configuração das variáveis de ambiente

A aplicação utiliza variáveis de ambiente para configurar a conexão com o banco de dados e o profile do Spring Boot.

| Variável | Descrição | Exemplo |
|---|---|---|
| `DB_SERVER_URL` | Endereço do servidor do banco de dados | `localhost` |
| `DB_SERVER_PORT` | Porta do banco de dados | `3306` |
| `DB_SCHEMA` | Nome do schema | `dbprd` |
| `DB_USER` | Usuário do banco de dados | `root` |
| `DB_PWD` | Senha do banco de dados | `root_pwd` |
| `SPRING_PROFILES_ACTIVE` | Profile ativo do Spring Boot | `dev` |

### Linux / macOS

```sh
export DB_SERVER_URL=localhost
export DB_SERVER_PORT=3306
export DB_SCHEMA=dbprd
export DB_USER=root
export DB_PWD=root_pwd
export SPRING_PROFILES_ACTIVE=dev
```

### Windows PowerShell

```powershell
$env:DB_SERVER_URL="localhost"
$env:DB_SERVER_PORT="3306"
$env:DB_SCHEMA="dbprd"
$env:DB_USER="root"
$env:DB_PWD="root_pwd"
$env:SPRING_PROFILES_ACTIVE="dev"
```

### 2. Executar a aplicação

Com Maven:

```sh
mvn spring-boot:run
```

Ou utilizando o Maven Wrapper:

```sh
./mvnw spring-boot:run
```

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

## 🐳 Execução com Docker

### 1. Criar a imagem

Na raiz do projeto, execute:

```sh
docker build -t sistema-escolar-api:1.1 .
```

### 2. Executar o container

Caso o banco de dados esteja sendo executado na máquina host, utilize `host.docker.internal` para permitir que o container acesse o banco.

```sh
docker run \
  -p 8080:8080 \
  -e DB_SERVER_URL=host.docker.internal \
  -e DB_SERVER_PORT=3306 \
  -e DB_SCHEMA=db_api \
  -e DB_USER=root \
  -e DB_PWD=root_pwd \
  -e SPRING_PROFILES_ACTIVE=prd \
  sistema-escolar-api:1.1
```

A aplicação ficará disponível em:

```text
http://localhost:8080
```

> **Nota:** `host.docker.internal` permite que o container acesse serviços executados na máquina host. Em ambientes Linux, dependendo da configuração do Docker, pode ser necessário utilizar uma configuração de rede diferente.

---

## ⚙️ Profiles do Spring Boot

O profile ativo da aplicação é definido através da variável de ambiente:

```text
SPRING_PROFILES_ACTIVE
```

### Desenvolvimento

Para executar utilizando o profile `dev`:

```sh
export SPRING_PROFILES_ACTIVE=dev
```

### Produção

Para executar utilizando o profile `prd`:

```sh
export SPRING_PROFILES_ACTIVE=prd
```

Ao executar com Docker:

```sh
docker run \
  -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prd \
  sistema-escolar-api:1.1
```

---

## 🔐 Variáveis de ambiente

As configurações de conexão com o banco de dados devem ser fornecidas através de variáveis de ambiente.

Variáveis utilizadas pela aplicação:

```text
DB_SERVER_URL
DB_SERVER_PORT
DB_SCHEMA
DB_USER
DB_PWD
SPRING_PROFILES_ACTIVE
```

### Exemplo

```text
DB_SERVER_URL=localhost
DB_SERVER_PORT=3306
DB_SCHEMA=dbprd
DB_USER=root
DB_PWD=root_pwd
SPRING_PROFILES_ACTIVE=dev
```

> **Importante:** evite armazenar senhas, tokens ou outras credenciais diretamente no código-fonte ou no repositório Git.

---

## 📦 Docker — comandos úteis

### Criar a imagem

```sh
docker build -t study-api:1.1 .
```

### Executar o container

```sh
docker run \
  -p 8080:8080 \
  -e DB_SERVER_URL=host.docker.internal \
  -e DB_SERVER_PORT=3306 \
  -e DB_SCHEMA=db_api \
  -e DB_USER=root \
  -e DB_PWD=root_pwd \
  -e SPRING_PROFILES_ACTIVE=prd \
  sistema-escolar-api:1.1
```

### Listar containers em execução

```sh
docker ps
```

### Listar todos os containers

```sh
docker ps -a
```

### Parar um container

```sh
docker stop <container_id>
```

### Remover um container

```sh
docker rm <container_id>
```

### Listar imagens

```sh
docker images
```

### Remover uma imagem

```sh
docker rmi sistema-escolar-api:1.1
```

---

## 🔒 Segurança

Não versione credenciais reais no repositório.

Recomenda-se utilizar um arquivo `.env` local para desenvolvimento e adicioná-lo ao `.gitignore`:

```gitignore
.env
```

Para facilitar a configuração de novos ambientes, pode ser criado um arquivo `.env.example`:

```env
DB_SERVER_URL=localhost
DB_SERVER_PORT=3306
DB_SCHEMA=dbprd
DB_USER=root
DB_PWD=root_pwd
SPRING_PROFILES_ACTIVE=dev
```

O arquivo `.env.example` pode ser versionado, enquanto o `.env` contendo credenciais reais deve permanecer fora do repositório.
