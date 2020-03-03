package How2j_tests._反射机制;

import How2j_tests.Hero;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class _反射创建对象 {
    @SuppressWarnings({"rawtypes"})
    public static void main(String[] args){
        String name = "How2j_tests.Hero";
        String name_s = null;

        //泛型提示被注解（抑制警告）解除
        LinkedList linkedList = new LinkedList();
        File f = new File("E:/Idea_project/src/How2j_tests/_反射机制/hero.config");

        try(FileReader fr = new FileReader(f)) {
            char[] cf = new char[(int)f.length()];
            fr.read(cf);
            name_s = new String(cf);
            //获得类对象
            Class c1 = Class.forName(name_s);
            //得到构造器
            Constructor C = c1.getConstructor();
            //得到对象
            Hero h = (Hero)C.newInstance();

            h.hp = 5;
            System.out.println(h.hp);

            Method method = h.getClass().getMethod("setName",String.class);
            method.invoke(h,"盖伦");
            Method method1 = h.getClass().getMethod("getName");
            System.out.println(method1.invoke(h));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
