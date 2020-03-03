package How2j_tests;

public class Hero implements Comparable<Hero> {
    public String name;
    public float hp;
    public int damage;

    static String copyright;

    public Hero() {
    }

    static {
        System.out.println("初始化类对象静态属性");
        copyright = "hahaha";
    }
    public Hero(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getHp() {
        return hp;
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if (damage < anotherHero.damage)
            return 1;
        else
            return -1;
    }

    //初始化name,hp,damage的构造方法
    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
//    public String toString(){
//        return "("+name+", hp = "+hp+")\r\n";
//    }

    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

    //回血
    public synchronized void recover() {
        while (hp >= 1000) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp + 1;
        System.out.println(this.name + "回复1点hp   还有" + this.hp );
        this.notify();
    }

    //受伤
    public synchronized void hurt() {
        while (hp <= 1) {
            try {
                //只剩一点血，暂停
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hp = hp - 1;
        System.out.println(this.name + "掉一点hp    还有" + this.hp);
        this.notify();
    }
}
