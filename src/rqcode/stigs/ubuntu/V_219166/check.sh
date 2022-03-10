#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219166
pam_user_lock_set=`grep "^auth.*pam_tally2" /etc/pam.d/common-auth | wc -l`
if [ $pam_user_lock_set -eq 0 ]
then
    exit -1
fi
pam_user_lock_onerr_set=`grep "^auth.*pam_tally2" /etc/pam.d/common-auth | grep "onerr=fail" | wc -l`
if [ $pam_user_lock_onerr_set -eq 0 ]
then
    exit -1
fi
attempts=`grep "^auth.*pam_tally2" /etc/pam.d/common-auth | grep -o "deny=[0-9]*" | cut -d'=' -f2`
if [ $attempts -gt 3 ]
then
    exit -1
fi
exit 0