#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219177
# Verify that the telnet package is not installed on the Ubuntu operating system.
# Check that the telnet daemon is not installed on the Ubuntu operating system by running the following command:
is_telnetd_installed=`dpkg -l | grep telnetd | awk '{print $2}' | grep -x telnetd | wc -l`
if [ $is_telnetd_installed -ne 0 ]
then
    exit -1
fi
exit 0