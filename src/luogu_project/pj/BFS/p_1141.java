package luogu_project.pj.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1141 {
    static int[][] walk = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int num = 0;
    static int max = 0;
    public static void dfs(char[][] C_num, int a, int b, boolean[][] is_walk) {
        if(num > max){
            max = num;
        }
        int x = a;
        int y = b;
        for (int i = 0; i < 4; i++) {
            int p = x + walk[i][0];
            int q = y + walk[i][1];
            if (p < C_num.length && p >= 0 && q < C_num.length && q >= 0 && !is_walk[p][q]) {
                if (C_num[p][q] != C_num[x][y]) {
                    num++;
                    is_walk[p][q] = true;
                    dfs(C_num, p, q, is_walk);
                    is_walk[p][q] = false;
                    num--;
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            int n = Integer.parseInt(s1.split(" ")[0]);
            int m = Integer.parseInt(s1.split(" ")[1]);
            char[][] C_num = new char[n][n];
            for (int i = 0; i < n; i++) {
                String s2 = bf.readLine();
                C_num[i] = s2.toCharArray();
            }
            //记录起始位置的数组
            int[][] a = new int[m][2];
            for (int i = 0; i < m; i++) {
                String s3 = bf.readLine();
                a[i][0] = Integer.parseInt(s3.split(" ")[0]) - 1;
                a[i][1] = Integer.parseInt(s3.split(" ")[1]) - 1;
            }
            //记录是否走过
            boolean[][] is_walk = new boolean[n][n];
            for(int i = 0; i < m; i++){
                is_walk[a[i][0]][a[i][1]] = true;
                dfs(C_num,a[i][0],a[i][1],is_walk);
                if(i == m-1){
                    System.out.print(max+1);
                }else{
                    System.out.println(max+1);
                }
                num = 0;
                max = 0;
                for(int j = 0; j < n; j++){
                    for(int k = 0; k < n; k++) {
                        is_walk[j][k] = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
