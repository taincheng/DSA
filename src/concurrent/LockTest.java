package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author TianCheng
 * @Date 2019/8/21 19:28
 */
public class LockTest {
    Lock lock = new ReentrantLock();
    int a = 0;

    public void write(){
        lock.lock();
        try {
            a++;
        } finally {
            lock.unlock();
        }
    }

    public void read(){
        lock.lock();
        int i;
        try {
            i = a;
            System.out.println(i);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args){
        final LockTest lockTest = new LockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.write();
                lockTest.read();
            }
        }).start();
    }
}
