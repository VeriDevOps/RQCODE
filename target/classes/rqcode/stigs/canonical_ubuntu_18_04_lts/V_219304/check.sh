#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219304
# Verify the Ubuntu operating system has the 'vlock' package installed, by running the following command:
is_vlock_installed=`dpkg -l | grep vlock | awk '{print $2}' | grep -x vlock | wc -l`
if [ $is_vlock_installed -eq 0 ]
then
    exit -1
fi
exit 0