package com.leetcode.DMSXL.hashTable;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/5 14:13
 * @Version 1.0
 */
/*
* 返回和为0的三元组
*   输入：nums = [-1,0,1,2,-1,-4]
*   输出：[[-1,-1,2],[-1,0,1]]
* */
public class ThreeSum_15 {
    /*
    * 暴力方式时间复杂度为O(n^3)，可以使用双指针动态消去无效解来加快效率
    *   整体思路：先排序，后确定一个位置，再利用双指针寻找其余两个符合要求的位置即可
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int k = 0; k < nums.length - 2; k++) {
            //如果nums[k]大于0，则三者之和一定大于0，则直接跳出
            if(nums[k] > 0) break;
            //判重，如果当前值与前一个值相同，则后移指针
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            //设立双指针i,j
            int i = k + 1, j = nums.length - 1;
            while(i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                //移动双指针寻找满足条件的i j
                //移动时注意判重
                if(sum < 0) {
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[i] == nums[i + 1]) i++;
                    i++;
                }else if(sum > 0) {
                    while(i < j && nums[j] == nums[j - 1]) j--;
                    j--;
                }else {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[k]);
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    ans.add(cur);
                    //继续缩小范围寻找解
                    while(i < j && nums[i] == nums[i + 1]) i++;
                    i++;
                    while(i < j && nums[j] == nums[j - 1]) j--;
                    j--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
