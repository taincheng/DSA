package How2j_tests.socker;

import java.io.*;
import java.net.Socket;
public class Client {
    public static void main(String[] args){
        try {
            Socket s = new Socket("127.0.0.1",8888);

            OutputStream out = s.getOutputStream();
            DataOutputStream Dout = new DataOutputStream(out);
            InputStream in = s.getInputStream();
            DataInputStream Din = new DataInputStream(in);

            while(true){
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                Dout.writeUTF(bf.readLine());

                String string = Din.readUTF();
                System.out.println("来自server :" + string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
