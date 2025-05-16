# 📋 people-registration

## 🧾 Visão Geral

O **people-registration** é um sistema desenvolvido em Java com o objetivo de gerenciar o cadastro de pessoas.  
Ele oferece funcionalidades para adicionar, atualizar, listar e remover registros de indivíduos, sendo ideal para aplicações que necessitam de um controle eficiente de dados pessoais.

## 🚀 Funcionalidades

- Cadastro de novas pessoas com informações detalhadas.
- Atualização de dados existentes.
- Listagem completa dos registros cadastrados.
- Remoção de registros específicos.

## 🛠️ Tecnologias Utilizadas

- **Java 11+**
- **Maven** para gerenciamento de dependências.
- **Spring Boot** como framework principal.
- **Docker** para conteinerização da aplicação.
- **Swagger** para documentação da API.

## 📦 Instalação

### Pré-requisitos

- Java 11 ou superior instalado.
- Maven instalado.
- Docker (opcional, para execução em contêiner).

### Passos para execução

1. Clone o repositório:

```bash
git clone https://github.com/kurata/people-registration.git
cd people-registration
```

2. Compile o projeto:
```bash
mvn clean install
```
3. Execute a aplicação:
```bash
mvn spring-boot:run
```
4. Acesse a aplicação em: http://localhost:8080

### Utilizando Docker
Para executar a aplicação em um contêiner Docker:

1. Construa a imagem Docker:
```bash
docker build -t people-registration .
```
2. Execute o contêiner:
```bash
docker run -p 8080:8080 people-registration
```
#### 🔧 Variáveis de Ambiente

Você pode sobrescrever as configurações padrão utilizando a opção `-e` no comando `docker run`, ou definindo no `docker-compose.yml`.

| Variável de Ambiente  | Descrição                                      | Valor Padrão                                             |
|-----------------------|------------------------------------------------|----------------------------------------------------------|
| `MONGO_URL`           | URL de conexão com o banco de dados MongoDB    | `mongodb://pr_mongodb:27017/people-registration`         |
| `POSTGRESQL_URL`      | URL de conexão com o banco de dados            | `jdbc:postgresql://pr_postgres:5432/people-registration` |
| `POSTGRESQL_USER`     | Usuário do banco de dados                      | `apppr`                                                  |
| `POSTGRESQL_PASSWORD` | Senha do banco de dados                        | `pswpr`                                                  |
| `RABBIT_HOST`         | Host de conexão com o Rabbit MQ                | `pr_rabbitmq`                                            |
| `RABBIT_PORT`         | Porta de conexão com o Rabbit MQ               | `5672`                                                   |
| `RABBIT_USER`         | Usuário do Rabbit MQ                           | `guest`                                                  |
| `RABBIT_PASSWORD`     | Senha do Rabbit MQ                             | `guest`                                                  |

#### 🧩 Exemplo com docker-compose.yml

```bash
version: '3.8'
services:
  people-registration:
    image: people-registration
    ports:
      - "8080:8080"
    environment:
      MONGO_URL: mongodb://pr_mongodb:27017/people-registration
      POSTGRESQL_URL: jdbc:postgresql://pr_postgres:5432/people-registration
      POSTGRESQL_USER: apppr
      POSTGRESQL_PASSWORD: pswpr
      RABBIT_HOST: pr_rabbitmq
      RABBIT_PORT: 5672
      RABBIT_USER: guest
      RABBIT_PASSWORD: guest
```

## 📚 Documentação da API
A documentação interativa da API está disponível via Swagger em:

http://localhost:8080/swagger-ui.html

Ela fornece detalhes sobre os endpoints disponíveis, parâmetros esperados e exemplos de requisições/respostas.
