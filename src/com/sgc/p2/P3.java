package com.sgc.p2;
import java.util.ArrayList;

public class P3 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = null;
        ArrayList<Integer> arrayList = printListFromTailToHead(l7);

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(listNode==null) {
            return arrayList;
        }
        arrayList.add(listNode.val);
        while(listNode.next!=null){
            listNode = listNode.next;
            arrayList.add(listNode.val);
        }
        for(int i=0;i<arrayList.size()/2;i++){
            int temp = arrayList.get(arrayList.size()-1-i);
            arrayList.set(arrayList.size()-1-i,arrayList.get(i));
            arrayList.set(i,temp);
        }
        return arrayList;
    }




}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */



