package How2j_tests.Concurrency_Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger_test {
    public static void main(String[] args){
        AtomicInteger atomicInteger = new AtomicInteger();
        int a1 = 9;
        a1 = atomicInteger.addAndGet(1);
        int a2 = atomicInteger.incrementAndGet();
        System.out.println(a1 + " " +a2);
    }
}
