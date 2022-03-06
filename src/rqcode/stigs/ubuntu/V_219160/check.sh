#!/bin/bash
# https://www.stigviewer.com/stig/canonical_ubuntu_18.04_lts/2021-06-16/finding/V-219160
is_rsyslog_installed=`dpkg -l | grep rsyslog | awk '{print $2}' | grep -x rsyslog | wc -l`
if [ $is_rsyslog_installed -eq 0 ]
then
    exit -1
fi
rsyslog_enabled=`sudo systemctl is-enabled rsyslog`
if [ $rsyslog_enabled == "disabled" ]
then
    exit -1
fi
rsyslog_active=`sudo systemctl is-active rsyslog`
if [ $rsyslog_active == "inactive" ]
then
    exit -1
fi
exit 0