# API para Sistema de Gestão de Clínicas Médicas

## Descrição do Projeto

Este projeto consiste em uma API REST desenvolvida em Java com Spring Boot para gerenciar informações em um sistema de gestão de clínicas médicas. A API oferece operações CRUD (Create, Read, Update, Delete) para as entidades Paciente, Médico e Consulta, permitindo o cadastro, consulta, atualização e exclusão de dados relacionados a essas entidades. Além disso, a API utiliza autenticação e autorização fornecidas pelo Spring Security com a biblioteca Auth0 Java JWT para garantir a segurança e o controle de acesso aos recursos da aplicação.


## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- Auth0 Java JWT
- MySQL
- Padrões de Projeto: SOLID, Design Patterns
- Swagger 


## Documentação da API

A documentação da API foi elaborada utilizando o Swagger, uma ferramenta que facilita a visualização e interação com os endpoints disponíveis na aplicação. Abaixo está o link para acessar a documentação da API:

[Documentação da API - Swagger](http://localhost:8080/swagger-ui/index.html#)

### Para a Entidade Paciente:

- **Criação de Paciente:** Permite adicionar novos pacientes ao sistema através de requisições POST.
```json
{
  "nome": "string",
  "email": "string",
  "telefone": "27751885965",
  "cpf": "21873980072",
  "endereco": {
    "logradouro": "string",
    "bairro": "string",
    "cep": "81866934",
    "cidade": "string",
    "uf": "string",
    "complemento": "string",
    "numero": "string"
  }
}
```
- **Consulta de Paciente:** Permite recuperar informações de pacientes cadastrados no sistema através de requisições GET.
  
  ```json
    {
    "page": 0,
    "size": 20,
    "sort": [
      "string"
    ]
  }

- **Atualização de Paciente:** Permite atualizar informações de pacientes existentes no sistema através de requisições PUT.

```json
  {
  "id": 0,
  "nome": "string",
  "telefone": "string",
  "endereco": {
    "logradouro": "string",
    "bairro": "string",
    "cep": "61648920",
    "cidade": "string",
    "uf": "string",
    "complemento": "string",
    "numero": "string"
  }
}
```

- **Exclusão de Paciente:** Permite remover pacientes do sistema através de requisições DELETE.

```json
  {
 /pacientes/id
}
```


### Para a Entidade Médico:

- **Criação de Médico:** Permite adicionar novos médicos ao sistema através de requisições POST.

  ```json
      {
    "nome": "string",
    "email": "string",
    "telefone": "48041816063",
    "crm": "398428",
    "especialidade": "ORTOPEDIA",
    "endereco": {
      "logradouro": "string",
      "bairro": "string",
      "cep": "63121042",
      "cidade": "string",
      "uf": "string",
      "complemento": "string",
      "numero": "string"
    }
  }
  ```
- **Consulta de Médico:** Permite recuperar informações de médicos cadastrados no sistema através de requisições GET.

  ```json
     {
  "page": 0,
  "size": 1,
  "sort": [
    "string"
  ]
  }
  ```
  
- **Atualização de Médico:** Permite atualizar informações de médicos existentes no sistema através de requisições PUT.
   ```json
     {
  "id": 0,
  "nome": "string",
  "telefone": "string",
  "endereco": {
    "logradouro": "string",
    "bairro": "string",
    "cep": "30697252",
    "cidade": "string",
    "uf": "string",
    "complemento": "string",
    "numero": "string"
    }
  }
  ```
  
- **Exclusão de Médico:** Permite remover médicos do sistema através de requisições DELETE.
  ```json
  {
    medicos/{id}
  }
  ```

  **Consulta de Médico por id:** Permite recuperar informações de um médico cadastrado no sistema através de requisições GET passando o Id como parâmentro .

  ```json
  {
    medicos/{id}
  }
  ```



### Para a Entidade Consulta:

- **Agendamento de Consulta:** Permite agendar consultas entre médicos e pacientes, registrando a data e hora da consulta através de requisições POST.

  ```json
  {
  "idMedico": 0,
  "idPaciente": 0,
  "data": "2024-03-19T00:21:56.693Z",
  "especialidade": "ORTOPEDIA"
  }
  ```
  
- **Cancelamento de Consulta:** Permite cancelar consultas agendadas no sistema através de requisições DELETE.

  ```json
  {
  "idConsulta": 0,
  "motivo": "PACIENTE_DESISTIU"
  }
  ```



### Funcionalidades Adicionais:

- **Autenticação e Autorização:** Utiliza o Spring Security juntamente com a biblioteca Auth0 Java JWT para garantir a segurança e autenticação na API REST. Isso proporciona um ambiente confiável para a gestão de identidades e o controle de acesso, garantindo que apenas usuários autorizados tenham acesso aos recursos da aplicação.

  ```json
  {
  "login": "string",
  "senha": "string"
  }
  ```
- **Padrão DTO (Data Transfer Object):** Utiliza o padrão DTO para transferência de dados entre as camadas de persistência e serviço, oferecendo uma estrutura organizada e eficiente para o desenvolvimento da API.



## Como Executar o Projeto

1. Clone este repositório ou faça o download dos arquivos para sua máquina local.
2. Abra o projeto na sua IDE Java preferida.
3. Compile o projeto para garantir que não haja erros de compilação.
4. Execute a aplicação.

