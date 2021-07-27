# Getting Started
Simple Spring Boot code REST API generator. 
Generate operation: list, add, delete, save and get item by id.
1. Run GeneratorExampleApplication.
2. Go to URL http://localhost:8080/swagger-ui.html
3. Try generate code. Example cfg_file = movie.
4. Stop application.
5. Run ExampleApplication.
6. Go to URL http://localhost:8080/swagger-ui.html

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Spring boot H2 Database example](https://java2blog.com/spring-boot-h2-database/)

### Default properties
* spring.datasource.url=jdbc:h2:mem:testdb
* spring.datasource.driverClassName=org.h2.Driver
* spring.datasource.username=sa
* spring.datasource.password=[no pass]
* spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

