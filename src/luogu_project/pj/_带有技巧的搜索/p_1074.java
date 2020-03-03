package luogu_project.pj._带有技巧的搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1074 {
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[][] shudu = new int[9][9];
        for(int i = 0; i < 9; i ++){
            try {
                String s = bf.readLine();
                String[] ss = s.split(" ");
                for(int j = 0; j < 9; j++){
                    shudu[i][j] = Integer.parseInt(ss[j]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
