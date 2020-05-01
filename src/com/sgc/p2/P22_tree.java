package com.sgc.p2;
//题目描述
//    输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
public class P22_tree {

    public static void main(String[] args) {
        int[] sequence = {1,3,2,5,7,6,4};
        int[] sequence1 = {1,2,3,4,5};
        int[] sequence2 = {7,4,6,5};
        int[] sequence3 = {5,4,3,2,1};
        int[] sequence4 = {};
        System.out.println(VerifySquenceOfBST(sequence));
        System.out.println(VerifySquenceOfBST(sequence1));
        System.out.println(VerifySquenceOfBST(sequence2));
        System.out.println(VerifySquenceOfBST(sequence3));
        System.out.println(VerifySquenceOfBST(sequence4));
        System.out.println(VerifySquenceOfBST2(sequence));
        System.out.println(VerifySquenceOfBST2(sequence1));
        System.out.println(VerifySquenceOfBST2(sequence2));
        System.out.println(VerifySquenceOfBST2(sequence3));
        System.out.println(VerifySquenceOfBST2(sequence4));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        return bst(sequence,0,sequence.length-1);
    }
    public static boolean VerifySquenceOfBST2(int [] sequence) {
        if(sequence.length<=0){
            return false;
        }
        return bst2(sequence,0,sequence.length-1);
    }

    public static boolean bst(int[] sequence, int start, int root){
        if(root<0){
            return false;
        }
        int split = start;
        boolean isMid = false;
        if(start>=root){
            return true;
        }
        for(int i = start;i<root-1;i++){
            if(sequence[i]<sequence[root]&&sequence[i+1]>sequence[root]){
                split = i;
                isMid=true;
                break;
            }else if(sequence[i]>sequence[root]&&sequence[i+1]<sequence[root]){
                return false;
            }
        }

        if(!isMid){
            if(sequence[start]<sequence[root]){
                split = root-1;
            }else{
                split = start;
            }
        }

        for(int i = start;i<split;i++){
            if(sequence[i]>sequence[root]){
                return false;
            }
        }

        for(int i = split+1;i<root-1;i++){
            if(sequence[i]<sequence[root]){
                return false;
            }
        }
        return bst(sequence,start,split)&&bst(sequence,split+1,root-1);
    }


    public static boolean bst2(int[] sequence, int start, int root){

        if(start>=root){
            return true;
        }
        int i = start;
        while (i<root && sequence[i]<sequence[root]){
            i++;
        }

        for(int j = i;j<root;j++){
            if(sequence[j]<sequence[root]){
                return false;
            }
        }
        return bst2(sequence,start,i-1)&&bst2(sequence,i,root-1);
    }
}
