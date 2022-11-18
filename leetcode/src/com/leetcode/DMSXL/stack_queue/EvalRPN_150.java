package com.leetcode.DMSXL.stack_queue;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/11/17 22:19
 * @Version 1.0
 */
/*
* 输入：tokens = ["4","13","5","/","+"]
* 输出：6
* (4 + (13 / 5)) = 6
* */
public class EvalRPN_150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String str : tokens) {
            if(Character.isDigit(str.charAt(str.length() - 1))) {
                stack.push(str);
            }else {
                int second = Integer.parseInt(stack.pop());
                int first = Integer.parseInt(stack.pop());
                switch (str) {
                    case "+":
                        stack.push(String.valueOf((first + second)));
                        break;
                    case "-":
                        stack.push(String.valueOf((first - second)));
                        break;
                    case "*":
                        stack.push(String.valueOf((first * second)));
                        break;
                    default:
                        stack.push(String.valueOf((first / second)));
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /*
    * 可以用数组来代替栈
    * */
    public int evalRPN2(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(1 + n) / 2];
        int index = -1;
        for(int i = 0; i < n; i++) {
            String token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
            }
        }
        return stack[index];
    }

    public static void main(String[] args) {
        System.out.println(new EvalRPN_150().evalRPN2(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
