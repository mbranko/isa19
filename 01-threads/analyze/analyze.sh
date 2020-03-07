#!/bin/bash
REQUESTS=${1:-1000}
CONCURRENT=${2:-5}
echo "Ukupan broj zahteva: $REQUESTS"
echo "Broj istovremenih: $CONCURRENT"
echo "Proveri da li Java i Node.js serveri rade na portovima 8080 i 9090"
read -n 1 -s -r -p "Pritisni taster za pocetak..."
SERVER=Java
COMMAND1="ab -n $REQUESTS -c $CONCURRENT -g $SERVER.tsv localhost:8080/abc"
eval $COMMAND1
echo $SERVER > plotparams
echo $COMMAND1 >> plotparams
gnuplot timeline.p
gnuplot binned.p
open $SERVER-timeline.png
open $SERVER-binned.png
SERVER=Node
COMMAND2="ab -n $REQUESTS -c $CONCURRENT -g $SERVER.tsv localhost:9090/abc"
eval $COMMAND2
echo $SERVER > plotparams
echo $COMMAND2 >> plotparams
gnuplot timeline.p
gnuplot binned.p
open $SERVER-timeline.png
open $SERVER-binned.png
