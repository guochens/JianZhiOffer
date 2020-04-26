package com.sgc.p2;

public class p14 {
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

        ListNode l = ReverseList(ll1);
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode fake = new ListNode(0);
        if(head==null){
            return null;
        }
        ListNode temp = head.next;
        head.next = fake.next;
        fake.next = head;
        while(temp!=null){
            head = temp;
            temp = temp.next;
            head.next = fake.next;
            fake.next = head;
        }
        return fake.next;
    }
}
