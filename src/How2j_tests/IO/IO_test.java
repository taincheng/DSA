package How2j_tests.IO;

import java.io.*;

public class IO_test {
    public static void main(String[] args){
        write();
        read();
    }
    public static void read(){//E:\Idea_project\src\How2j_tests\IO_test.java
        File f = new File("./src/How2j_tests/IOdata.txt");
        try(DataInputStream ds = new DataInputStream(new FileInputStream(f))){
            int x = ds.readInt();
            boolean y = ds.readBoolean();
            System.out.println(x);
            System.out.println(y);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void write(){
        File f = new File("./src/How2j_tests/IOdata.txt");
        try(DataOutputStream os = new DataOutputStream(new FileOutputStream(f))){
            os.writeInt(5);
            os.writeBoolean(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
