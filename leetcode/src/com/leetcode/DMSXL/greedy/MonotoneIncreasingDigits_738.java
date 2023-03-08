package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/3/8 21:17
 * @Version 1.0
 */
/*
* 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的
*   给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增
* 输入: n = 332
* 输出: 299
 * */
public class MonotoneIncreasingDigits_738 {
    /*
    * 从右到左遍历数字，如果发现当前位上的数字比前一位的数字小，那么需要将前一位-1，并将其后面的数字全置为9
    *
    * 如果从左到右遍历，需要考考虑相同数字的问题，比如332
    *   发现当前的下一位比当前数字小时，需要看当前位之前是否有相同的数字存在，如果有则需要找到相同数字的第一位
    *   后将第一位-1，后面所有的值置为9
    * */
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int start = chars.length;
        for(int i = chars.length - 1; i > 0; i--) {
            //如果当前位比前一位小，那么就将前一位-1，并将前一位的后面所有位都置为9
            if(chars[i - 1] > chars[i]) {
                //注意char可以加减，但是复制需要加''
                //char +/- int 会提升为 int
                chars[i - 1] -= 1;
                start = i;
            }
        }
        for(int i = start; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits_738().monotoneIncreasingDigits(332));
    }
}
