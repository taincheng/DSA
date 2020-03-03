package luogu_project.pj.pj_jcmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1031 {
    public static void main(String args[]){
        p1031 p = new p1031();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine().trim();
            String s2 = bf.readLine();
            int N = Integer.parseInt(s1);
            String[] S = s2.split(" ");
            int[] buke = new int[N];
            for(int i = 0; i < N; i++){
                buke[i] = Integer.parseInt(S[i]);
            }
            p.move_num(buke,N);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void move_num(int[] buke,int N){
        int[] bk = new int[N];
        int num = 0;
        int total = 0;
        for(int i = 0; i < N; i++){
            total += buke[i];
        }
        int pj = total / N;
        for(int i = 0; i < N; i++){
            bk[i] = buke[i] - pj;
        }
        for(int i = 0; i < N; i++){
            if(bk[i] != 0){
                bk[i+1] = bk[i] + bk[i+1];
                bk[i] = 0;
                num++;
            }
        }
        System.out.print(num);
    }
}
