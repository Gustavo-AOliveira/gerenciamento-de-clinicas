# API para Sistema de Clínicas - Back-End em Java com Spring Boot, JPA, Spring Security e a biblioteca Auth0

Este é o repositório do projeto de uma API RESTful em Java, desenvolvido com o framework Spring Boot e JPA, utilizando padrões DTO (Data Transfer Object) para a comunicação e interação com o banco de dados MySQL. A API é destinada para um sistema de clínicas, permitindo a gestão de informações e operações relacionadas ao funcionamento das clínicas, seguindo os padrões do protocolo HTTP.

## Descrição do Projeto

O projeto consiste em uma API REST que permite realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados MySQL, para gerenciar informações de clínicas, médicos, pacientes e outros recursos pertinentes a um sistema de clínicas. A arquitetura do projeto segue o padrão DTO, que permite a transferência de dados entre a camada de persistência (banco de dados) e a camada de serviços (controladores da API) de forma organizada e eficiente.
Além disso, o projeto utiliza o Spring Security juntamente com a biblioteca Auth0 Java JWT para garantir a segurança e autenticação na API REST. Essa combinação oferece um ambiente confiável para a gestão de identidades e controle de acesso, garantindo que apenas usuários autorizados tenham acesso aos recursos da aplicação.

Utiliza o framework Spring Boot, que agiliza o processo de desenvolvimento, facilitando a configuração e a criação de aplicações Java. O tratamento de exceções também foi implementado para garantir uma experiência mais robusta.

## Funcionalidades

A API REST desenvolvida possui as seguintes funcionalidades:

- **Criar:** Permite adicionar novas informações relacionadas a clínicas, médicos, pacientes e outros recursos através de requisições POST.
- **Consultar:** Permite recuperar informações do banco de dados relacionadas aos recursos mencionados através de requisições GET.
- **Atualizar:** Permite atualizar registros existentes no banco de dados através de requisições PUT.
- **Excluir:** Permite excluir registros do banco de dados através de requisições DELETE.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

1. Kit de Desenvolvimento Java (JDK) versão 17 ou superior.
2. MySQL Server.
3. Uma ferramenta de desenvolvimento Java de sua preferência (Eclipse, IntelliJ, etc.).

## Como Executar o Projeto

1. Clone este repositório para sua máquina local ou faça o download dos arquivos.
2. Abra o projeto na sua IDE Java preferida (como Eclipse, IntelliJ, NetBeans, etc.).
3. Compile o projeto para garantir que não haja erros de compilação.
4. Execute a aplicação.
