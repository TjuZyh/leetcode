package com.leetcode.DMSXL_2.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-01
 */
/*
* 编写一个算法来判断一个数 n 是不是快乐数:
*   对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
*   然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
*   如果这个过程 结果为 1，那么这个数就是快乐数
* 输入：n = 19
* 输出：true
* */
public class IsHappy_202 {
    //创建一个hash表用来存已经算过的结果，一直计算直到：
    //  1. n == 1
    //  2. 算到了之前算过的数(证明一定不是快乐数了，因为陷入了循环)
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n) && n != 1) {
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }

    public int getSum(int n) {
        int sum = 0;
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++) {
            //注意character转int的方式
            sum += Math.pow(Integer.parseInt(String.valueOf(str.charAt(i))), 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy_202().isHappy(82));
    }
}
