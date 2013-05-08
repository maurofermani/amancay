#!/bin/bash

JAVA_PROGRAM="/usr/bin/java"
JAVA_HOME="$HOME/amancay"
JAVA_LIB="$JAVA_HOME/lib"
JAVA_OPTS="-Xmx256m"

CLASS_PATH=$JAVA_HOME/build:$(find $JAVA_LIB/* | xargs | sed -e "s/ /:/g")
CLASS_NAME="amancay.Amancay"
CLASS_OPTIONS=$JAVA_HOME/etc/config.cfg

cd $JAVA_HOME
$JAVA_PROGRAM -cp $CLASS_PATH $JAVA_OPTS $CLASS_NAME $CLASS_OPTIONS
