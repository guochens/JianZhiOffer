package com.sgc.leetcode.week187;

public class p2 {

    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0,1};
        int k  = 2;
        System.out.println(kLengthApart(nums, k));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        if(nums.length==0){
            return false;
        }
        boolean status = false;
        int times = 0;
        for(int i = 0;i<nums.length;i++){
            if(!status && nums[i]==1){
                status = true;
                continue;
            }
            if(status && nums[i]==1){
                if(times<k){
                    return false;
                }else{
                    times = 0;
                }
            }
            if(status && nums[i]==0){
                times++;
            }
        }
        return true;
    }
}
