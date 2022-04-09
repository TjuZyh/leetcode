package com.leetcode.offer.java0313;

/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
    请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
* */
public class MinArray {
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while(left < right){
            int middle = left + (right - left) / 2;
            if(numbers[middle] > numbers[right]){
                left = middle + 1;
            }else if(numbers[middle] < numbers[right]){
                right = middle;
            }else {
                right -= 1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(minArray(arr));
    }
}
