package com.sgc.p2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class p64 {
    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] matrix1 = "ABCESFCSADEE".toCharArray();
        char[] str = "bcced".toCharArray();
        char[] str1 = "abcb".toCharArray();
        char[] str2 = "SEE".toCharArray();
        System.out.println(hasPath(matrix1, 3, 4, str2));
        System.out.println(hasPath(matrix, 3, 4, str));
        map.clear();
        System.out.println(hasPath(matrix, 3, 4, str1));
    }
    static boolean isFound = false;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        return traverse(matrix,rows,cols,str,0,0,0);
    }

    public static boolean traverse(char[] matrix,int rows, int cols, char[] str, int row,int col,int len){
        if(row>=rows || col>=cols){
            return false;
        }
        if(len==str.length){
            return true;
        }
        boolean found = false;
        if(isFound){
            if(matrix[row*cols+col]==str[len]){
                found = true;
                if(map.containsKey(row)){
                    if(map.get(row).contains(col)){
                        return false;
                    }
                    map.get(row).add(col);
                }else{
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(col);
                    map.put(row,arrayList);
                }
                boolean up = false,down = false,left = false,right = false;
                if(row<rows-1){
                    down = found?traverse(matrix,rows,cols,str,row+1,col,len+1):traverse(matrix,rows,cols,str,row+1,col,len);
                }
                if(row>0){
                    up = found?traverse(matrix,rows,cols,str,row-1,col,len+1):traverse(matrix,rows,cols,str,row-1,col,len);
                }
                if(col<cols-1){
                    right = found?traverse(matrix,rows,cols,str,row,col+1,len+1):traverse(matrix,rows,cols,str,row,col+1,len);
                }
                if(col>0){
                    left = found?traverse(matrix,rows,cols,str,row,col-1,len+1):traverse(matrix,rows,cols,str,row,col-1,len);
                }
                return up || down || left || right;
            }else {
                return false;
            }
        }
        else if(map.containsKey(row)){
            if(map.get(row).contains(col)){
                return false;
            }else if(matrix[row*cols+col]==str[len]){
                found = true;
                if(!isFound){
                    isFound = true;
                    map.clear();
                    ArrayList<Integer> arrayList1 = new ArrayList<>();
                    arrayList1.add(col);
                    map.put(row,arrayList1);
                }else{
                    map.get(row).add(col);
                }
            }else{
                map.get(row).add(col);
            }
        }else{
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(col);
            map.put(row,arrayList);
            if(matrix[row*cols+col]==str[len]){
                found = true;
                if(!isFound){
                    isFound = true;
                    map.clear();
                    ArrayList<Integer> arrayList1 = new ArrayList<>();
                    arrayList1.add(col);
                    map.put(row,arrayList1);
                }
            }
        }

        boolean up = false,down = false,left = false,right = false;
        if(row<rows-1){
            down = found?traverse(matrix,rows,cols,str,row+1,col,len+1):traverse(matrix,rows,cols,str,row+1,col,len);
        }
        if(row>0){
            up = found?traverse(matrix,rows,cols,str,row-1,col,len+1):traverse(matrix,rows,cols,str,row-1,col,len);
        }
        if(col<cols-1){
            right = found?traverse(matrix,rows,cols,str,row,col+1,len+1):traverse(matrix,rows,cols,str,row,col+1,len);
        }
        if(col>0){
            left = found?traverse(matrix,rows,cols,str,row,col-1,len+1):traverse(matrix,rows,cols,str,row,col-1,len);
        }
        return up || down || left || right;
    }
}
