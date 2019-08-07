#!/usr/bin/env bash


words=$(head -n 1 file.txt | wc -w)
for i in $(seq 1 $words);
do
    echo `cut -d ' ' -f $i file.txt`
done
