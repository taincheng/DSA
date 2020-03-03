package luogu_project.xs.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_com {
    public static int total = 1;
    public void recu(int a){
        /**
         * 递归
         */
        for(int i = 1; i <= a / 2; i++){
            total += 1;
            recu(i);
        }
    }
    public int digui(int a){
        /**
         * 递推，nlg(n)
         */
        int[] f = new int[1001];
        f[1] = 1;
        for(int i = 2; i <= a; i++){
            for(int j = 1; j <= i/2; j++){
                f[i] += f[j];
            }
            f[i]++;
        }
        return f[a];
    }
    public static void main(String args[]){
        int a = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            a = Integer.parseInt(s);
            num_com nc = new num_com();
            System.out.print(nc.digui(a));
            //nc.recu(a);
            //System.out.print(total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
