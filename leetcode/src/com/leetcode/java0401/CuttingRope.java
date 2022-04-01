package com.leetcode.java0401;

/*
* 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段
*  请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
* */
public class CuttingRope {
    /*
    * 数学问题：
    *   推论一：将绳子以相等的长度等分为多段 ，得到的乘积最大
    *   推论二：尽可能将绳子以长度 3 等分为多段时，乘积最大。
    * 切分规则：
    *   最优：把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
    *   次优：若最后一段绳子长度为 2 ；则保留，不再拆为 1+1 。
    *   最差：若最后一段绳子长度为 1 ；则应把一份 3+1 替换为 2+2
    * */
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3 , a);
        if(b == 1) return (int)Math.pow(3 , a - 1) * 4;
        return (int)Math.pow(3 , a) * 2;
    }
}
