#!/bin/bash
printf 'Building projects...\n'
mvn clean package -B -DskipTests

printf '\nBuilding containers...\n'
docker-compose build

printf '\nStarting containers...\n'
docker-compose down && docker-compose up -d

printf '\nDone!\n'
