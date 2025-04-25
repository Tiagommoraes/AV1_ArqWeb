# 📦 API REST de Produtos e Categorias - Spring Boot

Este projeto consiste em uma API RESTful desenvolvida com Spring Boot, com duas entidades principais: Produto e Categoria, implementadas conforme os critérios da avaliação prática.

---

## ✅ Passos de Implementação

- 🔧 1. Configuração do Ambiente

- Banco de dados: MariaDB instalado via XAMPP

- IDE utilizada: Visual Studio Code / IntelliJ

- Dependências adicionadas no projeto Spring Boot:

- Spring Web

- Spring Data JPA

- Lombok

- Spring Boot DevTools

Arquivo application.yml configurado com:

```bash

spring:
  sql:
    init:
      mode: always 
  datasource: 
    url: jdbc:mariadb://localhost:3306/produtos 
    driverClassName: org.mariadb.jdbc.Driver 
    username: "root"
    password: "" 
    
  jpa:
    hibernate:
      ddl-auto: update 
    show-sql: true 
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MariaDBDialect
        
  ```
---

## 🧩 2. Definição das Entidades

📁 Categoria.java

- id: identificador único da categoria

- nome: nome da categoria

- Mapeada com @Entity e @OneToMany(mappedBy = "categoria")

📁 Produto.java
- id, nome, descricao, preco

- Relacionamento com Categoria via @ManyToOne e @JoinColumn(name = "categoria_id")

- Ambas utilizam Lombok (@Data, @AllArgsConstructor, @NoArgsConstructor) para gerar getters, setters, toString e construtores.

---

## 🔗 3. Relacionamento entre Entidades

- Um Produto pertence a uma Categoria (@ManyToOne)

- Uma Categoria pode ter vários Produtos (@OneToMany)

- As chaves estrangeiras são automaticamente gerenciadas pelo JPA via @JoinColumn

---

💾 4. Persistência e Repositórios

Foram criadas interfaces que estendem JpaRepository para ambas as entidades:

```bash

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}

```
🌐 5. Endpoints REST

Foram implementados controladores REST para cada entidade com os seguintes endpoints:

Produtos

| Método	|    Endpoint    |	       Ação             |
|---------|----------------|--------------------------|
| GET	    |  /produtos	   | Listar todos os produtos |
| GET	    | /produtos/{id} |	Buscar por ID           |
| POST	  | /produtos	     |  Criar novo produto      |
| PUT	    | /produtos/{id} |  Atualizar produto       |
| DELETE	| /produtos/{id} | Remover por ID           |
| DELETE	| /produtos	     | Remover todos os produtos|

Categorias

| Método	|    Endpoint    |	       Ação               |
|---------|----------------|----------------------------|
| GET	    |  /categorias	   | Listar todos os produtos |
| GET	    | /categorias/{id} |	Buscar por ID           |
| POST	  | /categorias	     |  Criar novo produto      |
| PUT	    | /categorias/{id} |  Atualizar produto       |
| DELETE	| /categorias/{id} | Remover por ID           |
| DELETE	| /categorias	     | Remover todos os produtos|

---

🧪 6. Testes com Postman

Criar Categoria

```bash

POST /categorias
{
  "nome": "Celulares"
}

```

Criar Produto

```bash
POST /produtos
{
  "nome": "iPhone 14",
  "descricao": "128GB, Super Retina XDR",
  "preco": 5499.90,
  "categoria": {
    "id": 1
  }
}

```

Atualizar Produto

```bash

PUT /produtos/1
{
  "nome": "iPhone 14 Pro",
  "descricao": "128GB, Super Retina, 3 câmeras",
  "preco": 6499.90,
  "categoria": {
    "id": 1
  }
}
```
---

✅ Requisitos Atendidos

 - Relacionamento funcional entre as entidades no banco MariaDB

 - Lombok em todas as classes

 - CRUD completo para Produto e Categoria

 - Validação e testes feitos via Postman e console SQL

---

🧠 Considerações Finais

Este projeto demonstra o uso de boas práticas em APIs REST com Java e Spring Boot, aplicando corretamente os conceitos de entidades relacionais, repositórios JPA, Lombok, e testes com Postman. Toda a estrutura está modularizada e preparada para expansão.

---
