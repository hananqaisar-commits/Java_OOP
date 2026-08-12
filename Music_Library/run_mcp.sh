#!/bin/bash
# PWD: Music_Library

if [ ! -f target/music-library-mcp-1.0.0.jar ]; then
    echo "[Info] Building MCP Server package with Maven..." >&2
    mvn clean package -DskipTests -q
fi

exec java -jar target/music-library-mcp-1.0.0.jar
