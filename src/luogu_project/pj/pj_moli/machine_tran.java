package luogu_project.pj.pj_moli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class machine_tran {
    int total = 0;
    public static void main(String args[]) {
        machine_tran mt = new machine_tran();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            String s2 = bf.readLine();
            int M = Integer.parseInt(s1.split(" ")[0]);//内存容量
            int N = Integer.parseInt(s1.split(" ")[1]);//文章长度
            String[] s = s2.split(" ");
            int sl = s.length;
            int[] article = new int[sl];
            for (int i = 0; i < sl; i++) {
                article[i] = Integer.parseInt(s[i]);
            }
            mt.tran(M, article);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tran(int M, int[] article) {
        int L = article.length;
        int[] M_s = new int[M];
        for(int i = 0; i < M; i++){
            M_s[i] = -1;
        }
        for (int i = 0; i < L; i++) {
            Ms_change(M_s,article[i]);
        }
        System.out.print(total);
    }
    public void Ms_change(int[] M_s,int a){
        int L = M_s.length;
        for(int i = 0; i < L; i++){
            if(M_s[i] == -1){
                M_s[i] = a;
                ++total;
                break;
            }else{
                if(M_s[i] == a) break;
                else{
                    if(i == L-1){
                        qy(M_s,a);
                        ++total;
                    }
                }
            }
        }
    }
    public void qy(int[] M_s,int a){
        int L = M_s.length;
        for(int i = 0; i < L; i++){
            if(i == L-1) M_s[i] = a;
            else M_s[i] = M_s[i+1];
        }
    }
}
