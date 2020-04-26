package com.sgc.p2;

public class p11 {
    public static void main(String[] args) {
        System.out.println(Power(23, 10));
    }
    public static double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }
        if(base==0){
            return 0;
        }
        double res = 1;
        boolean isFu = false;
        if(exponent<0){
            isFu = true;
            exponent = -exponent;
        }
        while (exponent!=0){
            res = res * base;
            exponent--;
        }
        if(isFu){
            res = 1 / res;
        }
        return res;
    }
}
