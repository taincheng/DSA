package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author TianCheng
 * @Date 2019/9/13 10:11
 */
public class Juc_ticks {
    public static void main(String[] args){
        Ticks ticks = new Ticks();

        /**
         * java8 lam 表达式实现匿名内部类
         */

        new Thread( () -> {for(int i = 0; i < 40; i++) {ticks.saleTick();}},"AA").start();
        new Thread( () -> {for(int i = 0; i < 40; i++) {ticks.saleTick();}},"BB").start();
        new Thread( () -> {for(int i = 0; i < 40; i++) {ticks.saleTick();}},"CC").start();

        /**
         * java7实现Runnable内部类
         */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++){
//                    ticks.saleTick();
//                }
//            }
//        },"B").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++){
//                    ticks.saleTick();
//                }
//            }
//        },"C").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 40; i++){
//                    ticks.saleTick();
//                }
//            }
//        },"A").start();
    }
}

