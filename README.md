# corellia
[![swagger-editor](https://img.shields.io/badge/open--API-in--editor-green.svg?style=flat&label=open-api-v3)](https://editor.swagger.io/?url=https://raw.githubusercontent.com/baloise/corellia/master/docs/openapi.json)
[![swagger-editor](https://img.shields.io/badge/open--API-in--editor-green.svg?style=flat&label=open-api-v2)](https://editor.swagger.io/?url=https://raw.githubusercontent.com/baloise/corellia/master/docs/swagger.json)
[![DepShield Badge](https://depshield.sonatype.org/badges/baloise/corellia/depshield.svg)](https://depshield.github.io)
[![CI Status](https://github.com/baloise/corellia/workflows/CI/badge.svg)](https://github.com/baloise/corellia/actions)

## workspace
[![Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io#https://github.com/baloise/corellia)

## about

The project hosts a classical b2b-interface (Web-API) specification for (insurance) contract data and document exchange.

This is a java project leveraging [swagger-core](https://github.com/swagger-api/swagger-core) and a [converter](https://github.com/LucyBot-Inc/api-spec-converter) to create the OpenAPI 2.0 specs. It provides the Contracts API according to the OpenAPI Spec. This application uses JAX-RS annotated resources to resolve a valid OpenAPI definition out of Java classes representing the API

### the name

The name [Corellia](https://en.wikipedia.org/w/index.php?title=Corellia) is a reference to a fictitious planet from  StarWars: one of the first trading planets in the universe with its own [Corellian Trade Spine](https://starwars.fandom.com/wiki/Corellian_Trade_Spine).

### api specs

You can find the openapi specs in the following files:

OpenAPI v3 Specs: `docs/openapi.json`

OpenAPI v2 Specs: `docs/swagger.json`

### usage open api v3

To generate the `docs/openapi.json` OpenAPI specification, call

```
$ mvn exec:java@gen-openapi
```

Note: _(One must at least once have called `$ mvn install`, otherwise the above call won't work)_

### usage open api v2

**Firstly generate the OpenAPI v3 specs** (will be located at `docs/openapi.json`)
Then use the following call to convert the OpenAPI v2 specs (will be located at `docs/swagger.json`)

```
$ mvn exec:java@gen-swagger
```
Note: _(One must have issued `npm install` previously.)_

## releasing

Run e.g. on master: `mvn -B release:prepare` e.g. via [![Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io#https://github.com/baloise/corellia)

Subsequently the GitHub action worksflow "create release" will pick up the published tag and release and deploy the artifacts in the Github package registry.


## Spectral linting (just to not forget how to do it.)

use the following comand to lint openapi.json
```
node_modules\.bin\spectral.cmd lint docs\openapi.json
```
.spectral contains the rules and functions/ contains the custome functions used in the rule
Custom example rules are:
 - Version must be 3.0.1
 - all post actions must have X-Caller-Name and X-EventId in the header
 
All standard rules for openapie 3 are usesd as well.

Documentation can be found here:
https://meta.stoplight.io/docs/spectral/README.md

docker run --rm -it -v %cd%:/tmp  quay.balgroupit.com/baloise-base-images/spectral lint  /tmp/docs/openapi.json --ruleset=/tmp/docs/spectral.yaml
