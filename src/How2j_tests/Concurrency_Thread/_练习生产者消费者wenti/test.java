package How2j_tests.Concurrency_Thread._练习生产者消费者wenti;

public class test {
    public static void main(String[] args){
        MyStack<Character> myStack = new MyStack<>();
        new Producer(myStack,"pro1").start();
        new Producer(myStack,"pro2").start();
        new Consumer(myStack, "Con1").start();
        new Consumer(myStack, "Con2").start();
        new Consumer(myStack, "Con3").start();
    }
}
