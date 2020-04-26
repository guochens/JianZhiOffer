package com.sgc.p2;

public class p9 {
    public static void main(String[] args) {
        System.out.println(RectCover(1));
        System.out.println(RectCover(2));
        System.out.println(RectCover(3));
        System.out.println(RectCover(4));
        System.out.println(RectCover(5));
        System.out.println(RectCover(6));
        System.out.println(RectCover(7));
        System.out.println(RectCover(8));
    }
    public static int RectCover(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int a1 = 1;
        int a2 = 2;
        int res=0;
        for(int i=3;i<=target;i++){
            res = a1+a2;
            a1 = a2;
            a2 = res;
        }
        return res;
    }
}
