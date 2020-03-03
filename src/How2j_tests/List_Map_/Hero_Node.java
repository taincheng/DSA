package How2j_tests.List_Map_;

import How2j_tests.Hero;

import java.util.ArrayList;
import java.util.List;

public class Hero_Node {
    public Hero_Node LeftNode;
    public Hero_Node RightNode;
    public Hero HeroHp;

    public void add(Hero Hp){
        if(HeroHp == null){
            HeroHp = Hp;
        }else{
            if(Hp.hp >= HeroHp.hp){
                if(LeftNode == null)
                    LeftNode = new Hero_Node();
                LeftNode.add(Hp);
            }else{
                if(RightNode == null)
                    RightNode = new Hero_Node();
                RightNode.add(Hp);
            }
        }
    }

    /*
    中序排序
     */
    public List<Object> inorder_traversal(){
        List<Object> list = new ArrayList<>();

        //左边节点
        if(LeftNode != null){
            list.addAll(LeftNode.inorder_traversal());
        }
        //当前节点
        list.add(HeroHp);
        //右边节点
        if(RightNode != null){
            list.addAll(RightNode.inorder_traversal());
        }

        return list;
    }

    public static void main(String[] args){
        List<Hero> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Hero h = new Hero();
            h.setName("英雄" + i);
            h.setHp((float)(Math.random()*900 + 100));
            list.add(h);
        }
        System.out.println("初始化英雄");
        System.out.println(list);
        Hero_Node tree = new Hero_Node();
        for(Hero h : list){
            tree.add(h);
        }
        System.out.println("根据血量倒序");
        List<Object> treeSortedHeros = tree.inorder_traversal();
        System.out.println(treeSortedHeros);
    }
}
