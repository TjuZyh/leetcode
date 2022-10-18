package com.leetcode.DMSXL.array.removeElement;

import com.leetcode.DMSXL.array.binaryFind.SearchRange_34;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/13 21:19
 * @Version 1.0
 */
public class RemoveElement_27 {
    /*
    * 不改变数组中元素位置，暴力
    * */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int index = 0;
        while(index < len){
            if(nums[index] == val){
                for(int i = index ; i < len - 1 ; i++){
                    nums[i] = nums[i + 1];
                }
                len--;
            }else {
                index++;
            }
        }
        return len;
    }

    /*
    * 排序二分寻找删除位置，后移动数组即可
    * */
    public int removeElement2(int[] nums, int val) {
        Arrays.sort(nums);
        int[] range = new SearchRange_34().searchRange(nums, val);
        int left = range[0];
        int right = range[1];
        for(int i = left , j = right + 1 ; j < nums.length ; i++, j++){
            nums[i] = nums[j];
        }
        return nums.length - (right - left + 1);
    }

    /*
    * 双指针：
    *   思路：将符合的元素直接覆盖到原来的数组上即可
    *   实现：设定双指针 left：当前要覆盖的位置 right：符合的元素（不等于val的元素）
    *
    * */
    public int removeElement3(int[] nums, int val) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] == val){
                right++;
            }else {
                nums[left] = nums[right];
                right++;
                left++;
            }
        }
        return left;
    }

    /*
    * 双指针优化
    * */
    public int removeElement4(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            //如果赋值过来的值也为val，由于left不移动，right左移，所以终将会将当前left位置赋值为不等于val的元素
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        System.out.println(new RemoveElement_27().removeElement4(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
