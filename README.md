# corellia

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/bf6fa237dd934970991ecba2c66db23e)](https://app.codacy.com/app/baloise/corellia?utm_source=github.com&utm_medium=referral&utm_content=baloise/corellia&utm_campaign=Badge_Grade_Dashboard)
[![DepShield Badge](https://depshield.sonatype.org/badges/baloise/corellia/depshield.svg)](https://depshield.github.io)
[![Build Status](https://travis-ci.org/baloise/corellia.svg?branch=master)](https://travis-ci.org/baloise/corellia)
[![Codecov](https://img.shields.io/codecov/c/github/baloise/corellia.svg)](https://codecov.io/gh/baloise/corellia)
[![gitpod-IDE](https://img.shields.io/badge/open--IDE-as--gitpod-blue.svg?style=flat&label=openIDE)](https://gitpod.io#https://github.com/baloise/corellia)

## about

The project hosts a classical b2b-interface (REST) specification for (insurance) contract data and document exchange.
This application uses JAX-RS and Fasterxml/Jackson annotated resources to resolve a valid OpenAPI definition out of Java classes representing the API

### the name

The name [Corellia](https://en.wikipedia.org/w/index.php?title=Corellia) is a reference to a fictitious planet from  StarWars: one of the first trading planets in the universe with its own [Corellian Trade Spine](https://starwars.fandom.com/wiki/Corellian_Trade_Spine).

### the [docs](docs/index.md)

### usage open api v3

To generated the `docs/openapi.json` OpenAPI specification, call

```
$ mvn exec:java@gen-openapi
```

Note: _(One must at least once have called `$ mvn install`, otherwise the above call won't work)_

To get the API, one issues

```
$ mvn package
```

### usage open api v2

Leverages the wonderful [api-spec-converter](https://github.com/LucyBot-Inc/api-spec-converter)

Firstly generate the OpenAPI v3 specs (will be located at `docs/openapi.json`)
Then , issue the following maven call:

```
$ mvn exec:java@gen-swagger
```
Note: _(One must have issued `npm install` previously.)_

to create the OpenApi v2. It will be stored at `docs/swagger.json`