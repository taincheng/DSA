package java_test;


public class MyDog extends Dog{
    public MyDog(String name, int weight) {
        super(name,weight);
    }

    public static void main(String[] args){
        MyDog mydog = new MyDog("mydog",50);
        MyDog yourdog = new MyDog("yourdog",50);

        System.out.println("start Fight");
        while(true){
            System.out.println(mydog.name + " : " + mydog.weight);
            System.out.println(yourdog.name + " : " + yourdog.weight);
            System.out.println("--------------------------------------------");
            if(mydog.weight <= 0){
                System.out.println(yourdog.name + " 把 "+mydog.name + " 打死了");
                break;
            }

            if(yourdog.weight <= 0){
                System.out.println(mydog.name + " 把 "+yourdog.name + " 打死了");
                break;
            }

            int i = (int)(Math.random() * 10);
            int j = (int)(Math.random() * 10);
            if( i >= 5 && j >= 5){
                mydog.fighting(yourdog);
            }else if(i >= 5 && j < 5){
                mydog.fighting(yourdog,5);
            }else if(i < 5 && j >= 5){
                yourdog.fighting(mydog);
            }else{
                yourdog.fighting(mydog,5);
            }
        }
    }

    public void fighting(Dog dog){
        if(dog.weight >= 10){
            dog.weight -= 10;
        }else{
            dog.weight = 0;
        }
    }

    public void fighting(Dog dog, int bool){
        if(dog.weight >= bool){
            dog.weight -= bool;
        }else{
            dog.weight = 0;
        }
    }
}

class Dog{
    int weight;
    String name;
    public Dog(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    public void fighting(Dog dog){

    }

}
