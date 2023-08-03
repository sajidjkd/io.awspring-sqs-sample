# spring-cloud-messaging-sample

## A Simple Localstack and Spring Cloud Messaging Integration
The application uses _Spring Cloud Messaging_ to create two modules. 
* A simple _producer_ that puts messages/events on an _SNS_ topic.
* Two _consumers_ that listen to the _SQS_ queues that are subscribed to the _SNS_ topic.

The application demonstrates how Spring integration allows us to create a _SNS_ producer and _SQS_ listener with little code and configuration. 
The cherry on the top is _LocalStack_. Instead of connecting to actual AWS account we connect to a LocalStack server that provides us with all the services that we need for the application.

## About Localstack
_LocalStack_ is a fully functional local AWS cloud stack. It provides an easy-to-use test/mocking framework for developing Cloud applications.

You can checkout more about [here](https://github.com/localstack/localstack).


## Requirements

* `Java` (11 or greater)
* `Spring Boot` (Starting from 2.4.7)
* `Docker` and `docker-compose` (service running)

## Running the application
* Run the LocalStack container. `docker-compose up`

* Create resources on the LocalStack server. We need one SQS queue for this application.


To create the queues:

```
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name order-queue
```

To verify you can list queues:

```
aws --endpoint-url=http://localhost:4566 sqs list-queues
```

* Run the application using `mvn spring-boot:run`

```
Examples References:
https://reflectoring.io/spring-cloud-aws-sqs/
https://howtodoinjava.com/maven/maven-parent-child-pom-example/
https://medium.com/@anujpatel2809/spring-boot-with-sqs-localstack-46b3b8c79e80
https://auth0.com/blog/spring-cloud-messaging-with-aws-and-localstack/
https://reflectoring.io/spring-dynamodb/
```
