#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219319
# Verify the Ubuntu operating system accepts Personal Identity Verification (PIV) credentials.
# Check that the "opensc-pcks11" package is installed on the system with the following command:
is_opensc_pkcs11_installed=`dpkg -l | grep opensc-pkcs11 | awk '{print $2}' | grep -x opensc-pkcs11 | wc -l`
if [ $is_opensc_pkcs11_installed -ne 0 ]
then
    exit -1
fi
exit 0