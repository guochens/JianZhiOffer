package com.sgc.p2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class p55 {
//{1,1,2,3,3,4,5,5}
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        deleteDuplication(l1);
    }



    public static ListNode deleteDuplication(ListNode pHead) {
        Set<Integer> set = new HashSet<>();
        ArrayList<ListNode> arrayList = new ArrayList<>();
        if(pHead==null){
            return null;
        }
        ListNode l1 = pHead;
        while (l1!=null){
            if(set.contains(l1.val)){
                for(int i = 0;i<arrayList.size();i++){
                    if(arrayList.get(i).val==l1.val){
                        arrayList.remove(i);
                    }
                }
            }else{
                set.add(l1.val);
                arrayList.add(l1);
            }
            l1 = l1.next;
        }
        ListNode preHead = new ListNode(0);
        if(arrayList.size()==0){
            return null;
        }else{
            pHead = arrayList.get(0);
        }
        preHead.next = pHead;
        for(int i = 1;i<arrayList.size();i++){
            pHead.next = arrayList.get(i);
            pHead = pHead.next;
        }
        pHead.next = null;
        return preHead.next;
    }
}
