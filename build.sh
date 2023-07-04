#!/bin/bash

dist=/c/_DEV/_vagrant_workspace/data

mvn clean install -DskipTests

# cp user-storage-jpa/conf/quarkus.properties $dist/conf
# cp user-storage-jpa/target/tobe-user-storage-jpa.jar $dist/providers
cp target/tobe-user-storage-jpa.jar $dist
