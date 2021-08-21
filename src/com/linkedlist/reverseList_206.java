package com.linkedlist;

public class reverseList_206 {
    //1.在遍历链表时，将当前节点的 \textit{next}next 指针改为指向前一个节点。
    // 由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
    // 在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //2.递归版本稍微复杂一些，其关键在于反向工作。假设链表的其余部分已经被反转，现在应该如何反转它前面的部分？
    public static ListNode reverseList2(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode last = reverseList2(head.next);//假设以头节点后一个节点开头的链表已经反转好了，返回反转后的头结点
        head.next.next=head;
        head.next=null;
        return last;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode newHead = new ListNode(0, null);
        ListNode tempNew;
        ListNode tempLast;
        while (temp != null) {
            tempNew = newHead.next;
            tempLast = temp.next;
            newHead.next = temp;
            temp.next = tempNew;
            temp = tempLast;
        }
        return newHead.next;
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
        head = new ListNode(9, new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(5)))));
        ListNode reverseHead = reverseList2(head);
        printLink(reverseHead);
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
