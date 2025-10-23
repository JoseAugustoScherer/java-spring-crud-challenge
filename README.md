# java-spring-crud-challenge 🍃

Desafio do curso Spring Boot da [@Devsuperior](https://devsuperior.com.br/)

## Sobre 📢

Desafio simples; implementar APIs para que seja possível fazer as operações de Create, Read, Update, Delete.

Fora usada a anotação **_@Valid_** para realizar as validações dos campos _name_ e _birthDate_. No corpo da resposta, é retornada uma lista contendo as mensagens customizadas de erro, indicando o campo e o motivo.

<img width="652" height="367" alt="image" src="https://github.com/user-attachments/assets/aad8b10d-f313-4dfe-bbdd-178386b9080d" />

Fora utilizado o **_Pageable_** para o método _read_ que retornará todos os Clients. O limite de objetos retornados está _default_, retornando 20 por página.

<img width="655" height="570" alt="image" src="https://github.com/user-attachments/assets/9a6086e3-e959-4bb8-bddc-cfcb00fc6fe0" />


São realizados 40 _inserts_ ao rodar o projeto, o banco de dados utilizado é o H2, que pode ser acessado pela rota **_http://localhost:8080/h2-console_**
