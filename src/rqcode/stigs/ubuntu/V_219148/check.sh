#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219148
value_to_test=`grep –i password /boot/efi/EFI/grub.cfg | cut -d' ' -f1`
if [ $value_to_test == 'password_pbkdf2' ]
then
    return 0
fi
return -1