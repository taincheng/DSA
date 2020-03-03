package luogu_project.pj.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1605 {
    static int[][] work = new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    static int result = 0;
    public static int[] get(int[] s){
        int[] a = new int[2];
        for(int i = 0; i < 2; i++){
            a[i] = s[i];
        }
        return a;
    }
    public static void bfs(boolean[][] ZA,boolean[][] is_w,int[] sx,int[] sy){
        int N = ZA.length;
        int M = ZA[0].length;
        int[] a = new int[2];
        a = get(sx);
        if(a[0] == sy[0] && a[1] == sy[1]){
            result ++;
            return;
        }else{
            for(int i = 0; i < 4; i++){
                if((a[0] + work[i][0] < N && a[0] + work[i][0] >=0) && (a[1] + work[i][1] >=0 && a[1] + work[i][1] < N)) {
                    if (!(ZA[a[0] + work[i][0]][a[1] + work[i][1]]) && !(is_w[a[0] + work[i][0]][a[1] + work[i][1]])) {
                        a[0] += work[i][0];
                        a[1] += work[i][1];
                        is_w[a[0]][a[1]] = true;
                        bfs(ZA, is_w, a, sy);
                        a[0] -= work[i][0];
                        a[1] -= work[i][1];
                        is_w[a[0] + work[i][0]][a[1] + work[i][1]] = false;
                    }
                }else
                    continue;
            }
        }
    }
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            String s2 = bf.readLine();


            int N = Integer.parseInt(s1.split(" ")[0]);
            int M = Integer.parseInt(s1.split(" ")[1]);
            int T = Integer.parseInt(s1.split(" ")[2]);
            int[] sx = new int[]{Integer.parseInt(s2.split(" ")[0]) -1,Integer.parseInt(s2.split(" ")[1])-1};
            int[] sy = new int[]{Integer.parseInt(s2.split(" ")[2]) -1,Integer.parseInt(s2.split(" ")[3])-1};
            boolean[][] ZA = new boolean[N][M];//记录障碍
            for(int i = 0; i < T; i++){
                String s3 = bf.readLine();
                int x = Integer.parseInt(s3.split(" ")[0]) -1;
                int y = Integer.parseInt(s3.split(" ")[1]) -1;
                ZA[x][y] = true;
            }
            boolean[][] is_w = new boolean[N][M];//判断是否走过
            is_w[sx[0]][sx[1]] = true;
            bfs(ZA,is_w,sx,sy);
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
