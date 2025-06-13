# VeiculoCheck

Projeto Spring Boot para cadastro, consulta e verificação de veículos, integrando com uma API externa para validação de dados.

## Funcionalidades

- **Cadastro de Veículo:**  
  Permite cadastrar um novo veículo informando a placa. Os demais dados (marca, modelo, chassi, licenciamento) são buscados automaticamente em uma API externa.
- **Consulta de Veículo por ID:**  
  Permite buscar um veículo cadastrado pelo seu ID.
- **Listagem de Veículos:**  
  Retorna todos os veículos cadastrados no sistema.
- **Remoção de Veículo:**  
  Permite remover um veículo cadastrado pelo seu ID.

## Estrutura do Projeto

- **controllers/**: Endpoints REST.
- **services/**: Regras de negócio.
- **client/**: Integração com API externa.
- **repository/**: Persistência de dados.
- **domain/entity/**: Entidades JPA.
- **domain/dto/**: DTOs para comunicação.
- **exception/**: Tratamento de exceções.

## Integração com API Externa

Ao cadastrar um veículo, o sistema consulta uma API externa (Mockaroo) para preencher automaticamente os dados do veículo com base na placa informada.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- WebClient (para chamadas HTTP)
- Maven

## Como Executar

1. Clone o repositório.
2. Configure o banco de dados em `application.properties`.
3. Execute o projeto com `mvn spring-boot:run`.
4. Acesse os endpoints via Postman, Insomnia ou outra ferramenta REST.

## Exemplos de Uso dos Endpoints

---

### 1. Cadastrar Veículo

**POST /veiculos**

#### Request
```
POST /veiculos
Response (201 Created)
```

```json
{
  "placa": "ABC1234",
  "proprietario": "Maria Silva",
  "cpf": "123.456.789-00"
}
```
```json
{
  "id": 1,
  "placa": "ABC1234",
  "chassi": "WBAPT73598C125222",
  "proprietario": "Maria Silva",
  "marca": "Dodge",
  "modelo": "Omni",
  "cpf": "123.456.789-00",
  "licenciado": true
}
```

### 2. Buscar Veículo por ID
**GET /veiculos/{id}**
#### Request:

```
GET /veiculos/1
Response (200 OK)
```

```json
{
  "id": 1,
  "placa": "ABC1234",
  "chassi": "WBAPT73598C125222",
  "proprietario": "Maria Silva",
  "marca": "Dodge",
  "modelo": "Omni",
  "cpf": "123.456.789-00",
  "licenciado": true
}

```
### 3. Listar Todos os Veículos
**GET /veiculos**
#### Request:

```
GET /veiculos
Response (200 OK)
```

```json
[
  {
    "id": 1,
    "placa": "ABC1234",
    "chassi": "WBAPT73598C125222",
    "proprietario": "Maria Silva",
    "marca": "Dodge",
    "modelo": "Omni",
    "cpf": "123.456.789-00",
    "licenciado": true
  },
  {
    "id": 2,
    "placa": "XYZ9876",
    "chassi": "JH4KA3260KC123456",
    "proprietario": "João Souza",
    "marca": "Fiat",
    "modelo": "Uno",
    "cpf": "987.654.321-00",
    "licenciado": false
  }
]
```
### 4. Remover Veículo por ID
**DELETE /veiculos/{id}**
#### Request:
```
DELETE /veiculos/1
Response (204 No Content)
```
```
(no body)
```

