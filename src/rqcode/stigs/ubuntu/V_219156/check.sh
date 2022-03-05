#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219156
commented_out=`grep -i remove-unused /etc/apt/apt.conf.d/50unattended-upgrades | grep "^//" | wc -l`
if [ $commented_out -ne 0 ]
then
    exit -1
fi
set_to_false=`grep -i remove-unused /etc/apt/apt.conf.d/50unattended-upgrades | grep false | wc -l`
if [ $set_to_false -ne 0 ]
then
    exit -1
fi
exit 0