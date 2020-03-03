package How2j_tests.Concurrency_Thread._练习生产者消费者wenti;

import How2j_tests.Hero;

/**
 * 生产随机大写字符压入到堆栈
 */
public class Producer extends Thread{
    private MyStack<Character> myStack;
    public Producer(MyStack<Character> myStack, String name){
        super(name);
        this.myStack = myStack;
    }

    public void run() {
        while (true) {
            char c = randomChar();
            System.out.println(this.getName() + " 生产 :" + c);
            myStack.push(c);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public char randomChar(){
        return (char)(Math.random()*('Z' - 'A' + 1) + 'A');
    }
}
