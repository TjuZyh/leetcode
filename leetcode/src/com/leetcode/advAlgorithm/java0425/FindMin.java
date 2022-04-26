package com.leetcode.advAlgorithm.java0425;

/**
 * @Author zyh
 * @Date 2022/4/26 4:23 下午
 * @Version 1.0
 */
public class FindMin {
    /*
    * 存在两种情况：
    *   1. nums[mid] < nums[high] : 证明最小值在mid的左侧，所以可以丢弃mid右侧
    *   2. nums[mid] > nums[high] : 证明最小值在mid的右侧，所以可以丢弃mid的左侧
    * */
    public int findMin(int[] nums){
        int low = 0 , high = nums.length - 1;
        while(low < high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] < nums[high]){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
