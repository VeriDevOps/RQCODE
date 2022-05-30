#!/bin/bash
# https://www.stigviewer.com/stig/unix_srg/2013-03-26/finding/V-22293
crons_count=`crontab -l 2>/dev/null | wc -l`
if [ $crons_count -eq 0 ]
then
    echo "No crontask found for time synchronization"
    exit -1
fi
ntpdate_invoked_correctly=`crontab -l | grep ntpdate | grep '-a' | wc -l`
if [ $ntpdate_invoked_correctly -eq 0 ]
then
    echo "The ntpdate command is not invoked with the -a parameter"
    exit -1
fi
ntpdate_key_config=`grep "^server" ntp.conf | grep -v '( key | autokey )' | wc -l`
if [ $ntpdate_key_config -eq 0 ]
then
    echo "Server lines are present without key or autokey options"
    exit -1
fi
exit 0
# The system time synchronization method must use cryptographic algorithms to
# verify the authenticity and integrity of the time data.