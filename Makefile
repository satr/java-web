.PHONY: gradle-build-spring-app
gradle-build-spring-app:
	cd spring-app && ./gradlew build --refresh-dependencies && cd -

.PHONY: build-docker-spring-app
build-docker-spring-app:
	docker build ./spring-app -t springapp

.PHONY: run-docker-spring-app
run-docker-spring-app: build-docker-spring-app
	docker run -it -p 8080:8080 springapp

