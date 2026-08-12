#!/bin/bash
# PWD: Music_Library

mvn clean compile -q
mvn exec:java -Dexec.mainClass="com.musiclibrary.Main" -q
