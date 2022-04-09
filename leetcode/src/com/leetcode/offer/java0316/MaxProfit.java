package com.leetcode.offer.java0316;

/*
* 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
* */
public class MaxProfit {
    /*
    * 暴力：两次循环求最大值，复杂度O(n^2)
    * */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i + 1 ; j < prices.length ; j++){
                if(prices[j] - prices[i] > max){
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    /*
    * 动态规划
    * */
    public static int maxProfit1(int[] prices){
        int cost = Integer.MAX_VALUE , profit = 0;
        for(int price : prices){
            cost = Math.min(cost , price);
            profit = Math.max(profit , price - cost);
        }
        return profit;
    }



    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int[] arr1 = {7,6,4,3,1};
        System.out.println(maxProfit(arr1));
    }
}
