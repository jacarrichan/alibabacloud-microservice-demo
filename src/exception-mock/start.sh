#!/bin/bash

java \
  -Dcom.sun.management.jmxremote.port=19991 \
  -Dcom.sun.management.jmxremote.authenticate=false \
  -Dcom.sun.management.jmxremote.ssl=false \
  -jar /app/exception-mock-provider-1.0.0-SNAPSHOT.jar
