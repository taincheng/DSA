package luogu_project.pj.sort_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.math.BigDecimal;
import java.math.BigInteger;

public class p_1223 {
    public static void SortInArrays(int[][] a, final int[] order){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i<order.length; i++){
                    int k = order[i];
                    if(o1[k] > o2[k]) return 1;
                    else if(o1[k] < o2[k])return -1;
                    else continue;
                }
                return 0;
            }
        });
    }
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine().trim());
            String s = bf.readLine();
            String[] S = s.split(" ");

            int[][] a = new int[n][2];
            for(int i = 0; i < n; i++){
                a[i][0] = i+1;
                a[i][1] = Integer.parseInt(S[i]);
            }
            SortInArrays(a,new int[]{1,0});
            long Total = 0;
            long all_t = 0;
            for(int i = 0; i<n; i++){
                if(i != 0){
                    Total  = Total + a[i][1];
                }
                all_t = all_t + Total;
                System.out.print(a[i][0] + " ");
            }
            long pj = 0;
            pj = all_t / n;
            System.out.println();
            System.out.format("%.2f",pj*1.0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
