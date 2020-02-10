#!/bin/bash

if [ -z $1 ]
then
    echo "Require chart name"
    exit
fi

replace_with=$1

find . -type f -exec sed -i "s/k8s-workshop/$replace_with/g" {} +
