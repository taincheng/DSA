package How2j_tests.Concurrency_Thread._线程池同步查找文件;

import java.io.File;

public class TestThread {
    static ThreadPool pool= new ThreadPool();
    public static void search(File file, String search) {

        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                SearchFileTash task = new SearchFileTash(file, search);
                pool.add(task);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    public static void main(String[] args) {
        File folder =new File("e:\\project");
        search(folder,"Magic");
    }
}
