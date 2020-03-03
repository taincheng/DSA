package How2j_tests.List_Map_;

import How2j_tests.Hero;

import java.util.LinkedList;

public class Mystack implements Stack{

    LinkedList<Hero> linkedList = new LinkedList<>();

    @Override
    public void push(Hero h) {
        linkedList.addLast(h);
    }

    @Override
    public Hero pull() {
        return linkedList.removeLast();
    }

    @Override
    public Hero peek() {
        return linkedList.getLast();
    }

    public static void main(String[] args){
        Mystack ms = new Mystack();

        for(int i = 0; i < 5; i++){
            Hero h = new Hero("英雄" + i);
            System.out.println("新英雄"+h.getName()+"入栈");
            ms.push(h);
        }
        System.out.println("-------------");
        for(int i = 0; i < 5; i++){
            System.out.println("英雄"+ms.peek().getName()+"出栈");
            ms.pull();
        }
    }
}
interface Stack{
    //把英雄放进栈
    public void push(Hero h);
    //把最后一个英雄拿出来
    public Hero pull();
    //查看最后一个英雄
    public Hero peek();
}
