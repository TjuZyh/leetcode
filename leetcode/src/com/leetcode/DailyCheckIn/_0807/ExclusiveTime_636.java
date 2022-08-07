package com.leetcode.DailyCheckIn._0807;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/8/7 11:26
 * @Version 1.0
 */
public class ExclusiveTime_636 {
    /*
    * input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
    * output: [3,4]
    * 解题思路：利用栈存储函数信息（标识符、时间戳）
    *   关于start与end两种情况：
    *   1. start：如果有函数正在被执行，则停止当前函数（更新时间戳），记录已执行时间，将新被调函数入栈
    *   2. end：将栈顶元素弹出，记录已执行时间，若栈内还有元素，即被暂停的函数，则继续执行（更新时间戳）
    * */
    public int[] exclusiveTime(int n, List<String> logs) {
        /*
        * stack与deque的区别：
        *   deque为双端队列，即两头都可进出，实现类有ArrayDeque以及LinkedList
        *   stack为栈，先进后出
        * */
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for(String log : logs){
            int curFlag = Integer.parseInt(log.substring(0 , log.indexOf(":")));
            String curAction = log.substring(log.indexOf(":") + 1 , log.lastIndexOf(":"));
            int curTime = Integer.parseInt(log.substring(log.lastIndexOf(":") + 1));
            if(curAction.equals("start")){
                if(!stack.isEmpty()){
                    //记录当前函数已经执行的时间
                    res[stack.peek()[0]] += curTime - stack.peek()[1];
                    //stack.peek()[1] = curTime;
                }
                stack.add(new int[]{curFlag , curTime});
            }else{
                int[] curEnd = stack.pop();
                res[curEnd[0]] += curTime - curEnd[1] + 1;
                if(!stack.isEmpty()){
                    stack.peek()[1] = curTime + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");

        Arrays.stream(new ExclusiveTime_636().exclusiveTime(2, logs)).forEach(System.out::println);
    }
}
