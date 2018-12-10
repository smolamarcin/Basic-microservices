#!/bin/bash

function buildPackage(){
 ./mvnw package -DskipTests
}

echo "building service-registry"
cd "service-registry"
buildPackage

echo "Running gateway service"
cd ..
cd gateway/ && buildPackage

echo "Running other microservices"

cd ..
cd social-multiplication/ && buildPackage
cd ..
cd gamification/ && buildPackage
