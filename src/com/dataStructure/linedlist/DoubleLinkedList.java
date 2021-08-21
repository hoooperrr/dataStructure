package com.dataStructure.linedlist;

public class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode) {
        //遍历（不考虑编号 直接加到最后）
        HeroNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = heroNode;
        heroNode.pre = tmp;
    }

    public Boolean isEmpty() {
        return head.next == null;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("isEmpty");
            return;
        }
        HeroNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp);
            tmp = tmp.next;
        }
//        System.out.println(tmp);
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode tmp = head;
        boolean flag = false;

//        while (tmp.next != null) {
//            if (tmp.next.no > heroNode.no) {
//                heroNode.next = tmp.next;
//                tmp.next = heroNode;
//            }
//            tmp=tmp.next;
//        }
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.no > heroNode.no) {
                break;
            } else if (tmp.no == heroNode.no) {
                flag = true; //说明编号存在
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.printf("%d 存在", heroNode.no);
        } else {
//            heroNode.pre=tmp;
//        if(tmp.next!=null)
//            heroNode.next=tmp.next;
//            heroNode.pre=tmp;
//            tmp.next.pre=heroNode;
//            tmp.next=heroNode;

            if (tmp.next != null) {
                tmp.pre.next = heroNode;
                heroNode.pre = tmp.pre;
                heroNode.next = tmp;
                tmp.pre = heroNode;
            } else if (tmp.no > heroNode.no) {
                tmp.pre.next = heroNode;
                heroNode.pre = tmp.pre;
                heroNode.next = tmp;
                tmp.pre = heroNode;
            } else {
                tmp.next = heroNode;
                heroNode.pre = tmp;
            }
        }
    }


    public void update(HeroNode newHeroNode) {
        if (isEmpty()) {
            System.out.println("链表为空~");
            return;
        }
        HeroNode tmp = head;
        boolean flag = false;

        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.no == newHeroNode.no) {
                flag = true; //说明编号存在
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.name = newHeroNode.name;
            tmp.nickname = newHeroNode.nickname;

        } else {
            System.out.printf("%d 不存在", newHeroNode.no);
        }
    }

    public void del(int no) {
        boolean flag = false;
        HeroNode tmp = head.next;
        while (true) {
            if (tmp == null) {
                break;
            }
            if (tmp.no == no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.pre.next = tmp.next;
            if (tmp.next != null) tmp.next.pre = tmp.pre;
        } else {
            System.out.printf("%d 不存在\n", no);
        }
    }

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
//        doubleLinkedList.add(hero2);
//        doubleLinkedList.add(hero3);
//        doubleLinkedList.add(hero4);
        doubleLinkedList.addByOrder(hero2);
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.addByOrder(hero4);
        doubleLinkedList.addByOrder(hero3);
        doubleLinkedList.list();

        // 修改
        HeroNode newHeroNode = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除
        doubleLinkedList.del(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }

}
