package How2j_tests.Concurrency_Thread._练习生产者消费者wenti;

import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> linkedList = new LinkedList<>();

    public synchronized void push(T t){
        while(linkedList.size() >= 200){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        linkedList.addLast(t);
        this.notifyAll();
    }

    public synchronized T pull(){
        while(linkedList.size() <= 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return linkedList.removeLast();
    }

    public T peek(){
        return linkedList.getLast();
    }
}
