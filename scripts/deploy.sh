#!/usr/bin/env bash

mvn clean package

echo 'Copy files...'

scp -i ~/.ssh/id_rsa \
  target/maramax-0.0.1-SNAPSHOT.jar \
  root@185.65.247.25:/home/maramax/

echo 'Restart server...'

ssh -i ~/.ssh/id_rsa root@185.65.247.25 << EOF

pgrep java | sudo xargs kill -9
nohup java -jar /home/maramax/maramax-0.0.1-SNAPSHOT.jar > log.txt &

EOF

echo 'Done!'
