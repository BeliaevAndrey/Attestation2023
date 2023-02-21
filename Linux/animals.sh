#! /bin/bash

cat << EOF > Pets.txt
Мурзик, кот, 2 года
Мурка, кошка, 2 года
Барбос, собака, 2 года
Найда, собака, 2 года
Персиваль, хомяк, 1 год
Наполеон, хмяк, 1 год
EOF


cat << EOF > Sumpters.txt
Празеодим, конь, 4 года
Неодим, конь, 4 года
Радон, осёл, 4 года
Осмий, осёл, 4 года
Кант, верблюд, 4 год
Фейхтвагнер, вербдлюд, 4 год
EOF

cat Sumpters.txt Pets.txt > FriendOfMankind.txt
cat FriendOfMankind.txt

mkdir Animals && mv FriendOfMankind.txt Animals/



