package luogu_project.xs.first_Strings;

import java.util.Scanner;

public class passWord {
    public static void main(String args[]){
        //读取控制台输入
        String n;
        String s;
        Scanner scan = new Scanner(System.in);
        try {
            n = scan.nextLine();
            s = scan.nextLine();

            int n1 =Integer.parseInt(n);
            int l = s.length();
            for (int i = 0; i < l; i++){
                char b = (char)(s.charAt(i) + n1);
                if(b > 'z'){
                    System.out.print((char)(b - 26));
                }else {
                    System.out.print(b);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
