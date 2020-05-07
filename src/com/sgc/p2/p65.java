package com.sgc.p2;

public class p65 {

    public static void main(String[] args) {
        System.out.println(movingCount(12, 100, 100));
    }

    public static int movingCount(int threshold, int rows, int cols) {
        int[] nums = {0};
        int i = 0,j =0;
        boolean[] visited = new boolean[rows*cols];
        subJudge(rows,cols,i,j,threshold,nums,visited);
        return nums[0];
    }

    public static void subJudge(int rows,int cols,int row,int col,int k,int[] nums,boolean[] visited){
        if(row<0 || row>=rows || col<0 || col>=cols){
            return;
        }
        if(visited[row*cols+col]){
            return;
        }
        visited[row*cols+col]=true;
        if(subCal(row)+subCal(col)>k){
            return;
        }
        nums[0]++;
        subJudge(rows,cols,row+1,col,k,nums,visited);
        subJudge(rows,cols,row-1,col,k,nums,visited);
        subJudge(rows,cols,row,col+1,k,nums,visited);
        subJudge(rows,cols,row,col-1,k,nums,visited);
        return;
    }

    public static int subCal(int num){
        int res = 0;
        char[] temp = String.valueOf(num).toCharArray();
        for(int i = 0;i<temp.length;i++){
            res += temp[i]-'0';
        }
        return res;
    }

}
