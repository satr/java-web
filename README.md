# java-web

* * Install openapi-generator
```
npm install @openapitools/openapi-generator-cli -g
#or
brew install openapi-generator
```

* Generate OpenAPI spec from Java code - it creates/updates `api/openapi.yaml` file
```
./gradlew generateOpenApiDocs
```

* Generate Java client code from OpenAPI spec - it creates/updates files in `springapp/openapi-client` folder
```
./gradlew :springapp:openApiGenerate
```