package com.leetcode.DMSXL_2.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-02
 */
/*
* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
*   满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
*   返回所有和为 0 且不重复的三元组
* 输入：nums = [-1,0,1,2,-1,-4]
* 输出：[[-1,-1,2],[-1,0,1]]
* */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        //先确定第一个数，后用双指针寻找剩余两个数
        //关于去重涉及到first去重以及second、third去重
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0; first < nums.length; first++) {
            //由于数组已经排序，所以当第一值大于零后面一定凑不成0了
            if(nums[first] > 0) {
                return ans;
            }
            //对first进行去重
            //去重方式不可以为 nums[first] == nums[first + 1]，因为这样会丢解，eg.[-1,-1,2]
            //这种去重方式是元组内部能重复，而题中的意思是元组间不能重复
            if(first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int second = first + 1, third = nums.length - 1;
            while(second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if(sum > 0) {
                    third--;
                }else if(sum < 0) {
                    second++;
                }else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    ans.add(temp);
                    //移动指针，去重，找到最后一个重复的位置
                    while(second < third && nums[second + 1] == nums[second]) second++;
                    while(second < third && nums[third - 1] == nums[third]) third--;
                    //上面只是移动到最后一个重复的位置，需要再移动一位到新的元素位置
                    second++;
                    third--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
