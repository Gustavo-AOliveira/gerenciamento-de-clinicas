# API para Sistema de Gestão de Clínicas Médicas

## Descrição do Projeto

Este projeto consiste em uma API REST desenvolvida em Java com Spring Boot para gerenciar informações em um sistema de gestão de clínicas médicas. A API oferece operações CRUD (Create, Read, Update, Delete) para as entidades Paciente, Médico e Consulta, permitindo o cadastro, consulta, atualização e exclusão de dados relacionados a essas entidades. Além disso, a API utiliza autenticação e autorização fornecidas pelo Spring Security com a biblioteca Auth0 Java JWT para garantir a segurança e o controle de acesso aos recursos da aplicação.

## Funcionalidades

### Para a Entidade Paciente:

- **Criação de Paciente:** Permite adicionar novos pacientes ao sistema através de requisições POST.
- **Consulta de Paciente:** Permite recuperar informações de pacientes cadastrados no sistema através de requisições GET.
- **Atualização de Paciente:** Permite atualizar informações de pacientes existentes no sistema através de requisições PUT.
- **Exclusão de Paciente:** Permite remover pacientes do sistema através de requisições DELETE.

### Para a Entidade Médico:

- **Criação de Médico:** Permite adicionar novos médicos ao sistema através de requisições POST.
- **Consulta de Médico:** Permite recuperar informações de médicos cadastrados no sistema através de requisições GET.
- **Atualização de Médico:** Permite atualizar informações de médicos existentes no sistema através de requisições PUT.
- **Exclusão de Médico:** Permite remover médicos do sistema através de requisições DELETE.

### Para a Entidade Consulta:

- **Agendamento de Consulta:** Permite agendar consultas entre médicos e pacientes, registrando a data e hora da consulta através de requisições POST.
- **Consulta de Consulta:** Permite recuperar informações das consultas agendadas no sistema através de requisições GET.
- **Cancelamento de Consulta:** Permite cancelar consultas agendadas no sistema através de requisições DELETE.

### Funcionalidades Adicionais:

- **Autenticação e Autorização:** Utiliza o Spring Security juntamente com a biblioteca Auth0 Java JWT para garantir a segurança e autenticação na API REST. Isso proporciona um ambiente confiável para a gestão de identidades e o controle de acesso, garantindo que apenas usuários autorizados tenham acesso aos recursos da aplicação.
- **Padrão DTO (Data Transfer Object):** Utiliza o padrão DTO para transferência de dados entre as camadas de persistência e serviço, oferecendo uma estrutura organizada e eficiente para o desenvolvimento da API.
- **Operações CRUD:** Fornece operações básicas de CRUD para cada entidade, permitindo uma gestão completa das informações do sistema.


## Como Executar o Projeto

1. Clone este repositório ou faça o download dos arquivos para sua máquina local.
2. Abra o projeto na sua IDE Java preferida.
3. Compile o projeto para garantir que não haja erros de compilação.
4. Execute a aplicação.

