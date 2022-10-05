package com.leetcode.DailyCheck._202210._1005;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/5 11:20
 * @Version 1.0
 */
/*
* 输入：cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
* 输出：["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
* */
public class SubdomainVisits_811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String , Integer> map = new HashMap<>();
        for(String s : cpdomains){
            String[] split = s.split(" ");
            Integer t = Integer.valueOf(split[0]);
            String[] ips = split[1].split("\\.");
            for(int i = 0 ; i < ips.length ; i++){
                int j = i;
                StringBuilder merge = new StringBuilder();
                while (j < ips.length - 1){
                    merge.append(ips[j]);
                    merge.append(".");
                    j++;
                }
                merge.append(ips[j]);
                map.put(merge.toString(), map.getOrDefault(merge.toString(), 0) + t);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String s : map.keySet()){
            StringBuilder sb = new StringBuilder();
            Integer cnt = map.get(s);
            sb.append(cnt);
            sb.append(" ");
            sb.append(s);
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        new SubdomainVisits_811().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}).forEach(System.out::println);
    }
}
