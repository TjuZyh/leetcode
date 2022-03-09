package com.leetcode.java0309;

public class NumberOfSteps {
    public static int numberOfSteps(int num) {
        int step = 0;
        while(num != 0){
            if(num % 2 == 0){
                num /= 2;
            }else{
                num -= 1;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfSteps.numberOfSteps(123));
    }
}
