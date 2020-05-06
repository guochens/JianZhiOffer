package com.sgc.p2;
//给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
// 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
// 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
public class p50 {
    public static void main(String[] args) {

    }

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for(int i = 0;i<A.length;i++){
            B[i] = 1;
            for(int j=0;j<i;j++){
                B[i] *= A[j];
            }
            for(int j=i+1;j<A.length;j++){
                B[i] *= A[j];
            }
        }
        return B;
    }

    //链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46?answerType=1&f=discussion
    //来源：牛客网

    public int[] multiply1(int[] A) {
        int length=A.length;
        int[] B=new int[length];
        //边界
        if(A==null||A.length<=1){
            return null;
        }
        //计算下三角
        //初始化第一行
        B[0]=1;
        for(int i=1;i<length;i++){
            B[i]=B[i-1]*A[i-1];
        }
        //计算上三角
        //初始化最后一行
        int temp=1;
        for(int i=length-1;i>=0;i--){
            B[i]=temp*B[i];
            temp=A[i]*temp;
        }
        return B;
    }
}
