package com.lk.linkedlist;

import org.junit.Test;

/**
 * @author lkk
 * @created 2020-09-27 15:27
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singlyLinkedList = new SingleLinkedList();

        //加入
        //singlyLinkedList.add(hero1);
        //singlyLinkedList.add(hero2);
        //singlyLinkedList.add(hero3);
        //singlyLinkedList.add(hero4);
        System.out.println("加入插入顺序====================");
        singlyLinkedList.addByNo(hero1);
        singlyLinkedList.addByNo(hero4);
        singlyLinkedList.addByNo(hero2);
        singlyLinkedList.addByNo(hero3);

        singlyLinkedList.list();

        HeroNode hero = new HeroNode(2, "小卢", "玉麒麟");
        singlyLinkedList.update(hero);
        //删除一个节点
        singlyLinkedList.delete(1);
        singlyLinkedList.delete(2);

        //显示
        singlyLinkedList.list();

    }

}

//定义一个Singly linked list 管理我们的英雄
class SingleLinkedList {
    //初始化一个头结点 不要动头结点
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //找到链表尾部 将尾部节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //新建一个辅助指针
        HeroNode temp = head;
        //遍历链表 找到最后的节点
        while (true) {
            //找到最后
            if (temp.next == null) {
                break;
            }
            //没有找到就后移指针
            temp = temp.next;
        }
        //退出循环 temp 指向最后
        //将最后的节点的next指向新的节点
        temp.next = heroNode;
    }

    //第二种添加英雄的方式 如果有 则添加失败
    public void addByNo(HeroNode heroNode) {
        //辅助指针 来找到添加的位置
        //找到的temp 位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false; //添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            //查找位置
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {//说明编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移遍历
        }
        //判断flag的值
        if (flag) {
            System.out.printf("要插入的英雄%s已经存在\n", heroNode.name);
        } else {
            //插入到链表
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点信息
    public void update(HeroNode heroNode) {
    if (head.next == null) {
        System.out.println("空链表");
        return;
    }
    //找到需要修改的节点
    HeroNode temp = head.next;
    boolean flag = false;
    while (true) {
        if (temp == null) {
            break;
        }
        if (temp.no == heroNode.no) {
            flag = true; //表示找到要修改的节点
            break;
        }
        temp = temp.next;
    }
    //根据flag 修改
    //找到要修改的节点
    if (flag) {
        temp.name = heroNode.name;
        temp.nickname = heroNode.nickname;
    } else { //未找到

        System.out.printf("没有找到编号%d的节点", heroNode.no);
    }
}

    //删除节点
    //temp.next.no  HeroNode.next
    public void delete(Integer no){
        HeroNode temp=head;
        boolean flag =false; //是否找到待删除节点
        while (true){
            if (temp.next==null){
                break;
            }else if (temp.next.no == no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            //System.out.println("没有找到要删除的节点");
            throw new RuntimeException("NodeNotFoundException") ;
        }
    }

    //显示链表 遍历
    public void list(){
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("空链表");
            return;
        }
        //辅助指针来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到了链表的最后
            if (temp == null) {
                break;
            } else {
                //输出节点的信息
                System.out.println(temp);
                //后移temp
                temp = temp.next;
            }
        }

    }

}


    //定义一个HeroNode
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    //构造器

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    //为了显示方便 重写toString()

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}



