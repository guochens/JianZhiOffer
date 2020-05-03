package com.sgc.p2;

import java.util.ArrayList;

//把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class p32 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(1000));
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i2 = 0, i3 = 0, i5 = 0;
        arrayList.add(1);
        int temp = arrayList.get(arrayList.size()-1);
        while (arrayList.size()<index){
            int temp1 = Math.min(Math.min(arrayList.get(i2)*2,arrayList.get(i3)*3),arrayList.get(i5)*5);
            arrayList.add(temp1);
            if(temp1/2==arrayList.get(i2)){
                i2++;
            }
            if(temp1/3==arrayList.get(i3)){
                i3++;
            }
            if(temp1/5==arrayList.get(i5)){
                i5++;
            }
        }

        return arrayList.get(index-1);

    }

    public static int GetUglyNumber_Solution1(int index) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(index<1){
            return 0;
        }
        arrayList.add(1);
        if(arrayList.size()>=index) {
            return arrayList.get(index-1);
        }

        for(int j = arrayList.get(arrayList.size()-1)+1;arrayList.size()<index;j++){
            if(sub(j)){
                arrayList.add(j);
            }
        }

        return arrayList.get(index-1);
    }

    public static boolean sub(int num){
        if(num==1){
            return true;
        }
        while(num%2 == 0){
            num /= 2;
        }
        while(num%3 == 0){
            num /= 3;
        }
        while(num%5 == 0){
            num /= 5;
        }
        if(num==1){
            return true;
        }else{
            return false;
        }
    }
}
