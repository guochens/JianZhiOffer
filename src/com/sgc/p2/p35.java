package com.sgc.p2;

import java.util.Stack;

public class p35 {
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

        ListNode La = new ListNode(1);
        ListNode Lb = new ListNode(2);
        ListNode Lc = new ListNode(3);
        ListNode Ld = new ListNode(4);
        ListNode Le = new ListNode(5);
        ListNode Lf = new ListNode(1);

        La.next = Lb;
        Lb.next = Lc;
        Lc.next = Ld;
        Ld.next = Le;
        Le.next = Lf;


        System.out.println(FindFirstCommonNode2(La, l1).val);
        System.out.println(FindFirstCommonNode(La, l1).val);
    }

    //链接：https://www.nowcoder.com/questionTerminal/6ab1d9a29e88450685099d45c9e31e46?answerType=1&f=discussion
    //来源：牛客网
    //是ListNode相等而非ListNode.val相等
    public static ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        boolean flag1 = false;
        boolean flag2 = false;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p1==null && !flag1) {
                flag1 = true;
                p1 = pHead2;
            }
            if(p2==null && !flag2){
                flag2 = true;
                p2 = pHead1;
            }
            if(p1==null && flag1){
                return null;
            }
        }

        return p1;

    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null){
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while(pHead1!=null){
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while(pHead2!=null){
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while(stack1.peek().val == stack2.peek().val){
            res = stack1.pop();
            stack2.pop();
            if(stack1.isEmpty() || stack2.isEmpty()){
                break;
            }
        }

        return res;
    }
}
