package com.leetcode.DailyCheckIn._0923;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/23 19:02
 * @Version 1.0
 */
public class MyLinkedList_707 {
    List<Integer> list;
    public MyLinkedList_707() {
        list=new ArrayList<>();
    }

    public int get(int index) {
        return index < 0 || index >= list.size() ? -1 : list.get(index);
    }

    public void addAtHead(int val) {
        list.add(0 , val);
    }

    public void addAtTail(int val) {
        list.add(val);
    }

    public void addAtIndex(int index, int val) {
        if(index <= list.size()){
            list.add(index , val);
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= 0 && index < list.size()){
            list.remove(index);
        }
    }



    public static void main(String[] args) {
        //System.out.println(new MyLinkedList_707().getListLength());
        MyLinkedList_707 myLinkedList = new MyLinkedList_707();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);


        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        System.out.println(myLinkedList.get(1));
    }
}
