# docker-dropwizard - an example Docker container for Dropwizard

# DOCKER HUB

https://registry.hub.docker.com/u/mcandre/docker-dropwizard/

# EXAMPLE

```
$ make
gradle clean shadowJar
docker build -t mcandre/docker-dropwizard:latest .
CONTAINER=$(docker run -d -p 8080:8080 -p 8081:8081)
docker exec $CONTAINER curl -s localhost:8080/hello-dropwizard?name=Bob
{"content":"Hello, Bob!"}
```

# ABOUT

docker-dropwizard is a working example of several technologies:

* Dropwizard, a modular Java Web server
* Gradle, a Java build tool
* Docker, a portable application container system
* Chef, a provisioning service with configurable templates

# REQUIREMENTS

* [Docker](https://www.docker.com/)
* [Gradle](http://gradle.org/) 2.7+

## Optional

* [make](http://www.gnu.org/software/make/)
* [Node.js](https://nodejs.org/en/) (for dockerlint)
