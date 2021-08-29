package com.points;

import java.util.List;

public class detectCycle_142_JZ22 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        if (head == null) return null;

        while (p2 != null) {
            p1 = p1.next;
            if (p2.next != null) {
                p2 = p2.next.next;
            } else {
                return null;
            }
            if (p2==p1) {
                ListNode tmp = head;
                while (tmp != p1) {//?????????
                    tmp = tmp.next;
                    p1 = p1.next;
                }
                return tmp;
            }
        }
        return null;
    }
}
