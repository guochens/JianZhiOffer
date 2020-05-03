package com.sgc.leetcode.week187;

import java.util.ArrayList;
import java.util.Arrays;

//给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
//
//你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
public class p4 {

    public static void main(String[] args) {
        int[][] mat = {
            {1,3,11},
            {2,4,6}
        };
        int[][] mat1 = {
            {1,3,11},
            {2,4,6}
        };
        int[][] mat2 = {
            {1,10,10},
            {1,4,5},
            {2,3,6}
        };
        int[][] mat3 = {
            {1,1,10},
            {2,2,9}
        };
        int k = 5,k1=9,k2 = 7,k3 = 7;
        System.out.println(kthSmallest(mat, k));
        System.out.println(kthSmallest(mat1, k1));
        System.out.println(kthSmallest(mat2, k2));
        System.out.println(kthSmallest(mat3, k3));
    }

    public static int kthSmallest(int[][] mat, int k) {
        if(mat.length==0){
            return 0;
        }else if(mat[0].length==0){
            return 0;
        }
        int row = mat.length;
        int column = mat[0].length;

        int[] add = mat[0];
        for(int i = 1;i<row;i++){
            int[] temp = new int[add.length*column];
            for(int j = 0;j<add.length;j++){
                for(int k1 = 0;k1<column;k1++){
                    temp[j*column+k1] = add[j]+mat[i][k1];
                }
            }
            Arrays.sort(temp);
            add = Arrays.copyOfRange(temp,0,Math.min(200,temp.length));
        }
        if(k>add.length){
            return 0;
        }
        return add[k-1];
    }
}
