package luogu_project.pj._贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_1181 {
    public static void main(String args[]) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine().trim();
            String s2 = bf.readLine().trim();

            int N = Integer.parseInt(s1.substring(0,1));
            int M = Integer.parseInt(s1.substring(2,3));

            String[] s = s2.split(" ");
            int[] a = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int f = 0;
            int total = 0;
            for(int i = 0; i < N; i++){
                total += a[i];
                if(total > M){
                    total = a[i];
                    f++;
                }
                if(i == N-1){
                    f++;
                }
            }
            System.out.print(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}