#!/bin/sh

mail_addr=$1

rm -fr *.tmp
rm -fr *.res
#rm shell

url1="https://leetcode.com/problemset/algorithms/"
url2="https://leetcode.com/problemset/database/"
url3="https://leetcode.com/problemset/shell/"

function check () {
  curl $1 | grep 'span class=\"None\"' >$2

  if test -s $2;
  then
    wc -l $2 | awk '{print $1}' > tmp
    read cur_lines < tmp
    read ori_lines < ${2}.cur

    if [ "$cur_lines" -gt "$ori_lines" ];
    then
        echo $cur_lines $ori_lines |mail -s "${2} leetcode problem updated!" $3
    fi
  fi
}

check $url1 alogrithms $mail_addr
check $url2 database $mail_addr
check $url3 shell $mail_addr

