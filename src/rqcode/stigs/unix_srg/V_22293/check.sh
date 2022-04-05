#!/bin/bash
# https://www.stigviewer.com/stig/unix_srg/2013-03-26/finding/V-22293
ntpdate_invoked_correctly=`crontab -l | grep ntpdate | grep '-a' | wc -l`
if [ $ntpdate_invoked_correctly -eq 0 ]
then
    exit -1
fi
ntpdate_key_config=`grep ^server ntp.conf | grep -v '( key | autokey )' | wc -l`
if [ $ntpdate_key_config -eq 0 ]
then
    exit -1
fi
exit 0
# The system time synchronization method must use cryptographic algorithms to
# verify the authenticity and integrity of the time data.