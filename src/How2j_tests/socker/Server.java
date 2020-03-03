package How2j_tests.socker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        try {
            //服务器打开8888端口
            ServerSocket ss = new ServerSocket(8888);
            //在8888端口上监听，看是否有连接请求过来
            System.out.println("监听在端口号:8888");
            Socket s = ss.accept();

            InputStream in = s.getInputStream();
            DataInputStream Din = new DataInputStream(in);
            OutputStream os = s.getOutputStream();
            DataOutputStream Dout = new DataOutputStream(os);

            while(true){
                String string  = Din.readUTF();
                System.out.println("收到client ：" + string);

                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                Dout.writeUTF(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
