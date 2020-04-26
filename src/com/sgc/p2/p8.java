package com.sgc.p2;

public class p8 {

    public static int JumpFloor(int target) {
        if(target<=0){
            throw new RuntimeException("target < 0!");
        }
        if(target==1){
            return 1;
        }else if(target==2){
            return 2;
        }
        int[] n = new int[target];
        n[0] = 1;
        n[1] = 2;
        for(int i = 2;i<target;i++){
            for(int j = 0; j<i;j++){
                n[i] += n[j];
            }
            n[i]++;
        }
        return n[target-1];
    }

    public static int JumpFloor2(int target) {
        int res = 1;
        for(int i=2;i<=target;i++){
            res *= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(1));
        System.out.println(JumpFloor(2));
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor(5));
        System.out.println(JumpFloor(6));
        System.out.println(JumpFloor(7));
        System.out.println(JumpFloor2(1));
        System.out.println(JumpFloor2(2));
        System.out.println(JumpFloor2(3));
        System.out.println(JumpFloor2(4));
        System.out.println(JumpFloor2(5));
        System.out.println(JumpFloor2(6));
        System.out.println(JumpFloor2(7));
    }
}
