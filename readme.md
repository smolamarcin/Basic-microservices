## Sample application using simple microservises architecture.
This app is created based on a book "Learn microservices with spring boot" by Moses Macero.

To run this app, first you need to build jar for each service, to do this, you need to run:

> ./buildServices.sh

To start, just type (it will create all Docker images and start your application).

> docker-compose up --build

After few minutes, just type in your browser:

> localhost/ui

The User Interface should appears. If you do not see the multiplication components, you have to wait for all services to start.

The full code repository from this book is available here:

> https://github.com/microservices-practical



