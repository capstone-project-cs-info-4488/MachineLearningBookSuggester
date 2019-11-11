#!/bin/bash

for i in {1..200}
do
	python ./dataReader.py
	echo "Sleeping..."
	sleep 5m
done
