#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219164
pam_faildelay_set=`grep "^auth required pam_faildelay" /etc/pam.d/common-auth | wc -l`
if [ $pam_faildelay_set -eq 0 ]
then
    exit -1
fi
pam_faildelay_value=`grep "^auth required pam_faildelay" /etc/pam.d/common-auth | cut -d'=' -f2`
if [ $pam_faildelay_value -lt 4000000 ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must enforce a delay of at least 4 seconds between logon prompts following a failed logon attempt.