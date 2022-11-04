#!/bin/bash -ex

mvn clean
mvn compile
mvn exec:java -Dprism.order="sw" -Dexec.mainClass="cs1302.hw08/cs1302.hw08.ImageDriver"
