#!/usr/bin/env bash

l=0
while read line; do
    l=$((l+1))
    if [ $l -eq 10 ]; then
        echo $line
        exit 0
    fi
done < file.txt