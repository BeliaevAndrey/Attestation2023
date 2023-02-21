#! /bin/bash

wget https://dev.mysql.com/get/mysql-apt-config_0.8.24-1_all.deb 
# Ссылка с официального сайта на загрузку устанавливающего СУБД deb-пакета

dpkg -i mysql-apt-config_*_all.deb
# Установка deb-пакета
# После этого в /etc/apt/sources.list.d/ появляется файл с путем к репозиторию mysql: mysql.list 
# В /etc/apt/ прописывается файл с ключом: trusted.gpg

apt update
#  Обновление репозитория

apt install -y mysql-server mysql-client
# Установка компонентов СУБД
