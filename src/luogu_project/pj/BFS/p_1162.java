package luogu_project.pj.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1162 {
    static int[][] work = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void bfs(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j].equals("0")) {
                    boolean[] isok = {false,false,false,false};
                    int p = 0;
                    for (int k = 0; k < 4; k++) {
                        int xw = i;
                        int yw = j;
                        while (true) {
                            xw = xw + work[k][0];
                            yw = yw + work[k][1];
                            if ((xw < arr.length && xw >= 0) && (yw < arr.length && yw >= 0)) {
                                if(arr[xw][yw].equals("1")){
                                    isok[p] = true;
                                }
                            }else {
                                break;
                            }
                        }
                        p++;
                    }
                    for(int q = 0; q < 4; q++){
                        if(!isok[q]){
                            arr[i][j] = "0";
                            break;
                        }else{
                            arr[i][j] = "2";
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(bf.readLine().trim());
            String[][] arr = new String[N][N];
            for (int i = 0; i < N; i++) {
                String s = bf.readLine();
                arr[i] = s.split(" ");
            }
            bfs(arr);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    System.out.print(arr[i][j] +" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
