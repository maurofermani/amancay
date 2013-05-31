#!/bin/bash

JAVA_PROGRAM="/usr/bin/java"
JAVA_HOME="$HOME/workspace/Amancay"
JAVA_CLASS="$JAVA_HOME/build/classes"
JAVA_LIB="$JAVA_HOME/lib"
JAVA_OPTS="-Xmx256m"

CLASS_PATH=$JAVA_CLASS:$(find $JAVA_LIB/* | xargs | sed -e "s/ /:/g")
CLASS_NAME="amancay.Amancay"
CLASS_OPTIONS=$JAVA_HOME/etc/config.cfg

cd $JAVA_CLASS
$JAVA_PROGRAM -cp $CLASS_PATH $JAVA_OPTS $CLASS_NAME $CLASS_OPTIONS
