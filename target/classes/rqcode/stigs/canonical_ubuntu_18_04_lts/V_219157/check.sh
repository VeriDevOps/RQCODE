#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219157
is_nis_installed=`dpkg -l | grep nis | awk '{print $2}' | grep -x nis | wc -l`
if [ $is_nis_installed -ne 0 ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must not have the Network Information Service (NIS) package installed.