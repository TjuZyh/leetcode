package com.leetcode.DailyCheckIn._0825;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/8/25 20:32
 * @Version 1.0
 */
public class FindClosestElements_658 {
    /*
    * 查找 + 双指针问题：
    *   创建left与right指针，初始化位置后，移动记录即可
    * */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0 , right = 0;
        int xIndex = 0;
        boolean flag = false;
        // 二分查找
        int low = 0 , high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == x){
                xIndex = mid;
                flag = true;
                break;
            }else if(arr[mid] < x){
                low = mid + 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }
        }
        if(!flag){
            xIndex = low - 1;
        }
        System.out.println(xIndex);
        left = xIndex;
        right = xIndex + 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if(left < 0){
                ans.add(arr[right]);
                right++;
                continue;
            }
            if(right > arr.length - 1){
                ans.add(arr[left]);
                left--;
                continue;
            }
            if(Math.abs(x - arr[left]) <= Math.abs(x - arr[right])){
                ans.add(arr[left]);
                left--;
            }else if (Math.abs(x - arr[left]) > Math.abs(x - arr[right])){
                ans.add(arr[right]);
                right++;
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        new FindClosestElements_658().findClosestElements(new int[]{1,5,10} ,1 ,4).forEach(System.out::println);
    }
}
