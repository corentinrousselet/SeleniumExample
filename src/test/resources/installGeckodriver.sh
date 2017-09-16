#!/usr/bin/env bash
echo "Download geckodriver tar.gz on https://github.com/mozilla/geckodriver/releases/download/ "
wget https://github.com/mozilla/geckodriver/releases/download/v0.18.0/geckodriver-v0.18.0-linux64.tar.gz -P /tmp/
echo "Uncompress tar.gz in /tmp/ "
tar zxvf /tmp/geckodriver-v0.18.0-linux64.tar.gz -C /tmp/
echo "Delete tar.gz "
rm -rf /tmp/geckodriver-v0.18.0-linux64.tar.gz