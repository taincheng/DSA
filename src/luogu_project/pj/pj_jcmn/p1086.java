package luogu_project.pj.pj_jcmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1086 {
    public static void main(String args[]) {
        p1086 p = new p1086();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            int M = Integer.parseInt(s.split(" ")[0]);
            int N = Integer.parseInt(s.split(" ")[1]);
            int K = Integer.parseInt(s.split(" ")[2]);
            int[][] a = new int[M][N];
            for (int i = 0; i < M; i++) {
                String s1 = bf.readLine();
                String[] S = s1.split(" ");
                for (int j = 0; j < N; j++) {
                    a[i][j] = Integer.parseInt(S[j]);
                }
            }
            p.Print(a, M, N, K);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Print(int[][] a, int M, int N, int K) {
        int total = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != 0) {
                    total++;
                }
            }
        }
        int[][] zs = new int[total][3];
        int k = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != 0) {
                    zs[k][0] = a[i][j];
                    zs[k][1] = i;
                    zs[k][2] = j;
                    k++;
                }
            }
        }
        paixu(zs);
        do_bear(zs, K);
        System.out.print("");
    }

    public void paixu(int[][] a) {
        int L = a.length;
        int tmp1 = 0;
        int tmp2 = 0;
        int tmp3 = 0;
        for (int i = 0; i < L; i++) {
            for (int j = i + 1; j < L; j++) {
                if (a[i][0] <= a[j][0]) {
                    tmp1 = a[i][0];
                    tmp2 = a[i][1];
                    tmp3 = a[i][2];
                    a[i][0] = a[j][0];
                    a[i][1] = a[j][1];
                    a[i][2] = a[j][2];
                    a[j][0] = tmp1;
                    a[j][1] = tmp2;
                    a[j][2] = tmp3;
                }
            }
        }
    }

    public void do_bear(int[][] a, int K) {
        int L = a.length;
        int total = 0;
        int total_bear = 0;
        for (int i = 0; i < L; i++) {
            if (i == 0) {
                total = total + a[i][1] + 1 + 1;
                if (isok(a[i][1] + 1, K - total)) {
                    total_bear = total_bear + a[i][0];
                    if(i == L -1) System.out.print(total_bear);
                }else {
                    System.out.print(total_bear);
                    break;
                }
            } else {
                if (i == L - 1) {
                    total = total  + 1 + Math.abs(a[i][1] - a[i - 1][1])
                            + Math.abs(a[i][2] - a[i - 1][2]);
                    if (isok(a[i][1] + 1, K - total)) {
                        total_bear = total_bear + a[i][0];
                        System.out.print(total_bear);
                    } else {
                        System.out.print(total_bear);
                        break;
                    }
                } else {
                    total = total + Math.abs(a[i][1] - a[i - 1][1])
                            + Math.abs(a[i][2] - a[i - 1][2]) + 1;
                    if (isok(a[i][1] + 1, K - total)) {
                        total_bear = total_bear + a[i][0];
                    } else {
                        System.out.print(total_bear);
                        break;
                    }
                }
            }
        }
    }

    public boolean isok(int total, int K) {
        if (K - total >= 0) {
            return true;
        }
        return false;
    }
}
