package How2j_tests.Lambda;


import How2j_tests.Hero;

import java.util.ArrayList;
import java.util.List;

public class Lambda_test {
    public static void main(String[] args){
        List<Hero> heros = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            float a = (float)(Math.random()*1000);
            heros.add(new Hero("new Hero" + i,Math.round(a),(int)(Math.random()*100)));
        }
        HeroChecker c = new HeroChecker() {
            public boolean test(Hero h) {
                return h.hp>100 && h.damage<50;
            }
        };
        System.out.println("初始化英雄");
        System.out.println(heros);
//        System.out.println("使用Lamdba的方式，筛选出 hp>100 && damange<50的英雄");
//        filter(heros,h -> h.hp < 500 && h.damage > 50);

        System.out.println("使用匿名类过滤");
        filter(heros, c);
        System.out.println("使用Lambda表达式");
        filter(heros, h->h.hp>100 && h.damage<50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heros, h -> Lambda_test.testHero(h) );
        System.out.println("直接引用静态方法");
        filter(heros, Lambda_test::testHero);
    }


    public static boolean testHero(Hero h){
        return h.hp > 100 && h.damage < 50;
    }
    private static void filter(List<Hero> heros, HeroChecker checker){
        for(Hero hero: heros){
            if(checker.test(hero))
                System.out.print(hero);
        }
    }
}
