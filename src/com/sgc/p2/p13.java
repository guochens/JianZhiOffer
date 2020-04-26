package com.sgc.p2;


//class ListNode {
//    int val;
//    ListNode next = null;
//
//    ListNode(int val) {
//        this.val = val;
//    }
//}

public class p13 {
    public static void main(String[] args) {
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);
        ListNode ll5 = new ListNode(5);
        ListNode ll6 = new ListNode(6);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
        ll5.next = ll6;

        System.out.println(FindKthToTail(ll1, 1).val);
    }

    public static ListNode FindKthToTail(ListNode head,int k) {
        int dis = 0;
        if(head==null||k<=0){
            return null;
        }
        ListNode res = head;
        head = head.next;
        dis++;
        while(head!=null){
            dis++;
            head = head.next;
            if(dis>k){
                res = res.next;
            }
        }
        if(dis<k){
            return null;
        }else {
            return res;
        }
    }
}