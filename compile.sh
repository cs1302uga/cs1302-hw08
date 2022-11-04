#!/bin/bash -ex

mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="cs1302.hw08.ImageDriver"
