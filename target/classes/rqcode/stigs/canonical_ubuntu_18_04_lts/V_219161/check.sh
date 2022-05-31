#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219161
is_ufw_installed=`dpkg -l | grep ufw | awk '{print $2}' | grep -x ufw | wc -l`
if [ $is_ufw_installed -eq 0 ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must have an application firewall installed in order to control remote access methods.