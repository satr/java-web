.PHONY: gradle-build-springapp
gradle-build-springapp:
	./gradlew clean build --refresh-dependencies  ':springapp:bootJar'

.PHONY: build-docker-spring-app
build-docker-spring-app:
	docker build ./spring-app -t springapp

.PHONY: run-docker-spring-app
run-docker-spring-app: build-docker-spring-app
	docker run -it -p 8080:8080 springapp

.PHONY: gradle-build-api
gradle-build-api:
	./gradlew clean build --refresh-dependencies ':api:bootJar'

.PHONY: build-docker-api
build-docker-api:
	docker build ./api -t api

.PHONY: run-docker-api
run-docker-api: build-docker-api
	docker run -it -p 8081:8081 api

.PHONY: generate-api-client
generate-api-client:
	./gradlew :springapp:openApiGenerate