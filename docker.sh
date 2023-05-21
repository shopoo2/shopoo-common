#!/bin/bash
REGPREFIX=registry.cn-guangzhou.aliyuncs.com/shopoo
VERSION=1.0.0
PROJECT=shopoo-common
mvn clean install
mvn -e package
echo "Building $PROJECT image ..."
IMAGE=$(docker build -t $REGPREFIX/$PROJECT -q .)
docker tag $IMAGE $REGPREFIX/$PROJECT:$VERSION
docker push $REGPREFIX/$PROJECT:$VERSION
