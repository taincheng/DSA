package luogu_project.pj._贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p_1208 {
    public static void SortIntArray(int[][] arObiect, final int[] order){
        Arrays.sort(arObiect, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < order.length; i++){
                    int k = order[i];
                    if(o1[k] > o2[k]) return 1;
                    else return -1;
                }
                return 0;
            }
        });
    }
    public static int TanX(int N, int M, int[][] a){
        /**
         * 计算最小费用
         */
        SortIntArray(a,new int[]{0});
        int Total = 0;
        for(int i = 0; i < M; i++){
            if(a[i][1] < N){
                N = N - a[i][1];
                Total = Total + a[i][0] * a[i][1];
            }else{
                Total = Total + a[i][0] * N;
                break;
            }
        }
        return Total;
    }
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            int N = Integer.parseInt(s1.split(" ")[0]);
            int M = Integer.parseInt(s1.split(" ")[1]);

            int[][] a = new int[M][2];
            for(int i = 0; i < M; i++){
                String s2 = bf.readLine();
                a[i][0] = Integer.parseInt(s2.split(" ")[0]);
                a[i][1] = Integer.parseInt(s2.split(" ")[1]);
            }
            System.out.print(TanX(N,M,a));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
