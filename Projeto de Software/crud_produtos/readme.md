# Sistema de Gerenciamento de Produtos

Este projeto consiste em uma aplicação web desenvolvida com Spring Boot, utilizando o padrão arquitetural MVC (Model-View-Controller). A aplicação permite o gerenciamento completo de categorias e produtos, implementando operações de CRUD (Create, Read, Update, Delete).

---
### ➤ Tecnologias Utilizadas
- Java + Spring Boot
- Spring Web
- Spring Data JPA
- Thymeleaf
- MySQL
- DevTools
- IntelliJ IDEA
---
### ➤ Arquitetura

O sistema foi estruturado seguindo o padrão MVC, dividido nas seguintes camadas:

- Model: Representação das entidades do sistema
- Repository: Comunicação com o banco de dados
- Service: Regras de negócio
- Controller: Controle das requisições
- View: Interface com o usuário (Thymeleaf)
---
###  ➤ Funcionalidades do sistema
- Categoria:
    - cadastro, listagem, edição e exclusão
- Produto: 
    - cadastro, listagem, edição e exclusão
---
### ➤ Regras de Negócio
- Categoria
    - id (gerado automaticamente)
    - nome (obrigatório e único)
    - Restrição: Uma categoria não pode ser excluída caso esteja vinculada a algum produto
- Produto
    - id (gerado automaticamente)
    - nome (obrigatório e único)
    - descrição
    - valor (deve ser maior que zero)
    - quantidade
    - categoria (deve ser previamente cadastrada)
    - imagem (endereço/URL da imagem)

---

### ➤ Executar o Projeto
- Clone o repositório:
- Configure o banco de dados no arquivo application.properties
- Execute a aplicação pelo IntelliJ ou via terminal:
- Acesse no navegador: http://localhost:8080

---

### ➤ Observações
- O sistema valida campos obrigatórios e regras de unicidade
- Tratamento de erros foi implementado para melhorar a experiência do usuário
- Imagens dos produtos são armazenadas via caminho informado

---
