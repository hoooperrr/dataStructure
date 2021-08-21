package com.dataStructure.linedlist;

public class SingleLinkedList {
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
            if (tmp.next.no > heroNode.no) {
                break;
            } else if (tmp.next.no == heroNode.no) {
                flag = true; //说明编号存在
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            System.out.printf("%d 存在", heroNode.no);
        } else {
            heroNode.next = tmp.next;
            tmp.next = heroNode;
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
        HeroNode tmp = head;
        while (true) {
            if (tmp.next == null) {
                break;
            }
            if (tmp.next.no == no) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag) {
            tmp.next = tmp.next.next;
        } else {
            System.out.printf("%d 不存在\n", no);
        }
    }

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero3);

        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);


        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();

        singleLinkedList.del(3);
        singleLinkedList.list();

        UseSingleLinkedList use = new UseSingleLinkedList();
        int length = use.getLength(singleLinkedList.getHead());
        singleLinkedList.addByOrder(hero3);
        System.out.println("长度" + length);

        HeroNode lastIndexNode = UseSingleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println(lastIndexNode);


		System.out.println("原来单链表~~");
        singleLinkedList.list();
        System.out.println("反转单链表~~");
        UseSingleLinkedList.reverseList(singleLinkedList.getHead());
//		reversetList(singleLinkedList.getHead());
		singleLinkedList.list();


        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        UseSingleLinkedList.reversePrintList(singleLinkedList.getHead());

/*

		//测试修改节点的代码


		System.out.println("修改后的链表情况~~");
		singleLinkedList.list();

		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();

		//测试一下 求单链表中有效节点的个数
		System.out.println("有效的节点个数=" + getLength(singleLinkedList.getHead()));//2

		//测试一下看看是否得到了倒数第K个节点
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 3);
		System.out.println("res=" + res);
*/

    }
}
