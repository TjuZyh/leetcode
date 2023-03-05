package com.leetcode.DMSXL.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2023/3/5 10:43
 * @Version 1.0
 */
/*
* 一开始你手头没有任何零钱，每一杯柠檬水的售价为 5 美元，你必须给每个顾客正确找零
*   输入：bills = [5,5,5,10,20]
*   输出：true
* */
public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> balance = new HashMap<>();
        for(int i = 0; i < bills.length; i++) {
            int payment = bills[i];
            if(payment == 5) {
                balance.put(5, balance.getOrDefault(5, 0) + 1);
            }else if(payment == 10){
                if(balance.containsKey(5) && balance.get(5) >= 1) {
                    balance.put(10, balance.getOrDefault(10, 0) + 1);
                    balance.put(5, balance.get(5) - 1);
                }else {
                    return false;
                }
            }else {
                //先找10块 + 5块的，没有10块的找三个5块
                if(balance.containsKey(10) && balance.get(10) >= 1 && balance.containsKey(5) && balance.get(5) >= 1) {
                    balance.put(20, balance.getOrDefault(20, 0) + 1);
                    balance.put(10, balance.get(10) - 1);
                    balance.put(5, balance.get(5) - 1);
                }else if(balance.containsKey(5) && balance.get(5) >= 3) {
                    balance.put(20, balance.getOrDefault(10, 0) + 1);
                    balance.put(5, balance.get(5) - 3);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    //只涉及到三个数，不需要map，直接数组存即可
    public boolean lemonadeChange2(int[] bills) {
        int[] arr = new int[3];
        for(int i = 0; i < bills.length; i++) {
            int payment = bills[i];
            if(payment == 5) {
                arr[0]++;
            }else if(payment == 10){
                if(arr[0] >= 1) {
                    arr[1]++;
                    arr[0]--;
                }else {
                    return false;
                }
            }else {
                //先找10块 + 5块的，没有10块的找三个5块
                if(arr[1] >= 1 && arr[0] >= 1) {
                    arr[2]++;
                    arr[1]--;
                    arr[0]--;
                }else if(arr[0] >= 3) {
                    arr[1]++;
                    arr[0] -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LemonadeChange_860().lemonadeChange2(new int[]{5, 5, 5, 10, 20}));
    }
}
