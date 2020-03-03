package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author TianCheng
 * @Date 2019/9/13 10:45
 */
class Ticks{
    private int tick = 30;
    private Lock lock = new ReentrantLock();

    public void saleTick(){
        lock.lock();
        try {
            if(tick > 0){
                System.out.println(Thread.currentThread().getName() + "\t卖出了第("+ tick-- +") 票，还剩: " + tick);
            }
        } finally {
            lock.unlock();
        }
    }

    public int getTick() {
        return tick;
    }
}
