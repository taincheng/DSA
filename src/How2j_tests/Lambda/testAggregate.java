package How2j_tests.Lambda;

import How2j_tests.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 对元素进行筛选：
 * filter 匹配
 * distinct 去除重复(根据equals判断)
 * sorted 自然排序
 * sorted(Comparator<T>) 指定排序
 * limit 保留
 * skip 忽略
 * 转换为其他形式的流
 * mapToDouble 转换为double的流
 * map 转换为任意类型的流
 */
public class testAggregate {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heros = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        //制造一个重复数据
        heros.add(heros.get(0));
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);


        //filter 匹配
        System.out.println("满足条件hp>100&&damage<50的数据");
        heros.stream().filter(h -> (h.hp > 100 && h.damage < 50))
                .forEach(h -> System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));

        //distinct 去除重复(根据equals判断)
        System.out.println("distinct 去除重复(根据equals判断)");
        heros.stream().distinct().forEach(h -> System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));
        //sorted 自然排序
        System.out.println("sorted 自然排序");
        heros.stream().sorted().forEach(h -> System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));
        //sorted(Comparator<T>) 指定排序
        System.out.println("sorted(Comparator<T>) 指定排序");
        heros.stream().sorted((h1,h2)-> (h1.hp > h2.hp ? 1 : -1))
                .forEach(h -> System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));
        //limit 保留
        System.out.println("limit 保留");
        heros.stream().limit(3).forEach(h->System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));
        //kip 忽略
        System.out.println("kip 忽略");
        heros.stream().skip(3).forEach(h->System.out.println(h.name +"  "+ h.hp +"  "+ h.damage ));

        //mapToDouble 转换为double的流
        System.out.println("mapToDouble 转换为double的流");
        heros.stream().mapToDouble(Hero::getHp).forEach(h->System.out.println(h));
        //map 转换为任意类型的流
        System.out.println("map 转换为任意类型的流");
        heros.stream().map((h) -> h.name + " - " + h.hp + " - " + h.damage).forEach(h->System.out.println(h));
    }


}
