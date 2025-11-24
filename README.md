# 📘 Sistema de Biblioteca – Java + JDBC + PostgreSQL

## 📚 Sobre o Projeto
Este projeto é um **Sistema de Biblioteca** desenvolvido em **Java**, utilizando **JDBC** para comunicação com o banco de dados PostgreSQL.

Ele permite:
- Cadastro de livros  
- Empréstimos  
- Cálculo automático de multas  
- Listagem de livros emprestados  
- Controle de datas de retirada e devolução  

O sistema está estruturado em camadas como **DTO**, **DAO** e utilitários para conexão.

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Descrição |
|-----------|-----------|
| **Java 17+** | Linguagem principal do projeto |
| **JDBC** | Acesso ao banco |
| **PostgreSQL** | Banco de dados |
| **Maven** | Gerenciador de dependências |
| **IntelliJ IDEA** | IDE recomendada |
| **DBeaver** | Visualização/gerenciamento do banco |

---

## 🗂 Estrutura do Projeto

- src/
- ├─ LeadBio/Biblioteca/
- │ ├─ BancoDB/
- │ │ └─ ConexaoDB.java
- │ ├─ ComandosDAO/
- │ │ ├─ EmprestarDAO.java
- │ │ ├─ ListarEmprestadosDAO.java
- │ │ └─ Outros DAOs...
- │ ├─ DTO/
- │ │ └─ BiblioDTO.java
- │ └─ Service/
- │ │  └─BlibioService
- └─ Main.java


---

## 🛠 Requisitos

- **Java 17+**
- **PostgreSQL instalado**
- **DBeaver (opcional)**
- **Maven**
- Dependência JDBC no `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.8</version>
</dependency>
```

## ▶ Como Executar
1. Clonar o repositório
- git clone https://github.com/Matheus-art66/Biblioteca_java

2. Compilar
- mvn clean install

3. Executar
- mvn exec:java

- **Ou rodar a classe Main no IntelliJ.**
