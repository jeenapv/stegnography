To attach database:

Open mysql using command prompt :
mysql -u root -p
<enter your password>

create database stegnography;

exit from database using command :
exit

Copy the dump file (stegnography.txt) to desktop.
Open command prompt and enter following commands :

cd Desktop
mysql -u root -p stegnography < stegnography.txt
<enter your password>

Your database dump is attached!

