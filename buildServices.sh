#!/bin/bash



echo "building service-registry"
cd ..
cd service-registry/ && ./mvnw package

echo "Running gateway service"
cd ..
cd gateway/ && ./mvnw package

echo "Running other microservices"

cd ..
cd social-multiplication/ && ./mvnw package
cd ..
cd gamification/ && ./mvnw package
