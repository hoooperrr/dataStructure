package com.dataStructure.linedlist;

import java.util.Stack;

public class UseSingleLinkedList {

    public static int getLength(HeroNode head) {
        HeroNode tmp = head;
        int length = 0;
        if (head.next == null) {
            return 0;//空链表，不能打印
        }
        while (true) {
            if (tmp.next == null) break;
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int length = UseSingleLinkedList.getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }
        HeroNode tmp = head;
        for (int i = 0; i < length - index; i++) {
            tmp = tmp.next;
        }
        return tmp.next;
    }

    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode tmp = head.next;
        HeroNode next = null;

        while (true){
            if(tmp==null){
                break;
            }
            next=tmp.next;
            tmp.next=reverseHead.next;
            reverseHead.next=tmp;
//            head.next=next;
            tmp=next;
        }
        head.next=reverseHead.next;
    }

    public static void reversePrintList(HeroNode head){
        if (head.next == null || head.next.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode tmp=head.next;
        while (tmp!=null){
            stack.push(tmp);
            tmp=tmp.next;
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }
}
