package luogu_project.pj.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1101 {
    static String y = "yizhong";
    public static boolean[][] is_ok(char[][] array){
        boolean[][] is_a = new boolean[array.length][array.length];
        int[][] weiz = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        String str = "y";

        for(int i = 0; i < array.length;i++){
            for(int j = 0; j < array[0].length; j++){
                int xw = i,yw = j;
                if(array[i][j] == 'y'){
                    for(int k = 0; k < 8; k++){//八个方向
                        for(int m = 1; m < 7; m++){//yizhong长度
                            xw += weiz[k][0];
                            yw += weiz[k][1];
                            if((xw<=array.length-1&&xw>=0)&&(yw>=0&&yw<=array[0].length-1))
                                str = str.concat(String.valueOf(array[xw][yw]));
                            else
                                break;
                        }
                        xw = i; yw = j;
                        if(str.equals(y)){
                            for(int m = 0; m < 7; m++){
                                is_a[xw][yw] = true;
                                xw += weiz[k][0];
                                yw += weiz[k][1];
                            }
                        }
                        xw = i; yw = j;
                        str = "y";
                    }
                }
            }
        }
        return is_a;
    }

    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(bf.readLine().trim());
            char [][] array = new char[N][N];
            for(int i = 0; i < N; i++){
                array[i] = bf.readLine().trim().toCharArray();
            }
            boolean[][] is_ok = is_ok(array);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(is_ok[i][j]){
                        System.out.print(array[i][j]);
                    }else{
                        System.out.print('*');
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
