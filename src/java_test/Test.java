package java_test;

/*父类*/
class Base {
    private String showMe()//私有-子类新增
    //public String showMe()  //重载
    {
        return "Base";
    }

    public void print() {
        System.out.println(this.showMe());
    }
}

/*子类*/
class Sub extends Base {
    public String showMe() {
        System.out.println("Sub");
        return "Sub";
    }
}

/*测试继承*/
public class Test {
    public static void main(String[] args) {
        //Base base = new Sub();
        Sub base = new Sub();
        //base.showMe();
        base.print();
    }
}

