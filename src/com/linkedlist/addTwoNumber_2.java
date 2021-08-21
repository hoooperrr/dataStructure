package com.linkedlist;

import java.util.LinkedHashSet;

public class addTwoNumber_2 {
    public static void main(String[] args) {
        addTwoNumber_2 addTwoNumber = new addTwoNumber_2();


        ListNode head1 = new ListNode(9);
        ListNode head2 = new ListNode(9);
        head1.next = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        head2.next = new ListNode(9, new ListNode(9));
        //        ListNode listNode = new ListNode(2,4);
        ListNode resultHead = addTwoNumber.addTwoNumbers0(head1, head2);
        printLink(resultHead);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultHead;
        ListNode resultTmp;
        ListNode tmp1;
        ListNode tmp2;
        tmp1 = l1;
        tmp2 = l2;
        resultTmp = resultHead = null;
        int carry = 0;
        int val;
        while (tmp1 != null || tmp2 != null) {

            int n1 = tmp1 != null ? tmp1.val : 0;
            int n2 = tmp2 != null ? tmp2.val : 0;

            val = n1 + n2 + carry;
            carry = val / 10;
            val = val % 10;

            if (resultHead == null) {
                resultHead = resultTmp = new ListNode(val);
            } else {
                resultTmp.next = new ListNode(val);
                resultTmp = resultTmp.next;
            }

//            tmp1 = tmp1 != null ? tmp1.next : tmp1;
//            tmp2 = tmp2 != null ? tmp1.next : tmp2;
            if (tmp1 != null) {
                tmp1 = tmp1.next;
            }
            if (tmp2 != null) {
                tmp2 = tmp2.next;
            }
        }
        if (carry != 0) {
            resultTmp.next = new ListNode(carry);
        }
        return resultHead;
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    //Exception in thread "main" java.lang.NullPointerException: Cannot read field "next" because "tmp2" is null
    public static ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode resultHead = new ListNode();
        ListNode tmp1;
        ListNode tmp2;
        ListNode resultTmp;
        tmp1 = l1;
        tmp2 = l2;
        resultTmp = resultHead;
        int carry = 0;
        int val;
        while (tmp1 != null || tmp2 != null) {
            int num1 = tmp1 != null ? tmp1.val : 0;
            int num2 = tmp2 != null ? tmp2.val : 0;
            val = num1 + num2 + carry;
//            carry = (val - (val % 10)) / 10;
            carry = val / 10;
            val = val % 10;

            tmp1 = tmp1 != null ? tmp1.next : tmp1;
            tmp2 = tmp2 != null ? tmp2.next : tmp2;

            resultTmp.val = val;
            if (tmp1.next == null && tmp2.next == null) {//java.lang.NullPointerException
                resultTmp.next = null;
            } else {
                resultTmp.next = new ListNode();
                resultTmp = resultTmp.next;
            }
        }
        if (carry != 0) {
            resultTmp.next = new ListNode(carry);
//            resultTmp.next = null;
        }
        return resultHead;
    }


    public static void printLink(ListNode resultHead) {
        ListNode resultTmp = resultHead;
        while (resultTmp != null) {
            System.out.print(resultTmp.val + " ");
            resultTmp = resultTmp.next;
        }
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
