package com.leetcode.java0330;

import java.util.HashMap;
import java.util.Map;

/*
* 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
* */
public class SingleNumber {
    /*
    * hash解法：复杂度比较高，不可取
    * */
    public static int singleNumber(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();

        int res = 0;
        for (int num : nums) {
            //注意由于map中的类型为Integer，所以不可以++，需要+1
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        for(Integer i : map.keySet()){
            if(map.get(i) == 1) {
                res = i;
            }
        }
        return res;
    }

    /*
    * 解题思路：对于出现三次的数字，其二进制数出现的次数都是3的倍数，因此统计所有数字二进制位中1出现的次数，并对3求余，结果为只出现一次的数字
    *   eg.[3 , 3 , 5 , 3]
    *      [0 0 1 1] ; [0 0 1 1] ; [0 1 0 1] ; [0 0 1 1]
    *      二进制各位和 % 3 ：[0 , 1 , 3 , 4] % 3 = [0 , 1 , 0 , 1] = 5
    * */
    public static int singleNumber1(int[] nums) {
        //利用counts数组，存储全部数组二进制各位数的和
        int[] counts = new int[32];
        for(int num : nums){
            for(int j = 0 ; j < 32 ; j++){
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            //左移 1 位
            res <<= 1;
            //恢复第 i 位的值到 res
            res |= counts[31 - i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,3,3};
        System.out.println(singleNumber(arr));
    }

}
