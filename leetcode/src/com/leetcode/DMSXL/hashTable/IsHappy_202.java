package com.leetcode.DMSXL.hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/11/3 22:48
 * @Version 1.0
 */
/*
* 快乐数：
*   输入：n = 19
*   输出：true
* */
public class IsHappy_202 {
    /*
    * 存在两种情况：
    *   1. 最终归为1，是happy数
    *   2. 最终进入循环，即归为之前出现过的数，那么一定不是happy数
    *       可以用集合存一下访问过的数，若出现过则直接false
    * */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            n = getSum(n);
            if(seen.contains(n)) {
                return false;
            }
            seen.add(n);
        }
        return true;
    }

    public int getSum(int n) {
        int cnt = 0;
        while(n / 10 != 0){
            int last = n % 10;
            n = n / 10;
            cnt += last * last;
        }
        cnt += n * n;
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new IsHappy_202().isHappy(19));
    }
}
