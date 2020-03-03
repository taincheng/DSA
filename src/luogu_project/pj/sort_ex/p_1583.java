package luogu_project.pj.sort_ex;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_1583 {
    public int[] Sort(int[] S) {
        Arrays.sort(S);
        int l = S.length;
        int[] a = new int[l];
        for (int i = l - 1; i >= 0; i--) {
            a[l-i-1] = S[i];
        }
        return a;
    }

    public void TakeBk(int[] S, int[] E, int N, int K) {
        //对S从大到小排序
        int[] s = Sort(S);

        //对s中的数分类和加上E[i]放入新的数组ss[]
        int xu = 0;
        int[] ss = new int[N];
        for (int i = 0; i < N; i++) {
            xu = i % 10;
            ss[i] = s[i] + E[xu];
        }

        for (int i = 0; i < K; i++){
        	System.out.print(ss[i] + " ");

        }
    }

    public static void main(String args[]) {
        p_1583 p = new p_1583();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String nk = bf.readLine();
            String e = bf.readLine();
            String s = bf.readLine();

            int N = Integer.parseInt(nk.trim().split(" ")[0]);
            int K = Integer.parseInt(nk.trim().split(" ")[1]);
            String[] ee = e.split(" ");
            int eel = ee.length;
            int[] E = new int[eel];
            for (int i = 0; i < eel; i++) {
                E[i] = Integer.parseInt(ee[i]);
            }

            String[] ss = s.split(" ");
            int ssl = ss.length;
            int[] S = new int[ssl];
            for (int i = 0; i < ssl; i++) {
                S[i] = Integer.parseInt(ss[i]);
            }
            p.TakeBk(S, E, N, K);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
