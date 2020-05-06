package com.sgc.p2;
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class p56 {
    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(5);
        TreeLinkNode t2 = new TreeLinkNode(4);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(2);

        t1.left = t2;
        t2.left = t3;
        t3.left = t4;

        t4.next = t3;
        t3.next = t2;
        t2.next = t1;

        System.out.println(GetNext(t2).val);
    }



    public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode==null){
            return null;
        }
        if(pNode.right != null){
            TreeLinkNode temp = pNode.right;
            while (temp.left!=null) {
                temp = temp.left;
            }
            return temp;
        }
        while(pNode.next!=null)
        {
            if(pNode.next.left==pNode)return pNode.next;
            pNode=pNode.next;
        }
        return null;
//        if(pNode.next==null){
//            return null;
//        }
//        TreeLinkNode father = pNode.next;
//        while (father.right!=null && father.right.equals(pNode)){
//            if(father==null){
//                return null;
//            }else{
//                pNode = father;
//                father = pNode.next;
//            }
//            if(father==null){
//                return null;
//            }
//        }
//        return pNode;
    }

}


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}