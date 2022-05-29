package com.leetcode.DailyCheckIn._0529;

import java.util.Arrays;
import java.util.Locale;

/**
 * @Author zyh
 * @Date 2022/5/29 9:12 下午
 * @Version 1.0
 */
/*
* 给定一个字符串queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；
*   如果是有效的 IPv6 地址，返回 "IPv6" ；
*   如果不是上述类型的 IP 地址，返回 "Neither"
* */
public class validIPAddress_468 {
    public String validIPAddress(String queryIP) {
        return isIPv4(queryIP) ? "IPv4" : isIpv6(queryIP) ? "IPv6" : "Neither";
    }

    /*
    * 步骤：
    * 1. 先根据.分割四个部分
    * 2. 每段应为0-255
    * 3. 无前导0
    * 4. 无.的情况
    * */
    public boolean isIPv4(String s){
        //注意：需要加一个limit，这样结尾的空字符串不会被丢弃
        /*
        * limit用法:
        *   1.如果 limit > 0,(从左到右)最多分割 n - 1 次,数组的长度将不会大于 n,结尾的空字符串不会丢弃
        *   2.如果 limit < 0,匹配到多少次就分割多少次,而且数组可以是任何长度。结尾的空字符串不会丢弃
        *   3.如果 limit = 0,匹配到多少次就分割多少次,数组可以是任何长度,并且结尾空字符串将被丢弃。
        *   也就是说,使用split方法时,如果只填一个正则表达式,结尾空字符串将被丢弃
        * */
        String[] ipArr = s.split("\\." , -1);
        if(ipArr.length != 4){
            return false;
        }
        for(int i = 0 ; i < 4 ; i++){
            if(ipArr[i].length() == 0 || ipArr[i].length() > 3 || (ipArr[i].length() > 1 && ipArr[i].charAt(0) == '0')){
                return false;
            }
            int sum = 0;
            char[] chars = ipArr[i].toCharArray();
            for(char c : chars){
                if(!Character.isDigit(c)){
                    return false;
                }
                sum = sum * 10 + (c - '0');
            }
            if(sum > 255) return false;
        }
        return true;
    }

    /*
    * 1. 根据:分开
    * 2. 1-4位
    * 3. 字符（abcdef）或数字
    * */
    public boolean isIpv6(String s){
        s = s.toLowerCase();
        String[] ipArr = s.split(":" , -1);
        if(ipArr.length != 8) return false;
        for(int i = 0 ; i < 8 ; i++){
            if(ipArr[i].length() == 0 || ipArr[i].length() > 4){
                return false;
            }
            for(char c : ipArr[i].toCharArray()){
                if(!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f')){
                    return false;
                }
            }
        }
        return true;
    }
}
