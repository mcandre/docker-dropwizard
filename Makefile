IMAGE=mcandre/docker-dropwizard:latest
SHADOW_JAR=build/libs/docker-dropwizard-all.jar

all: run

$(SHADOW_JAR): build.gradle
	gradle clean shadowJar

.PHONY: build
build: Dockerfile $(SHADOW_JAR)
	docker build -t $(IMAGE) .

run: clean-containers build
	$(eval CONTAINER=$(shell docker run -d -p 8080:8080 -p 8081:8081 $(IMAGE)))
	sleep 3
	docker exec $(CONTAINER) curl -s localhost:8080/hello-dropwizard?name=Bob

clean-containers:
	-docker ps -a | grep -v IMAGE | awk '{ print $$1 }' | xargs docker rm -f

clean-images:
	-docker images | grep -v IMAGE | grep $(IMAGE) | awk '{ print $$3 }' | xargs docker rmi -f

clean-layers:
	-docker images | grep -v IMAGE | grep none | awk '{ print $$3 }' | xargs docker rmi -f

clean: clean-containers clean-images clean-layers

foodcritic:
	foodcritic cookbook/

lint: foodcritic

publish:
	docker push $(IMAGE)
