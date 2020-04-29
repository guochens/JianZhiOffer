package com.sgc.p2;

import java.util.ArrayList;

public class P18 {
    public static void main(String[] args) {
        //int[][] matrix = {
        // {1,2,3,4},
        // {5,6,7,8},
        // {9,10,11,12},
        // {13,14,15,16}
        // };
        int[][] matrix = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
//        int[][] matrix={{1}};
//        int[][] matrix = {
//            {1},
//            {2},
//            {3},
//            {4},
//            {5}
//        };
        System.out.println(printMatrix1(matrix));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return null;
        }
        int x = matrix.length;
        int y = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();
        int status = 0;
        int times = 0;
        int number = 0;
        while(number<x*y){
            for(int i = 0;;i++){
                if(status==0){
                    res.add(matrix[times][times+i]);
                }else if(status==1){
                    res.add(matrix[times+1+i][y-1-times]);
                }else if(status==2){
                    res.add(matrix[x-1-times][y-1-1-times-i]);
                }else if(status==3){
                    res.add(matrix[x-1-1-times-i][times]);
                }
                number++;
                int n = 0;
                if(status%2==0){
                    n=y;
                }else{
                    n=x;
                }
                if(i==n-times*2-(status+1)/2-1){
                    if(status==3){
                        times++;
                    }
                    status = (status+1)%4;
                    break;
                }
            }
        }

        return res;
    }

    public static ArrayList<Integer> printMatrix1(int [][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        ArrayList<Integer> res = new ArrayList<>();

        int index = 0;
        int number = m*n;
        while(index<number){
            n = matrix[0].length;
            m = matrix.length;
            for(int i = 0;i<n;i++){
                res.add(matrix[0][i]);
                index++;
            }
            if(m==1){
                int[][] temp = new int[n][m-1];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m-1; j++) {
                        temp[i][j] = matrix[j+1][n - 1 - i];
                    }
                }
                matrix = temp;
            }else {
                int[][] temp = new int[n][m-1];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m-1; j++) {
                        temp[i][j] = matrix[j+1][n - 1 - i];
                    }
                }
                matrix = temp;
            }
        }
        return res;
    }
}
