package com.leetcode.DMSXL.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/1 15:37
 * @Version 1.0
 */
/*
* 第 i 个加油站有汽油 gas[i] 升, 从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升
*   给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1
* */
public class CanCompleteCircuit_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        List<Integer> availableIndex = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(gas[i] - cost[i] >= 0) {
                availableIndex.add(i);
            }
        }
        if(availableIndex.size() == 0) {
            return -1;
        }
        Collections.sort(availableIndex, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (gas[o2] - cost[o2]) - (gas[o1] - cost[o1]);
            }
        });


        for(Integer beginIndex : availableIndex) {
            int curGas = 0;
            boolean flag = true;
            for(int i = beginIndex; i < n * 2 - 1; i++) {
                curGas += gas[i % n];
                if(curGas < cost[i % n]) {
                    flag = false;
                }else {
                    curGas -= cost[i % n];
                }
            }
            if(flag) {
                return beginIndex;
            }
        }
        return -1;
    }

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new CanCompleteCircuit_134().canCompleteCircuit(new int[]{1,2,3,4,3,2,4,1,5,3,2,4}, new int[]{1,1,1,3,2,4,3,6,7,4,3,1}));
    }
}