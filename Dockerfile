FROM openjdk:12
ADD target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar docker-spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker-spring.jar"]