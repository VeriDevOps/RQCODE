#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219163
offline_credentials_expiration_set=`grep -r offline_credentials_expiration /etc/sssd | cut -d'=' -f2 | tail -1`
if [ $offline_credentials_expiration_set -ne 1 ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must be configured such that Pluggable Authentication Module (PAM)
# prohibits the use of cached authentications after one day.