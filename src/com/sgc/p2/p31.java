package com.sgc.p2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class p31 {

    public static void main(String[] args) {
        int[] numbers1 = {1,12,123};
        int[] numbers2 = {3,32,321};
        int[] numbers3 = {3334,3,3333332};
        int[] numbers4 = {1,11,111};
        System.out.println(PrintMinNumber(numbers1));
        System.out.println(PrintMinNumber(numbers2));
        System.out.println(PrintMinNumber(numbers3));
        System.out.println(PrintMinNumber(numbers4));
        System.out.println(PrintMinNumber1(numbers1));
        System.out.println(PrintMinNumber1(numbers2));
        System.out.println(PrintMinNumber1(numbers3));
        System.out.println(PrintMinNumber1(numbers4));

    }

    public static String PrintMinNumber1(int [] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });
        String s = strings[0];
        for(int i = 1;i<strings.length;i++){
            s = s + strings[i];
        }
        return s;
    }

    public static String PrintMinNumber(int [] numbers) {
        if(numbers.length==0){
            return "";
        }
        String[] strings = new String[numbers.length];
        for(int i = 0;i<numbers.length;i++){
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1,s2 = null;
                if(o1.length()>o2.length()){
                    s1 = o2;
                    s2 = o1;
                }else{
                    s1 = o1;
                    s2 = o2;
                }
                if(Comp(s1,s2)){
                    for (int i = 0,j=0; i < s1.length() && j<s2.length()-s1.length();) {
                        if(s1.charAt(i)==s2.charAt(s1.length()+j)){
                            j++;
                            continue;
                        }
                        if(s1.charAt(i)<s2.charAt(s1.length()+j)){
                            i++;
                            if(o1.length()<o2.length()){
                                return -1;
                            }else{
                                return 1;
                            }
                        }else if(s1.charAt(i)>s2.charAt(s1.length()+j)){
                            i++;
                            if(o1.length()<o2.length()){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    }
                }
                return o1.compareTo(o2);
            }
        });

        String s = strings[0];
        for(int i = 1;i<strings.length;i++){
            s = s + strings[i];
        }
        return s;
    }

    public static boolean Comp(String s1, String s2){
        for(int i = 0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
