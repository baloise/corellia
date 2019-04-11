# corellia
[![swagger-editor](https://img.shields.io/badge/open--API-in--editor-green.svg?style=flat&label=open-api)](https://editor.swagger.io/?url=https://raw.githubusercontent.com/baloise/corellia/master/docs/openapi.json)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bf6fa237dd934970991ecba2c66db23e)](https://app.codacy.com/app/baloise/corellia?utm_source=github.com&utm_medium=referral&utm_content=baloise/corellia&utm_campaign=Badge_Grade_Dashboard)
[![DepShield Badge](https://depshield.sonatype.org/badges/baloise/corellia/depshield.svg)](https://depshield.github.io)
[![Build Status](https://travis-ci.org/baloise/corellia.svg?branch=master)](https://travis-ci.org/baloise/corellia)
[![Codecov](https://img.shields.io/codecov/c/github/baloise/corellia.svg)](https://codecov.io/gh/baloise/corellia)
[![gitpod-IDE](https://img.shields.io/badge/open--IDE-as--gitpod-blue.svg?style=flat&label=openIDE)](https://gitpod.io#https://github.com/baloise/corellia)

## about

The project hosts a classical b2b-interface (Web-API) specification for (insurance) contract data and document exchange.

This is a java project leveraging a stand-alone jetty server. It provides the Baloise Contracts API according to the OpenAPI Spec. This application uses JAX-RS annotated resources to resolve a valid OpenAPI definition out of Java classes representing the API

### the name

The name [Corellia](https://en.wikipedia.org/w/index.php?title=Corellia) is a reference to a fictitious planet from  StarWars: one of the first trading planets in the universe with its own [Corellian Trade Spine](https://starwars.fandom.com/wiki/Corellian_Trade_Spine).

### the [docs](docs/index.md)

### usage open api v3

#### run the server
To run the server, change to module corellia-api-war and run this task:

```
mvn package jetty:run
```

Note: _(One must at least once have called `$ mvn install`, otherwise the above call won't work)_

To get the API, one issues

```
$ mvn package
```

### usage open api v2

Firstly generate the OpenAPI v3 specs (will be located at `docs/openapi.json`)
Then, use npm to install the main dependency, [the converter](https://github.com/LucyBot-Inc/api-spec-converter).

Call

```
$ npm run convert > swagger.json
```
Note: _(One must have issued `npm install` previously.)_

to create the OpenApi v2. There might be some artifacts in the first few lines of that json file.
Clean it accordingly.
