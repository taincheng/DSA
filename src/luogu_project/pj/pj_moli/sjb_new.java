package luogu_project.pj.pj_moli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sjb_new {
    int[][] a = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {-1, -1, 1, 0, 1},
            {1, 1, -1, -1, 0}};

    public static void main(String args[]) {
        sjb_new sn = new sjb_new();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            String s2 = bf.readLine();
            String s3 = bf.readLine();
            int N = Integer.parseInt(s1.split(" ")[0]);//出拳次数
            int Na = Integer.parseInt(s1.split(" ")[1]);//小a出拳周期
            int Nb = Integer.parseInt(s1.split(" ")[2]);//小b出拳周期
            int[] NA = sn.changtoint(s2);//小a出拳
            int[] NB = sn.changtoint(s3);//小b出拳
            sn.compare(NA, NB, N, Na, Nb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] changtoint(String s) {
        String[] S = s.split(" ");
        int l = S.length;
        int[] a = new int[l];
        for (int i = 0; i < l; i++) {
            a[i] = Integer.parseInt(S[i]);
        }
        return a;
    }

    public void compare(int[] NA, int[] NB, int N, int Na, int Nb) {
        int x = 0, y = 0;
        int N_fa = 0, N_fb = 0;
        for (int i = 0; i < N; i++) {
            if(x >= Na) x = 0;
            if(y >= Nb) y = 0;
            if (a[NA[x]][NB[y]] == -1) N_fb++;
            if (a[NA[x]][NB[y]] == 1) N_fa++;
            x++;
            y++;
        }
        System.out.print(N_fa+" "+N_fb);
    }
}
