#!/bin/bash -ex

export MAVEN_OPTS=-Dprism.order=sw;

mvn -e -q clean
mvn -e -q compile
mvn -e -q exec:java -Dprism.order=sw -Dexec.mainClass="cs1302.hw08/cs1302.hw08.ImageDriver"
