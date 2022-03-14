#!/bin/bash
package_name=$1
is_installed=`dpkg -l | grep $package_name | awk '{print $2}' | grep -x $package_name | wc -l`
if [ $is_installed -eq 0 ]
then
    exit -1
fi
exit 0