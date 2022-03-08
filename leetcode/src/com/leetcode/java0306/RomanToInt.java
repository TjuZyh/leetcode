package com.leetcode.java0306;

//I:1 V:5 X:10 L:50 C:100 D:500 M:1000
//注意有六种特例
//IV:4 IX:9 XL:40 XC:90 CD:400 CM:900
//MCMXCIV:1000+900+90+4

//注意：charAt的越界问题！
public class RomanToInt {

    public static int romanToInt(String s){
        int len = s.length();
        int sum = 0;
        for(int i = 0 ; i < len ; i++){
            if(s.charAt(i) == 'I'){
                int n = i + 1;
                if(n < len && s.charAt(n) == 'V'){
                    sum += 4;
                    i++;
                }else if(n < len && s.charAt(n) == 'X'){
                    sum += 9;
                    i++;
                }else{
                    sum += 1;
                }
            }else if(s.charAt(i) == 'V'){
                sum += 5;
            }else if(s.charAt(i) == 'X'){
                int m = i + 1;
                if(m < len && s.charAt(m) == 'L'){
                    sum += 40;
                    i++;
                }else if(m < len && s.charAt(m) == 'C'){
                    sum += 90;
                    i++;
                }else{
                    sum += 10;
                }
            }else if(s.charAt(i) == 'L'){
                sum += 50;
            }else if(s.charAt(i) == 'C'){
                int j = i + 1;
                if(j < len && s.charAt(j) == 'D'){
                    sum += 400;
                    i++;
                }else if(j < len && s.charAt(j) == 'M'){
                    sum += 900;
                    i++;
                }else{
                    sum+= 100;
                }
            }else if(s.charAt(i) == 'D'){
                sum += 500;
            }else if(s.charAt(i) == 'M'){
                sum += 1000;
            }else{
                sum += 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String str = "III";
        System.out.println(romanToInt(str));
    }
}
