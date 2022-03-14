#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219343
# Verify that Advanced Intrusion Detection Environment (AIDE) is installed and verifies the correct operation of all security functions.
# Check that the AIDE package is installed with the following command:
is_aide_installed=`dpkg -l | grep aide | awk '{print $2}' | grep -x aide | wc -l`
if [ $is_aide_installed -eq 0 ]
then
    exit -1
fi
exit 0