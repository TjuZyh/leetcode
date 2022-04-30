package com.leetcode.advAlgorithm.java0430;

/**
 * @Author zyh
 * @Date 2022/4/30 4:15 下午
 * @Version 1.0
 */
/*
* 11 ： 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
*   找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
*   返回容器可以储存的最大水量。
* */
public class MaxArea {
    /*
    * 暴力:单纯的暴力直接时间超限
    * */
    public static int maxArea(int[] height) {
        int max = 0;
        for(int i = 0 ; i < height.length ; i++){
            for(int j = i + 1 ; j < height.length ; j++){
                int curArea = (j - i) * Math.min(height[i] , height[j]);
                max = Math.max(max , curArea);
            }
        }
        return max;
    }
    /*
    * 双指针：由于面积的大小取决于距离以及高度，在缩小距离(向内移动指针)的时候就要去寻找更高的高度，
    *   即保留高度高的边，高度低的元素对应的指针应向内移动，去寻找更高元素
    *   分别在头尾创建一个指针i，j
    *   若height[i] < height[j]，则i++
    *   若height[i] > height[j]，则j++
    * */
    public static int maxArea1(int[] height) {
        int max = 0;
        int i = 0 , j = height.length - 1;
        while(i < j){
            int curArea = (j - i) * Math.min(height[i] , height[j]);
            max = Math.max(max , curArea);
            if(height[i] < height[j]){
                ++i;
            }else{
                --j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
