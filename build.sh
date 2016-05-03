#!/bin/bash

# Stop Docker container
docker stop cloudant-java

# Remove Docker container
docker rm -f cloudant-java

# Remove all untagged images
docker rmi -f $(docker images -q --filter "dangling=true")

# Build
docker build -t filipecorrea/cloudant-java .

# Run
docker run --name cloudant-java -d -p 80:9080 -p 443:9443 filipecorrea/cloudant-java
