package com.leetcode.baseAlgorithm.java0412;

/*
* 344：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
* */
public class ReverseString {
    /*
    * 双指针
    * */
    public void reverseString(char[] s) {
        int left = 0 , right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            /*
            * 关于++i和i++的区别：
            *   i++是先用临时对象保存原来的对象，然后对原对象自增，再返回临时对象，不能作为左值；
            *   ++i是直接对于原对象进行自增，然后返回原对象的引用，可以作为左值
            * 原因：
            *   由于要生成临时对象，i++需要调用两次拷贝构造函数与析构函数（将原对象赋给临时对象一次，临时对象以值传递方式返回一次）；
            *   ++i由于不用生成临时变量，且以引用方式返回，故没有构造与析构的开销，效率更高
            * */
            ++left;
            --right;
        }
    }
}
