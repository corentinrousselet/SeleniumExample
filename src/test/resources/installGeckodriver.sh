#!/usr/bin/env bash

if [ "$UID" -ne "0" ]
then
   echo "Le script doit être lancé avec sudo"
   exit 1
fi

echo "Download geckodriver tar.gz on https://github.com/mozilla/geckodriver/releases/download/ "
wget https://github.com/mozilla/geckodriver/releases/download/v0.18.0/geckodriver-v0.18.0-linux64.tar.gz -P /opt/
echo "Uncompress tar.gz in /opt/ "
tar zxvf /opt/geckodriver-v0.18.0-linux64.tar.gz -C /opt/
echo "Delete tar.gz "
rm -rf /opt/geckodriver-v0.18.0-linux64.tar.gz