### Spring Boot & RabbitMQ

### Requirements

* JDK 17(openjdk-17)
* Spring Boot 3.0.0
* Maven 3.6.3 or newer
* Docker
* RabbitMQ

### RabbitMQ
    $ docker-compose -f docker-compose.yml up -d
### Execute tests
    $ mvn clean test
### Build App
    $ mvn clean install
### Run App
    $ mvn spring-boot:run