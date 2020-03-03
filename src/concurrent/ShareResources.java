package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author TianCheng
 * @Date 2019/9/15 19:43
 */
public class ShareResources {
    private int flag = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    private void print5(int total){
        lock.lock();
        try{
            while (flag != 1){
                condition1.await();
            }
            flag = 2;
            for (int i = 1; i <= 5; i++){
                System.out.println(Thread.currentThread().getName() + " 输出： " + i + "  " + total);
            }
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print10(int total){
        lock.lock();
        try{
            while (flag != 2){
                condition2.await();
            }
            flag = 3;
            for (int i = 1; i <= 10; i++){
                System.out.println(Thread.currentThread().getName() + " 输出： " + i + "  " + total);
            }
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print15(int total){
        lock.lock();
        try{
            while (flag != 3){
                condition3.await();
            }
            flag = 1;
            for (int i = 1; i <= 15; i++){
                System.out.println(Thread.currentThread().getName() + " 输出： " + i + "  " + total);
            }
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        ShareResources shareResources = new ShareResources();
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                shareResources.print5(i);
            }
        },"AA").start();
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                shareResources.print10(i);
            }
        },"BB").start();
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                shareResources.print15(i);
            }
        },"CC").start();
    }
}
