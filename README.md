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

## Exemplos de Endpoints

- `POST /veiculos`  
  Cadastra um novo veículo.

- `GET /veiculos/{id}`  
  Busca veículo por ID.

- `GET /veiculos`  
  Lista todos os veículos.

- `DELETE /veiculos/{id}`  
  Remove veículo por ID.

---

Projeto desenvolvido para fins de estudo e demonstração de boas práticas com Spring Boot.
