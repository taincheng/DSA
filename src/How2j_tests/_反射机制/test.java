package How2j_tests._反射机制;

import How2j_tests.Hero;

public class test {
    public static void main(String[] args){
        String name = "How2j_tests.Hero";

        try {
            Class c1 = Class.forName(name);
            //Class c2 = Hero.class;//不会初始化类对象静态属性
            //Class c3 = new Hero().getClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
