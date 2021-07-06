#!/bin/bash

echo $PWD
cp ../restapi/src/main/resources/courses.txt Schedule/courses.txt
php Schedule/schedule.php > ../restapi/src/main/resources/instructors.txt
