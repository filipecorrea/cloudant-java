# Cloudant

Cloudant and Java application running in WebSphere build with Docker.

## Prerequisites

- [Docker]

## CouchDB

Those steps must be followed to build and run a CouchDB Docker container.

### Build

Create and build a CouchDB container:

```sh
docker build -t couchdb .
```

### Run

Once the image is built, start it with:

```sh
docker run --name couchdb -p 5984:5984 -d couchdb
```

## Application

Those steps must be followed to build and run the Java application Docker container.

### Build

At root directory, run:

```sh
docker build -t filipecorrea/cloudant-java .
```

This will take a while for the first time since it downloads and installs Maven and downloads all the project’s dependencies. Every subsequent start of this build will only take a few seconds, as again everything will be already cached.

You might need to change Docker IP in src/main/java/com/cloudant/CloudantAPI.java so the application can find the CouchDB database:

```java
databaseURL = "http://192.168.99.100:5984";
```

### Run

Once the image is built, start it with:

```sh
docker run --name cloudant-java -d -p 80:9080 filipecorrea/cloudant-java
```

WebSphere takes about a minute to start. Once it's complete, you can test the application running:

```sh
open "http://$(docker-machine ip default)/Sample/SimpleServlet"
```

## Optional

[fswatch] is a file change monitor that receives notifications when the contents of specified files or directories are modified.

If you want to keep your Docker container updated everytime you change project's source code, just install it using [Homebrew]:

```sh
brew install fswatch
```

And point it to your project source folder:

```sh
fswatch -o ~/project-path/src | xargs -n1 ~/project-path/build.sh
```

[Docker]: <http://docker.com>
[fswatch]: <https://github.com/emcrisostomo/fswatch>
[Homebrew]: <http://brew.sh>
