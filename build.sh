#!/bin/sh

#echo "[ Validating GIT Repository ]"
#if [ ! -e .git/config ]
#then
#   echo "[ ERROR ] Miss .git/config"
#   exit 1;
#fi

echo "[ Performing PULL ]"
git pull


BUILD_PATH=$(pwd)
cd $BUILD_PATH

echo "[ Performing BUILD ]"
ant -buildfile build.xml
if [ ! $? == 0 ]
then
   echo "[ ERROR ] Build FAILED"
   exit 1;
fi

echo "[ DONE ]"

echo "[ ECXE ]"
sh ./bin/amacay.sh

exit 0;

