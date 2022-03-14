#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219318
# Verify the Ubuntu operating system has the packages required for multifactor authentication installed.
# Check for the presence of the packages required to support multifactor authentication with the following commands:
is_libpam_pkcs11_installed=`dpkg -l | grep libpam-pkcs11 | awk '{print $2}' | grep -x libpam-pkcs11 | wc -l`
if [ $is_libpam_pkcs11_installed -ne 0 ]
then
    exit -1
fi
exit 0