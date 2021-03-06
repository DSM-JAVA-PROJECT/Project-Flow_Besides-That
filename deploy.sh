#!/usr/bin/env bash

REPOSITORY=/home/ec2-user
cd $REPOSITORY

APP_NAME=action_codedeploy
JAR_NAME=$(ls $REPOSITORY/build/libs/ | grep '.jar' | tail -n 1)
JAR_PATH=$REPOSITORY/build/libs/$JAR_NAME

source $REPOSITORY/codedeploy.sh

echo "> $smtp_class" >> deploy.log
echo "> $Email_ID" >> deploy.log

CURRENT_PID=$(pgrep -f $APP_NAME)

if [ -z $CURRENT_PID ]
then
  echo "> 종료할것 없음." >> deploy.log
else
  echo "> kill -9 $CURRENT_PID" >> deploy.log
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> $JAR_PATH 배포" >> deploy.log
nohup java -jar $JAR_PATH &