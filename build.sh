# Stop Docker container
docker stop cloudant-java

# Remove Docker container
docker rm cloudant-java

# Remove all untagged images
docker rmi $(docker images -q --filter "dangling=true")

# Build
docker build -t filipecorrea/cloudant-java .

# Run
docker run --name cloudant-java -d -p 4567:4567 filipecorrea/cloudant-java
