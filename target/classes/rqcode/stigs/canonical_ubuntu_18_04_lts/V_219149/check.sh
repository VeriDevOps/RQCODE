#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219149
total_number=`grep "^\s*linux" /boot/grub/grub.cfg | wc -l`
secure_number=`grep "^\s*linux" /boot/grub/grub.cfg | grep "audit=1" | wc -l`
if [ $total_number -ne $secure_number ]
then
    exit -1
fi
exit 0
# The Ubuntu operating system must initiate session audits at system startup.