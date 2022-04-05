#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_16.04_lts/2020-12-09/finding/V-214961

password_reuse_generations=`grep "^password" /etc/pam.d/common-password | grep -o "remember=[0-9]*" | cut -d'=' -f2`
if [ $password_reuse_generations -lt 5 ]
then
    exit -1
fi
exit 0
# Passwords must be prohibited from reuse for a minimum of five generations.