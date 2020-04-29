package com.sgc.p2;

import com.sun.scenario.effect.Merge;

import java.util.List;

public class p15 {
    public static void main(String[] args) {
        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(3);
        ListNode ll4 = new ListNode(4);
        ListNode ll5 = new ListNode(5);
        ListNode ll6 = new ListNode(6);
        ll1.next = ll2;
        ll2.next = ll3;
        //ll3.next = ll4;
        ll4.next = ll5;
        ll5.next = ll6;
        //ListNode lnew = Merge(ll1,ll4);
        ListNode lnew = Merge2(ll1,ll4);
        //ListNode lnew = Merge3(ll1,ll4);
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = null;

        if(list1!=null||list2!=null){
            if(list1==null){
                head = list2;
                list2 = list2.next;
            }else if(list2 == null){
                head = list1;
                list1 = list1.next;
            }else{
                if(list1.val<=list2.val){
                    head = list1;
                    list1 = list1.next;
                }else {
                    head = list2;
                    list2 = list2.next;
                }
            }

        }

        ListNode pre = new ListNode(0);
        pre.next = head;

        while(list1!=null||list2!=null){
            if(list1==null){
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }else if(list2 == null){
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            }else{
                if(list1.val<=list2.val){
                    head.next = list1;
                    head = head.next;
                    list1 = list1.next;
                }else {
                    head.next = list2;
                    head = head.next;
                    list2 = list2.next;
                }
            }

        }
        return pre.next;
    }

    //非递归版本
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        ListNode preHead = null;
        ListNode current = null;

        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                if(current == null){
                    preHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(current == null){
                    preHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1!=null){
//            current.next=  list1;
//            current = current.next;
//            list1 = list1.next;
            current.next = list1;
        }
        if(list2!=null){
//            current.next=  list2;
//            current = current.next;
//            list2 = list2.next;
            current.next = list2;
        }
        return preHead;
    }

    //递归版本
    public static ListNode Merge3(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }

        ListNode current = null;


        if(list1.val<list2.val){
            current = list1;
            current.next = Merge3(list1.next,list2);
        }else{
            current = list2;
            current.next = Merge3(list1,list2.next);
        }

        return  current;
    }
}
