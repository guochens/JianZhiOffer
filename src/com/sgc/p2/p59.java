package com.sgc.p2;

import java.util.ArrayList;

public class p59 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
            if(pRoot==null){
            return arrayLists;
        }
            arrayList.add(pRoot);
        boolean lr = true;

        add(arrayList,arrayLists,lr);
            return arrayLists;
    }

    public static void add(ArrayList<TreeNode> arrayList, ArrayList<ArrayList<Integer>> arrayLists, boolean lr){
        if(arrayList.isEmpty()){
            return;
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        if(lr){
            for(int i = 0;i<arrayList.size();i++){
                arrayList1.add(arrayList.get(i).val);
            }
        }else{
            for(int i = arrayList.size()-1;i>=0;i--){
                arrayList1.add(arrayList.get(i).val);
            }
        }
        arrayLists.add(arrayList1);
        int size = arrayList.size();
        for(int i = 0;i<size;i++){
            TreeNode temp = arrayList.get(i);
            if(temp.left!=null){
                arrayList.add(temp.left);
            }
            if(temp.right!=null){
                arrayList.add(temp.right);
            }
        }
        for(int i = 0;i<size;i++){
            arrayList.remove(0);
        }
        add(arrayList,arrayLists,lr);
    }
}
