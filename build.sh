#!/bin/bash

# cd into the same directory as this file
if [ -d "${BASH_SOURCE%/*}" ]; then
    cd "${BASH_SOURCE%/*}"
fi

SCRIPT_DIR=$(pwd)
OUTPUT=$SCRIPT_DIR

cd src
SRC_FILES=com/github/fiatmc
API=api/craftbukkit-1.15.2.jar

# Compile all .java files into .class files
# javac -verbose \
javac -cp $API $SRC_FILES/*.java

# Put all compiled .class files into a jar
# Also include plugin.yml
jar cf $OUTPUT/FiatMcPlugin.jar $SRC_FILES/*.class plugin.yml

# Sanity check of contents
jar tvf $OUTPUT/FiatMcPlugin.jar