# SpringAPI-Faculdade
grupo: Ruaney, Rauni e Bernardo
## Requisitos de Ambiente

Para executar este projeto, você precisará das seguintes ferramentas instaladas no seu sistema:

- [Git](https://git-scm.com/downloads)
- [Docker](https://www.docker.com/get-started)
- [Postman](https://www.postman.com/downloads/)

## Passo a Passo para Execução Local

Siga estes passos para executar a API localmente:

### 1. Clonar o Repositório

```bash
git clone https://github.com/seuusuario/SpringAPI-Faculdade.git
cd SpringAPI-Faculdade
```

### 2. Construir a Imagem Docker

```bash
docker build -t springapi-faculdade .
```

### 3. Executar a API usando Docker

```bash
docker run -d -p 8080:8080 springapi-faculdade
```

A API deve estar rodando e acessível em `http://localhost:8080`.

## Consumo da API com Postman

Para testar os endpoints da API:

### 1. Importar a Coleção do Postman

1. Abra o Postman
2. Clique em "Importar" no canto superior esquerdo
3. Selecione o arquivo `SpringAPI-Faculdade.postman_collection.json` do diretório do projeto

### 2. Executar Cenários de Teste

A coleção importada contém os seguintes cenários de teste:

- **Criar Novo Pedido**: Cria um novo pedido.
- **Processar Descontos**: Processa os descontos para um pedido específico.
- **Consultar Pedido**: Consulta os detalhes de um pedido específico.
- **Cadastrar Cliente**: Cadastra um novo cliente.

Para executar um teste:

1. Selecione a requisição desejada da coleção
2. Clique no botão "Enviar"
3. Veja a resposta no painel inferior

## Execução da API usando Docker Hub

Se você preferir executar a API diretamente do Docker Hub:

### 1. Puxar a Imagem Docker

```bash
docker pull eurru/springapi-faculdade:latest
```

### 2. Executar a API usando Docker

```bash
docker run -d -p 8080:8080 eurru/springapi-faculdade
```

A API estará acessível em `http://localhost:8080`.

## Endpoints da API

### Criar Pedido

- **URL**: `/pedidos`
- **Método**: `POST`
- **Descrição**: Cria um novo pedido.
- **Corpo da Requisição**: JSON representando o pedido.

### Processar Descontos

- **URL**: `/pedidos/{pedidoId}/processar-descontos`
- **Método**: `POST`
- **Descrição**: Processa os descontos para um pedido específico.

### Consultar Pedido

- **URL**: `/pedidos/{pedidoId}`
- **Método**: `GET`
- **Descrição**: Consulta os detalhes de um pedido específico.

### Cadastrar Cliente

- **URL**: `/clientes`
- **Método**: `POST`
- **Descrição**: Cadastra um novo cliente.
- **Corpo da Requisição**: JSON representando o cliente.

---
