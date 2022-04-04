#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219158
is_rsh_server_installed=`dpkg -l | grep rsh-server | awk '{print $2}' | grep -x rsh-server | wc -l`
if [ $is_rsh_server_installed -ne 0 ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must not have the rsh-server package installed.