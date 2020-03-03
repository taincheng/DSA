package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author TianCheng
 * @Date 2019/9/13 10:46
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> {
            System.out.println("come in here...");
            return 200;
        });
        new Thread(futureTask,"AA").start();
        System.out.println(".......callable : " + futureTask.get());
    }
}

class MyThreads implements Callable<Integer>{
    Ticks ticks = new Ticks();
    @Override
    public Integer call() throws Exception {
        System.out.println("come in here.....");
        return 200;
    }
}
