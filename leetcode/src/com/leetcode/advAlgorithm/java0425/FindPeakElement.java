package com.leetcode.advAlgorithm.java0425;

/**
 * @Author zyh
 * @Date 2022/4/26 9:41 下午
 * @Version 1.0
 */
/*
* 162 : 峰值元素是指其值严格大于左右相邻值的元素
*   给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
* */
public class FindPeakElement {
    //如果某个元素大于后面的元素，则该元素就是峰值元素
    public static int findPeakElement1(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length  ; i++){
            if(nums[i] > nums[res]){
                res = i;
            }
        }
        return res;
    }
    /*
    * 如果某个元素大于后面的元素，则该元素就是峰值元素
    * 可以用二分去加快寻找效率：
    *   存在下面两种情况：
    *       1. nums[i] > nums[i + 1] ，则在i之前一定存在峰值，所以舍弃右边
    *       2. nums[i] < nums[i + 1] ，则在i + 1 之前一定存在峰值，所以舍弃左边
    * */
    public static int findPeakElement(int[] nums) {
        int low = 0 , high = nums.length - 1;
        while(low < high){
            int mid = (high - low) / 2 + low;
            if(nums[mid] > nums[mid + 1]){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,1};
        System.out.println(findPeakElement1(arr));
    }
}
