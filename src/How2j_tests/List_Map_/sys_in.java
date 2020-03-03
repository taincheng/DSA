package How2j_tests.List_Map_;

import How2j_tests.Hero;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class sys_in {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<Hero>();

        // 放100个Hero进入容器
        for (int i = 0; i < 100; i++) {
            heros.add(new Hero("hero name " + i));
        }

        //准备一个容器，专门用来装要删除的对象
        List<Hero> deletingHeros = new ArrayList<>();

        for (Hero h : heros) {
            int id = Integer.parseInt(h.name.substring(10));
            if (0 == id % 8)
                deletingHeros.add(h);
        }
        for (Hero h : deletingHeros) {
            heros.remove(h);
        }
//      heros.removeAll(deletingHeros); //直接通过removeAll删除多个Hero对象
        for(Hero h : heros){
            System.out.println(h.getName());
        }
    }
}
