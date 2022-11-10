package com.leetcode.DMSXL.string;

/**
 * @Author zyh
 * @Date 2022/11/10 13:28
 * @Version 1.0
 */
public class ReplaceSpace_offer05 {
    /*
    * 使用StringBuilder构造新字符串
    * */
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(chars[i] == ' ') {
                sb.append("%20");
            }else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /*
    * 使用subString方法替换
    * */
    public String replaceSpace2(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                //substring参数：左闭右开
                s = s.substring(0, i) + "%20" + s.substring(i + 1);
            }
        }
        return s;
    }

    /*
    * 不使用任何API，字节数组处理
    * */
    public String replaceSpace3(String s) {
        char[] ans = new char[s.length() * 3];
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                ans[index++] = '%';
                ans[index++] = '2';
                ans[index++] = '0';
            }else {
                ans[index++] = s.charAt(i);
            }
        }
        return new String(ans, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace_offer05().replaceSpace("We are happy."));
        String str = "We are happy.";
        System.out.println(str.substring(0, 2) + "%20" + str.substring(3));
    }
}
