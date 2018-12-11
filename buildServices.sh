#!/bin/bash

function buildPackage(){
 ./mvnw package
}

echo "building service-registry"
cd "service-registry"
buildPackage

echo "Running gateway service"
cd ..
cd gateway/ && buildPackage

echo "Building other microservices"

cd ..
cd multiplication/ && buildPackage
cd ..
cd gamification/ && buildPackage
