package com.leetcode.DailyCheckIn._0915;

/**
 * @Author zyh
 * @Date 2022/9/15 21:09
 * @Version 1.0
 */
public class FlipLights_672 {
    /*
    * 找规律：
    *   当n == 1时，开关1、3、4对其造成影响，也只有开和关两种状态
    *   当n == 2时，按照推理111的状态推理11，按一次有3种，按2次及以上有4种。
    *   当n == 3时，按一次有4种，按2次及以上有7种,3次及以上有8种。
    * */
    public int flipLights(int n, int presses) {
        if(presses == 0){
            return 1;
        }
        if(n == 1){
            return 2;
        }else if(n == 2){
            return presses == 1 ? 3 : 4;
        }else {
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
}
