package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zyh
 * @Date 2023/3/7 16:34
 * @Version 1.0
 */
public class IOTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.println("input: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("arr : " + Arrays.toString(arr));*/

        //next()遇到空格直接停止读入
        /*String str = scanner.next();
        System.out.println("str : " + str);*/

        //nextLine()读取包括空格以及回车
        /*String str1 = scanner.nextLine();
        System.out.println("str1: " + str1);*/

        List<Integer> list = new ArrayList<>();
        //通过hashNext()
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            list.add(n);
        }
        System.out.println(list);

        scanner.close();


    }
}
