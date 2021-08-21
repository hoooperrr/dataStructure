package com.dataStructure.linedlist;

public class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode(int no, String name, String nickname) {
        this.name = name;
        this.no = no;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +

                '}';
    }
}
