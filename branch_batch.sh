#!/bin/bash

#example ./branch_batch.sh fengdai3.0

branch_name=$1

if [ ! $branch_name ];then 
  echo "please input branch name"
else
    echo "$(pwd)"
    git checkout -b $branch_name
    git checkout master
    git push origin $branch_name
    
fi
