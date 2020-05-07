package com.sgc.p2;

public class p64_2 {

    public static void main(String[] args) {
        char[] matrix = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] matrix1 = "ABCESFCSADEE".toCharArray();
        char[] str = "bcced".toCharArray();
        char[] str1 = "abcb".toCharArray();
        char[] str2 = "SEE".toCharArray();
        System.out.println(hasPath(matrix1, 3, 4, str2));
        System.out.println(hasPath(matrix, 3, 4, str));
        System.out.println(hasPath(matrix, 3, 4, str1));
    }


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(rows<=0 || cols<=0 || matrix.length!=rows*cols || matrix.length<str.length){
            return false;
        }
        boolean[] visited = new boolean[rows*cols];
        int[] pathLength = {0};
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(subHasPath(matrix,rows,cols,i,j,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean subHasPath(char[] matrix,int rows,int cols,int row,int col,char[] str,int[] pathLength,boolean[] visited){
        int index = row*cols+col;
        if(pathLength[0]==str.length){
            return true;
        }
        if( row<rows && row>=0 && col<cols && col>=0 && visited[index]==false && matrix[index]==str[pathLength[0]]){
            pathLength[0]++;
            visited[index] = true;
            boolean flag =false;
            flag = subHasPath(matrix,rows,cols,row+1,col,str,pathLength,visited) ||
                subHasPath(matrix,rows,cols,row-1,col,str,pathLength,visited) ||
                subHasPath(matrix,rows,cols,row,col+1,str,pathLength,visited) ||
                subHasPath(matrix,rows,cols,row,col-1,str,pathLength,visited);
            if(!flag){
                pathLength[0]--;
                visited[index]=false;
            }
            return flag;
        }
        return false;

    }
}
