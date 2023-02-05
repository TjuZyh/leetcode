package com.leetcode.DMSXL.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author zyh
 * @Date 2023/2/5 12:14
 * @Version 1.0
 */
/*
* 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，
* 其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。
* 如果气温在这之后都不会升高，请在该位置用0 来代替
*   输入: temperatures = [73,74,75,71,69,72,76,73]
*   输出: [1,1,4,2,1,1,0,0]
* */
public class DailyTemperatures_739 {
    //暴力模拟
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for(int i = 0; i < temperatures.length - 1; i++) {
            int days = 0;
            //下一个天气比当前天气高
            if(temperatures[i + 1] > temperatures[i]) {
                days++;
            }else {
                int j = i;
                while(j < temperatures.length - 1 && temperatures[j + 1] <= temperatures[i]) {
                    days++;
                    j++;
                }
                //找到末尾也没有比其温度高的天气
                if(j == temperatures.length - 1 && temperatures[j] <= temperatures[i]) {
                    days = 0;
                }else {
                    days++;
                }
            }
            ans[i] = days;
        }
        return ans;
    }

    //记忆化暴力
    //利用next数组记录每个温度第一次出现的下标
    //后序遍历数字，寻找当前温度到100中，最小的下标，下标相减即为天数
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[temperatures.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for(int i = length - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for(int t = temperatures[i] + 1; t <= 100; t++) {
                if(next[t] < warmerIndex) {
                    warmerIndex = next[t];
                    //System.out.println(i + "--" + temperatures[i] + "--" +warmerIndex);
                }
            }
            if(warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
                //System.out.println("ans" + i + ":" + ans[i]);
            }
            next[temperatures[i]] = i;
        }
        //System.out.println(Arrays.toString(next));
        return ans;
    }

    //单调栈：维护单调栈，存储下标，栈底到栈顶下标对应温度依次递减
    public int[] dailyTemperatures3(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int preIndex = stack.poll();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DailyTemperatures_739().dailyTemperatures2(new int[]{73,74,75,71,69,72,76,73})));
    }
}
