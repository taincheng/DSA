package How2j_tests.Lambda;

/**
 * @Author TianCheng
 * @Date 2019/9/3 14:19
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java 8 内置的四大核心函数式接口
 *
 * Consummer ： 消费者接口
 *      void accept(T t)
 *
 * Supplier<T>: 供给接口
 *      T get()
 *
 * Function<T,R> : 函数式接口
 *      R apply(T t)
 *
 * Predicate<T> : 断言型接口
 *      boolean test(T t)
 */
public class testJavaLambada {
    //Consumer<T> 消费型接口：
    @Test
    public void test1(){
        happy(10000, (x) -> System.out.println("happy" + x + "元"));
    }
    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    //Supplier<T> 供给型接口
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for(Integer num : numList){
            System.out.print(num + " ");
        }
    }
    //产生一些整数，并放入集合
    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i ++){
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

    //Function<T, R> 函数型接口
    @Test
    public void test3(){
        String s = stringHander("啦啦啦，哈哈哈，嘿嘿嘿", (str) -> str.substring(4, 7));
        System.out.println(s);
    }

    //需求： 处理字符串
    public String stringHander(String s, Function<String, String> function){
        return function.apply(s);
    }

    //Predicate<T> 断言式
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","adfjsd","sdds","dfafd111");
        List<String> strings = filterString(list, (str) -> str.length() > 5);
        for (String s :
                strings) {
            System.out.print(s + " ");
        }
    }

    public List<String> filterString(List<String> list, Predicate<String> predicate){
        List<String> list1 = new ArrayList<>();
        for(String str : list){
            if(predicate.test(str)){
                list1.add(str);
            }
        }
        return list1;
    }

    /**
     *
     * 方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”
     *
     * 三种语法格式
     * 对象::实例方法名
     * 类::静态方法名
     * 类::实例方法名
     *
     */
    @Test
    public void testMethed1(){
        Consumer<String> consumer = System.out::println;
        consumer.accept("引用实例方法名");
    }

}
