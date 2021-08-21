package com.linkedlist;


public class reverseKGroup_25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode end;
        ListNode curr = newHead;

        while (curr.next != null) {
            ListNode start = pre.next;
            for (int step = k; step > 0 && curr != null; step--) {
                curr = curr.next;
            }
            if (curr == null) break;

            end = curr;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
//            pre.next = end;
            start.next = next;//反转后！！
            pre = start;//
            curr = pre;
        }
        return newHead.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode curr = head;
//        ListNode newHead = new ListNode(0, null);
        ListNode pre = null;
        while (curr != null) {
            ListNode tmp = curr.next;
//            newHead.next = curr;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseList(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }


    public static ListNode[] reverseList1(ListNode head, ListNode tail) {
        ListNode curr = head;
//        ListNode newHead = new ListNode(0, null);
        ListNode pre = tail.next;

        while (curr != tail.next) {
//            prev != tail
//            curr != tail.next
            ListNode tmp = curr.next;
//            newHead.next = curr;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return new ListNode[]{tail, head};
    }


    public static void printLink(ListNode resultHead) {
        ListNode resultTmp = resultHead;
        while (resultTmp != null) {
            System.out.print(resultTmp.val + " ");
            resultTmp = resultTmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9, new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(5, new ListNode(4))))));
//        ListNode listNodes = reverseList(head1.next);
        printLink(reverseKGroup(head, 2));
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
