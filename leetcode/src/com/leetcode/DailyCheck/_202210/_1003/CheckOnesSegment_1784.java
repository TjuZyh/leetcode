package com.leetcode.DailyCheck._202210._1003;

/**
 * @Author zyh
 * @Date 2022/10/3 15:29
 * @Version 1.0
 */
public class CheckOnesSegment_1784 {
    public boolean checkOnesSegment(String s) {
        int index = 0;
        int cnt = 0;
        while(index < s.length()){
            if(s.charAt(index) == '1') {
                cnt++;
                if(cnt > 1){
                    return false;
                }
                while (index < s.length() && s.charAt(index) == '1') {
                    index++;
                }
            }else if (s.charAt(index) == '0'){
                index++;
            }
        }
        return true;
    }

    /*
    * 寻找01串即可
    * */
    public boolean checkOnesSegment1(String s) {
        return !s.contains("01");
    }

    public static void main(String[] args) {
        System.out.println(new CheckOnesSegment_1784().checkOnesSegment("101010"));
    }
}
