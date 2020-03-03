package concurrent;


import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author TianCheng
 * @Date 2019/9/15 20:49
 */
public class ThreadPool {

    private void testExecutors() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> future = null;
        try {
            for (int i = 0; i < 10; i++) {
                future = service.submit( () -> {
                    System.out.print(Thread.currentThread().getName());
                    return new Random().nextInt(50);
                });
                System.out.println("***"+future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

    public static void main(String[] args){
        ThreadPool threadPool = new ThreadPool();
        threadPool.testExecutors();
    }
}
