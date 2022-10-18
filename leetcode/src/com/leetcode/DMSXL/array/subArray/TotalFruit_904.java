package com.leetcode.DMSXL.array.subArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/18 20:13
 * @Version 1.0
 */
/*
* 寻找最长子数组长度：子数组中只可以有两类重复元素
* 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
* 输出：5 （1,2,1,1,2）
* */
public class TotalFruit_904 {
    /*
    * 滑动窗口 + 哈希表
    *   涉及到子数组问题想到滑动窗口，涉及到元素计数想到哈希表
    * */
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0, ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                map.put(fruits[left] , map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans , right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TotalFruit_904().totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}
