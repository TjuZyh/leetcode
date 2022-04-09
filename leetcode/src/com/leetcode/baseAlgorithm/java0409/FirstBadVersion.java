package com.leetcode.baseAlgorithm.java0409;

/*
* 278: 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
* 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
* */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1 , right = n;
        while(left <= right){
            //防止计算时溢出
            int middle = left + (right - left) / 2;
            if(!isBadVersion(middle)){
                left = middle + 1;
            }else {
                right = middle - 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int i){
        return true;
    }
}
