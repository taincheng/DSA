package How2j_tests.Concurrency_Thread;

import How2j_tests.Hero;

/**
 * 使用wait和notify进行线程交互
 */
public class jiaohu {
    public static void main(String[] args) {

        final Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread() {
                public void run() {
                    while (true) {
                        gareen.hurt();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            };
            t1.start();
        }

        for (int j = 0; j < 2; j++) {
            Thread t2 = new Thread() {
                public void run() {
                    while (true) {
                        gareen.recover();
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                }
            };
            t2.start();
        }

    }
}
