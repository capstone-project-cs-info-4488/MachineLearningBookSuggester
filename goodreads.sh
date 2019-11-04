#!/bin/bash
#Need to get a user id
	#Don't know how to get user ID's
#use the user id to curl their books
#parse the curl response and then add to an output file
	#Need to see an example of the curl response to know how to parse through it
#Do this roughly 10,000 times
END=5
for((i=1;i<END;i++));do
#curling a sample list of books
	curl https://www.goodreads.com/review/list/103600095.xml?key=<devKey>&v=2
sleep 10
done
