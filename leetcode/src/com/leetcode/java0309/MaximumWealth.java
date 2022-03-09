package com.leetcode.java0309;

import java.util.Arrays;

public class MaximumWealth {
    public static int maximumWealth(int[][] accounts) {
        int max = -1;
        int curWealth;
        for(int i = 0 ; i < accounts.length ; i++){
            curWealth = 0;
            for(int j = 0 ; j < accounts[i].length ; j++){
                curWealth += accounts[i][j];
            }
            if(curWealth > max){
                max = curWealth;
            }
        }
        return  max;
    }

    //利用增强for循环以及Stream流
    public static int maximumWealth1(int[][] accounts) {
        int max = -1;
        for(int[] account : accounts){
            //利用Stream流对一个数组实现加和
            int sum = Arrays.stream(account).sum();
            if(sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = new int[][]{{2,8,7} , {7,1,3} , {1,9,5}};
        System.out.println(MaximumWealth.maximumWealth(accounts));

    }
}
