package com.sgc.p2;

import java.util.HashMap;
import java.util.Map;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}


public class p24 {
    public static void main(String[] args) {
        RandomListNode r1 = new RandomListNode(1);
        RandomListNode r2 = new RandomListNode(2);
        RandomListNode r3 = new RandomListNode(3);
//        RandomListNode r4 = new RandomListNode(4);
//        RandomListNode r5 = new RandomListNode(4);

        r1.next = r2;
        r2.next = r3;
        r3.next = r1;
//        r3.next = r4;
//        r4.next = r5;

        r1.random = r3;
        r2.random = r1;
        r3.random = r2;
//        r2.random = r4;
//        r3.random = r5;
//        r4.random = r1;
//        r5.random = r2;

        RandomListNode rr1 = new RandomListNode(1);
        RandomListNode rr2 = new RandomListNode(2);
        RandomListNode rr3 = new RandomListNode(3);
        RandomListNode rr4 = new RandomListNode(4);
        RandomListNode rr5 = new RandomListNode(5);

        rr1.next = rr2;
        rr2.next = rr3;
        rr3.next = rr4;
        rr4.next = rr5;

        rr5.random = rr3;
        rr3.random = rr2;

        RandomListNode pTest1 = Clone(rr1);

        RandomListNode pTest = Clone(r1);
    }

    static Map<Integer,RandomListNode> map = new HashMap<>();

//    public static RandomListNode Clone(RandomListNode pHead){
//        if(pHead==null){
//            return null;
//        }
//        //boolean isRepeat = false;
//        RandomListNode pResHead = null;
//        if(!map.containsKey(pHead.label)){
//            pResHead = new RandomListNode(pHead.label);
//            map.put(pResHead.label,pResHead);
//        }else{
//            //isRepeat = true;
//            pResHead = map.get(pHead.label);
//            return pResHead;
//        }
//        if(pHead.next!=null){
//            pResHead.next = Clone(pHead.next);
//        }
//        if(pHead.random!=null){
//            pResHead.random = Clone(pHead.random);
//        }
//        map.put(pResHead.label,pResHead);
//        return pResHead;
//    }

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode preHead = new RandomListNode(0);
        RandomListNode pHead_preHead = new RandomListNode(0);
        pHead_preHead.next = pHead;
        RandomListNode pNewHead = new RandomListNode(pHead.label);
        preHead.next = pNewHead;
        while (pHead.next != null) {
            RandomListNode pTemp = new RandomListNode(pHead.next.label);
            pNewHead.next = pTemp;
            pNewHead = pNewHead.next;
            pHead = pHead.next;
        }
        pNewHead = preHead.next;
        map.put(pNewHead.label, pNewHead);
        while (pNewHead.next != null) {
            map.put(pNewHead.next.label, pNewHead.next);
            pNewHead = pNewHead.next;
        }
        pHead = pHead_preHead.next;
        while (pHead != null) {
            if (pHead.random != null) {
                pNewHead = map.get(pHead.label);
                pNewHead.random = map.get(pHead.random.label);
            }
            pHead = pHead.next;
        }
        return preHead.next;
    }
}
