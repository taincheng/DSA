package How2j_tests.List_Map_;

import How2j_tests.Hero;

import java.util.LinkedList;

public class Linkedlist_test {

    public static void main(String[] args){
        LinkedList<Hero> LL = new LinkedList<>();

        //添加
        LL.add(new Hero("奥特曼1"));

        //在双向链表最前添加
        LL.addFirst(new Hero("奥特曼-1"));

        //在最后添加
        LL.addLast(new Hero("奥特曼2"));

        System.out.println("查看所有的元素:");
        for(Hero L : LL){
            System.out.println("    " + L.getName());
        }

        //查看最前的元素
        System.out.println("查看最前的元素:" + LL.getFirst().getName());
        //查看最后的元素
        System.out.println("查看最后的元素:" + LL.getLast().getName());

        //取出最前的元素
        System.out.println("取出最前的元素:" + LL.removeFirst().getName());
        //取出最后的元素
        System.out.println("取出最后的元素:" + LL.removeLast().getName());

        System.out.println("查看所有的元素:");
        for(Hero L : LL){
            System.out.println("    " + L.getName());
        }
    }
}

