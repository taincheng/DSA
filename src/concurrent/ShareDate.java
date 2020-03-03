package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author TianCheng
 * @Date 2019/9/13 11:17
 */
public class ShareDate {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    //lock 的一系列等待和唤醒方法
    private Condition condition = lock.newCondition();

    public void increment() throws Exception{
        lock.lock();
        try{
            while (number != 0){
                condition.await();
            }
            ++ number;
            System.out.println(Thread.currentThread().getName() + " number : " + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void decrement() throws Exception{
        lock.lock();
        try{
            while (number == 0){
                condition.await();
            }
            -- number;
            System.out.println(Thread.currentThread().getName() + " number : " + number);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
//    public synchronized void increment() throws InterruptedException {
//        while (number != 0){
//            this.wait();
//        }
//        ++ number;
//        System.out.println(Thread.currentThread().getName() + " number : " + number);
//        this.notifyAll();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        //使用while判断，if会造成虚假唤醒
//        while (number == 0){
//            this.wait();
//        }
//        -- number;
//        System.out.println(Thread.currentThread().getName() + " number : " + number);
//        this.notifyAll();
//    }

    public static void main(String[] args){
        ShareDate shareDate = new ShareDate();
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(100);
                    shareDate.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"AA").start();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(200);
                    shareDate.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"BB").start();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(300);
                    shareDate.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"CC").start();

        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                try {
                    Thread.sleep(400);
                    shareDate.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        },"DD").start();
    }
}
