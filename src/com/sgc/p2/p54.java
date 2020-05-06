package com.sgc.p2;

import java.util.HashSet;
import java.util.Set;
//链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4?answerType=1&f=discussion
//来源：牛客网
//
//题我们可以采用双指针解法，一快一慢指针。快指针每次跑两个element，慢指针每次跑一个。如果存在一个圈，总有一天，快指针是能追上慢指针的。
//如下图所示，我们先找到快慢指针相遇的点，p。我们再假设，环的入口在点q，从头节点到点q距离为A，q p两点间距离为B，p q两点间距离为C。
//因为快指针是慢指针的两倍速，且他们在p点相遇，则我们可以得到等式 2(A+B) = A+B+C+B.
//由3的等式，我们可得，C = A。
//这时，因为我们的slow指针已经在p，我们可以新建一个另外的指针，slow2，让他从头节点开始走，每次只走下一个，原slow指针继续保持原来的走法，和slow2同样，每次只走下一个。
//我们期待着slow2和原slow指针的相遇，因为我们知道A=C，所以当他们相遇的点，一定是q了。
//我们返回slow2或者slow任意一个节点即可，因为此刻他们指向的是同一个节点，即环的起始点，q。
public class p54 {
    public static void main(String[] args) {

    }

    public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        if(pHead==null||pHead.next==null)return null;
        ListNode p1=pHead;
        ListNode p2=pHead;
        while(p2!=null&&p2.next!=null)
        {
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2)
            {
                p1=pHead;
                while(p1!=p2)
                {
                    p1=p1.next;
                    p2=p2.next;
                }
                if(p1==p2)return p1;
            }
        }
        return null;
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead){
        Set<ListNode> set = new HashSet<>();
        if(pHead==null){
            return null;
        }
        while (pHead!=null){
            if(set.contains(pHead)){
                return pHead;
            }else{
                set.add(pHead);
            }
            pHead = pHead.next;
        }
        return null;
    }
}
