package How2j_tests.Concurrency_Thread._线程池同步查找文件;

import java.io.File;
import java.io.FileReader;

public class SearchFileTash implements Runnable{

    private File file;
    private String searchString;

    public SearchFileTash(File file,String searchString){
        this.file = file;
        this.searchString = searchString;
    }
    @Override
    public void run() {
        String content = readFileContent(file);
        if(content.contains(searchString)){
            System.out.printf("线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(),searchString,file);
        }
    }

    public static String readFileContent(File file){
        try (FileReader fileReader = new FileReader(file)){
            char[] chars = new char[(int)file.length()];
            fileReader.read(chars);
            return new String(chars);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
