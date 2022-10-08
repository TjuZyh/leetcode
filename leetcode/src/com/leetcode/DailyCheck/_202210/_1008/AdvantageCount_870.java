package com.leetcode.DailyCheck._202210._1008;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/8 20:17
 * @Version 1.0
 */
/*
* 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
* 输出：[24,32,8,12]
* */
public class AdvantageCount_870 {
    /*
    * 贪心思想：田忌赛马
    * 算法流程：
    *   现将两个数组均从小到大排序，后设定双指针index1，index2分别指向两个数组的首部
    *   比较当前指针上的元素大小，若num1 < num2，则index1++；否则，将该两个元素记录下来，直到index1遍历结束
    *
    * 小tips：
    *   对于对元素组排序后还需要保留原数组顺序的问题：
    *       可以创建一个索引数组记录原来数组的索引，对索引数组进行自定义排序（以arr[index]的大小进行排序）即可
    * */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //ids用于记录数组中的索引
        Integer[] ids1 = new Integer[n];
        Integer[] ids2 = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            ids1[i] = i;
            ids2[i] = i;
        }
        //通过元素大小对索引进行排序
        Arrays.sort(ids1 , (i , j) -> nums1[i] - nums1[j]);
        Arrays.sort(ids2 , (i , j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        //设立一个头一个尾指针，如果当前大于nums2上的元素，则对应；若不大于则对应nums2中最大的元素
        int left = 0 , right = n - 1;
        for(int i = 0 ; i < n ; i++){
            //如果当前nums1 > nums2，则找到nums2的位置，直接对应位置赋值即可
            if(nums1[ids1[i]] > nums2[ids2[left]]){
                ans[ids2[left]] = nums1[ids1[i]];
                left++;
            }else {//否则，将该数与nums2中最大的数对应起来（田忌的下等马对上齐威王的上等马）
                ans[ids2[right]] = nums1[ids1[i]];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1 = {12,24,8,32};
        int[] arr2 = {13,25,32,11};
        System.out.println(Arrays.toString(new AdvantageCount_870().advantageCount(arr1, arr2)));
    }
}
