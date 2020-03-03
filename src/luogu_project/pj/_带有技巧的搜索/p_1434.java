package luogu_project.pj._带有技巧的搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
记忆化搜索
 */
public class p_1434 {
    static int R,C,num,max_num,t_num;
    static int[][] works_num;
    static int[][] works;
    static int[][] workTo= {{1,0},{0,1},{-1,0},{0,-1}};
    public static void dfs(int X,int Y){
        if(max_num < num){
            max_num = num;
        }
        int where = works[X][Y];
        for(int i = 0; i < 4; i++){
//            if(t_num < num){
//                t_num = num;
//            }
            int newX = X + workTo[i][0];
            int newY = Y + workTo[i][1];
            if(newX >= 0 && newX < R && newY >= 0 && newY < C){
                if(works[newX][newY] < where){
                    num ++;
//                    if(works_num[newX][newY] != 0){
//                        t_num = num + works_num[newX][newY];
//                    }else{
                        dfs(newX,newY);
//                    }
                    num --;
                }
            }
        }
    }

    public static void main(String[] args){

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            R = Integer.parseInt(s.split(" ")[0]);
            C = Integer.parseInt(s.split(" ")[1]);
            works = new int[R][C];
            works_num = new int[R][C];
            for(int i = 0; i < R; i++){
                String s1 = bf.readLine();
                for(int k = 0; k < C; k ++){
                    int tmp = Integer.parseInt(s1.split(" ")[k]);
                    works[i][k] = tmp;
                }
            }
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    dfs(i,j);
                    works_num[i][j] = max_num + 1;
                    num = 0;
                    max_num = 0;
                }
            }
            int maxNum = 0;
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C; j++){
                    if(maxNum < works_num[i][j]){
                        maxNum = works_num[i][j];
                    }
                }
            }
            System.out.print(maxNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
