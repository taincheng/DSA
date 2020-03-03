package luogu_project.pj.sort_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p_1309 {
    public static void SortInArray(int[][] X, final int[] order) {
        Arrays.sort(X, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < order.length; i++) {
                    int k = order[i];
                    if (k == order[order.length - 1]) {
                        if (o1[k] > o2[k]) return 1;
                        else if (o1[k] < o2[k]) return -1;
                        else continue;
                    } else {
                        if (o1[k] > o2[k]) return -1;
                        else if (o1[k] < o2[k]) return 1;
                        else continue;
                    }
                }
                return 0;
            }
        });
    }

    //要使用归并排序
    public static void mergeArray(int a[][],int b[][],int ans[][]){
        int k = 0;
        int t = 0;
        int m = 0;
        while(t<a.length && m<b.length){
            if(a[t][1] > b[m][1]){
                ans[k++] = a[t++];
            }else{
                if(a[t][1] == b[m][1] && a[t][0] < b[m][0]){
                    //积分相同编号小的往前排
                    ans[k++] = a[t++];
                    continue;
                }
                ans[k++] = b[m++];
            }
        }
        while(t<a.length){
            ans[k++] = a[t++];
        }
        while(m<b.length){
            ans[k++] = b[m++];
        }
    }
    public static void sigleAfter(int a[][],int b[][],int ans[][]){
        int j = 0;
        for(int i = 0; i < ans.length-1; i+=2){
            if(ans[i][2] > ans[i+1][2]){
                ans[i][1]++;
                a[j] = ans[i];
                b[j] = ans[i+1];
            }else{
                ans[i+1][1]++;
                a[j] = ans[i+1];
                b[j] = ans[i];
            }
            j++;
        }
    }
    public static void main(String args[]) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            String s2 = bf.readLine();
            String s3 = bf.readLine();

            int N = Integer.parseInt(s1.split(" ")[0]);
            int R = Integer.parseInt(s1.split(" ")[1]);
            int Q = Integer.parseInt(s1.split(" ")[2]);

            int[][] X = new int[2 * N][3];
            String[] a1 = s2.split(" ");
            String[] a2 = s3.split(" ");
            for (int i = 0; i < 2 * N; i++) {
                X[i][0] = i + 1;
                X[i][1] = Integer.parseInt(a1[i]);
                X[i][2] = Integer.parseInt(a2[i]);
            }
            int a[][] = new int [N][3];//胜者组
            int b[][] = new int [N][3];//败者组
            //比赛
            SortInArray(X,new int[]{1,0});
            for (int i = 0; i < R; i++){
                sigleAfter(a, b, X);
                mergeArray(a, b, X);
            }
            System.out.print(X[Q-1][0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
