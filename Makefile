SHELL := /bin/bash

CR_URL ?= ghcr.io/satr/java-web-
PLATFORM ?= linux/arm64

.PHONY: gradle-build-springapp
gradle-build-springapp:
	./gradlew clean build --refresh-dependencies  ':springapp:bootJar'

.PHONY: build-docker-springapp
build-docker-springapp:
	docker build --platform=$(PLATFORM) -f Dockerfile.springapp . -t $(CR_URL)java-spring-app:latest

.PHONY: run-docker-springapp
run-docker-springapp: build-docker-springapp
	docker run -it -p 8080:8080 $(CR_URL)java-spring-app:latest

.PHONY: gradle-build-api
gradle-build-api:
	./gradlew build --refresh-dependencies ':api:bootJar'

.PHONY: build-docker-api
build-docker-api:
	docker clean build --platform=$(PLATFORM) -f Dockerfile.api . -t $(CR_URL)java-spring-api:latest

.PHONY: run-docker-api
run-docker-api: build-docker-api
	docker run -it -p 8081:8081 $(CR_URL)java-spring-api:latest

.PHONY: generate-api-client
generate-api-client:
	./gradlew :springapp:openApiGenerate

.PHONY: push-docker-api
push-docker-api: build-docker-api
	docker push $(CR_URL)java-spring-api:latest

.PHONY: push-docker-springapp
push-docker-springapp: build-docker-springapp
	docker push $(CR_URL)java-spring-app:latest

.PHONY: push-docker-all
push-docker-all: push-docker-api push-docker-springapp

.PHONY: push-docker-all-amd64
push-docker-all-amd64:
	PLATFORM=linux/amd64 $(MAKE) push-docker-all