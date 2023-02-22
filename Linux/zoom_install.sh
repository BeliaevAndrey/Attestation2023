#! /bin/bash

wget https://zoom.us/client/latest/zoom_amd64.deb
# Выкачивание deb-пакета

dpkg -i zoom_amd64.deb
# устнановка deb-пакета

apt-get -y -f install
# установка зависимостей


