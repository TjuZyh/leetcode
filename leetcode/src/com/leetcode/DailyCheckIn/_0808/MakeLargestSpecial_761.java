package com.leetcode.DailyCheckIn._0808;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/8/8 20:32
 * @Version 1.0
 */
public class MakeLargestSpecial_761 {
    public String makeLargestSpecial(String s) {
        if(s.length() <= 2){
            return s;
        }
        int cnt = 0 , left = 0;
        List<String> subs = new ArrayList<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '1'){
                ++cnt;
            }else {
                --cnt;
                if(cnt == 0){
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1 , i)) + "0");
                    subs.stream().forEach(System.out::println);
                    left = i + 1;
                }
            }
        }
        //System.out.println();
        subs.sort((a, b) -> b.compareTo(a));
        //subs.stream().forEach(System.out::println);
        StringBuilder ans = new StringBuilder();
        for(String sub : subs){
            ans.append(sub);
            System.out.println("-" + ans);

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        new MakeLargestSpecial_761().makeLargestSpecial("11011000");
    }
}
