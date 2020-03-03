package How2j_tests.Lambda;

import How2j_tests.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCollection {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero h = new Hero();
            h.setName("new hero" + i);
            h.setHp(Math.round((float) Math.random() * 100));
            heros.add(h);
        }
        System.out.println("初始化后的集合");
        //System.out.println(heros);
        heros.stream().forEach(h -> System.out.println(h.name + " " +h.hp));
        //匿名类比较器
        Comparator<Hero> C = new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o1.hp > o2.hp ? 1 : -1;
            }
        };
        //Lambda表达式
        C = (Hero o1,Hero o2)->{
            return o1.hp > o2.hp ? 1 : -1;
        };
        //去掉 return和大括号
        C = (Hero o1,Hero o2)-> o1.hp > o2.hp ? 1 : -1;

        //去掉 参数类型
        C = (o1, o2) -> o1.hp > o2.hp ? 1 : -1;

        //有两个参数，无法去掉圆括号
        Collections.sort(heros,C);

        //直接把Lambda表达式作为参数传进去
        System.out.println("直接把Lambda表达式作为参数传进去");
        Collections.sort(heros,((o1, o2) -> o1.hp > o2.hp ? 1 : -1));
        heros.stream().forEach(h -> System.out.println(h.name + " " +h.hp));
//        System.out.println("直接使用静态方法");
//        Collections.sort(heros,TestCollection::compare);
//        System.out.println(heros);
    }
        public static int compare(Hero h1,Hero h2){
            return h1.hp > h2.hp ? 1 : -1;
        }

}
