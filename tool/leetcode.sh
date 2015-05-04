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
    wc -l $2 > ${2}.tmp
    diff ${2}.tmp ${2}.cur > ${2}.res
    if test -s ${2}.res;
    then
      echo "update in "${2} |mail -s "leetcode problem updated!" $3
    fi
  fi
}

check $url1 alogrithms $mail_addr
check $url2 database $mail_addr
check $url3 shell $mail_addr

