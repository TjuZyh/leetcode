package com.leetcode.java0405;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
* offer38：输入一个字符串，打印出该字符串中字符的所有排列
*   你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
* */
public class Permutation {
    //为了让递归函数添加结果方便，定义到函数之外，这样无需带到递归函数的参数列表中
    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        //从第一层开始递归
        dfs(0);
        return res.toArray(new String[0]);
    }

    public void dfs(int x){
        if(x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x ; i < c.length ; i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i , x);
            dfs(x + 1);
            swap(i , x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
