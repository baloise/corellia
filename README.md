# corellia

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bf6fa237dd934970991ecba2c66db23e)](https://app.codacy.com/app/baloise/corellia?utm_source=github.com&utm_medium=referral&utm_content=baloise/corellia&utm_campaign=Badge_Grade_Dashboard)
[![DepShield Badge](https://depshield.sonatype.org/badges/baloise/corellia/depshield.svg)](https://depshield.github.io)
[![Build Status](https://travis-ci.org/baloise/corellia.svg?branch=master)](https://travis-ci.org/baloise/corellia)
[![Codecov](https://img.shields.io/codecov/c/github/baloise/corellia.svg)](https://codecov.io/gh/baloise/corellia)
[![gitpod-IDE](https://img.shields.io/badge/open--IDE-as--gitpod-blue.svg?style=flat&label=openIDE)](https://gitpod.io#https://github.com/baloise/corellia)

## about

The project hosts a classical b2b-interface (Web-API) specification for (insurance) contract data and document exchange.

This is a java project leveraging a stand-alone jetty server. It provides the Baloise Contracts API according to the OpenAPI Spec. 
This application uses JAX-RS annotated resources to resolve a valid OpenAPI definition out of Java classes representing the API 


### the name
[![swagger-editor](https://img.shields.io/badge/open--API-in--editor-green.svg?style=flat&label=open-api)](https://editor.swagger.io/?url=https://raw.githubusercontent.com/baloise/corellia/JAVAMIG-3393/docs/swagger.json)

## the [docs](docs/index.md)

### To run (with Maven)
To run the server, run this task:

```
mvn package jetty:run
```

### generate JSON representation
Once started, you can navigate to http://localhost:8002/api to view the Swagger Resource Listing.
This tells you that the server is up and ready to demonstrate Swagger.

# Origin
adopted from https://github.com/swagger-api/swagger-samples/blob/2.0/java/java-jaxrs2-openapiservlet/pom.xml
