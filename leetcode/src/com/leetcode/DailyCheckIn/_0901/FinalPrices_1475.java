package com.leetcode.DailyCheckIn._0901;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/9/1 20:19
 * @Version 1.0
 */
public class FinalPrices_1475 {
    /*
    * 暴力遍历
    * */
    public int[] finalPrices(int[] prices) {
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i + 1 ; j < prices.length ; j++){
                if(prices[j] <= prices[i]){
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

    /*
    * 单调栈：凡是看到需要用到第一个小于(等于)/大于(等于)该元素的元素，多半可以使用单调栈
    *   维护一个单调栈，查询元素对应位置右侧的最小元素无需遍历右侧数组，只需访问栈顶元素即可
    *   倒序遍历数组，每当移动到新的位置，将栈中大于数组当前位置值的元素pop，这样栈顶就是数组右侧第一个最小元素，直接相减即可
    * */
    public int[] finalPrices1(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i = prices.length - 1 ; i >= 0 ; i--){
            //将栈顶元素调整为右侧第一个小于price[i]的元素
            while(!stack.isEmpty() && stack.peek() > prices[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] ints = new FinalPrices_1475().finalPrices(new int[]{10,1,1,6});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
