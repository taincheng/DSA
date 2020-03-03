package How2j_tests.Concurrency_Thread._练习生产者消费者wenti;

public class Consumer extends Thread{
    private MyStack<Character> myStack;
    public Consumer(MyStack<Character> myStack, String name){
        super(name);
        this.myStack = myStack;
    }
    public void run(){
        while (true){
            char c = myStack.pull();
            System.out.println(this.getName() + " 消费 :" + c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
