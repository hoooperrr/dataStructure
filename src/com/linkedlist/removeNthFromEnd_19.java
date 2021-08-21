package com.linkedlist;

public class removeNthFromEnd_19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        int length = 0;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        // System.out.println(length);
        ListNode temp1 = new ListNode(0, head);
        ListNode temp2 = temp1;
        for (int i = 0; i < length - n; i++) {
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return temp1.next;
    }

    public static void printLink(ListNode resultHead) {
        ListNode resultTmp = resultHead;
        while (resultTmp != null) {
            System.out.print(resultTmp.val + " ");
            resultTmp = resultTmp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = new ListNode(4);
        ListNode listNode = new removeNthFromEnd_19().removeNthFromEnd(head, 1);
        printLink(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
