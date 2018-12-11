## Sample application using simple microservises architecture.
This app is created based on a book "Learn microservices with spring boot" by Moses Macero.

### Requirements
In order to run, you need:
> JDK 1.8
> Docker

To check is docker properly installed, try to run in your terminal:
> docker run hello-world

### Running application
To run this app, first you need to build jar for each service, to do this, you need to run:

> ./buildServices.sh

Or build each jar manually (eg ./mvnw package).

To start, just type (it will create all Docker images and start your application).

> docker-compose up --build

After few minutes, just type in your browser:

> localhost/ui

The User Interface should appears. If you do not see the multiplication components, you have to wait for all services to start.

The full code repository from this book is available here:

> https://github.com/microservices-practical



