#!/bin/bash
cd "$(dirname "$0")/.."

gradle build
java -jar build/libs/backend-0.0.1-SNAPSHOT.jar