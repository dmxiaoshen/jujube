#!/bin/bash

#example ./branch_batch.sh fengdai3.0

branch_name=$1

if [ ! $branch_name ];then 
  echo "please input branch name"
else
    cd core-base
    echo $branch_name
    cd ../rest-base
    echo $branch_name
fi
