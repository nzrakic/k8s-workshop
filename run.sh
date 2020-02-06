#!/bin/bash

OPTS="$JMX_CONFIG \
$JAVA_OPTS"

echo "Java launch options: $OPTS"

exec java $OPTS -jar $SERVICE_JAR