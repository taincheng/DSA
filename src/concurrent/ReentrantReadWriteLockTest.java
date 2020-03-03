package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author TianCheng
 * @Date 2019/9/15 20:12
 */
public class ReentrantReadWriteLockTest {
    private Object obj;
    private ReentrantReadWriteLock RWLock = new ReentrantReadWriteLock();

    private void write(Object o){
        RWLock.writeLock().lock();
        try {
            obj = o;
            System.out.println(Thread.currentThread().getName() + " write is : " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RWLock.writeLock().unlock();
        }
    }

    private void read(){
        RWLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            RWLock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockTest readWriteLockTest = new ReentrantReadWriteLockTest();
        new Thread( () -> {
            readWriteLockTest.write("class 2");
        },"aa").start();

        Thread.sleep(4);
        new Thread( () -> {
            for(int i = 0; i < 100; i++){
                readWriteLockTest.read();
            }
        },"read").start();
    }
}
