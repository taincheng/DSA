package luogu_project.pj.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1019 {
    static String Line = "";
    static int result = 0;
    public static int N_word(String s1, String s2){
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        for(int i = 0; i < Math.min(a.length,b.length); i++){
            if(a[a.length-1] == b[i]){
                for(int j = a.length-1, k = i; j >=0 && k >= 0; j--,k--){
                     if(a[j] != b[k]){
                         return 0;//没有接龙
                     }
                     if(j == 0 || i == b.length-1){
                         if(s1.equals(s2)){
                             return -1;
                         }else
                             return 0;//包含
                     }
                     if(k == 0){
                         return i+1;//有接龙，返回位置.
                     }
                }
            }
        }
        return 0;
    }
    public static int[][] Same_word(String[] s,int N){
        /**
         * 1.查找两个单词最小匹配
         * 2.单词被后包含则不算,相同的单词不算包含
         * 3.每个单词最多用两次
         */
        int[][] jl = new int[N][N];
        for(int i = 0; i < N;i++){
            for(int j = 0; j < N; j++){
                jl[i][j] = N_word(s[i],s[j]);
            }
        }
        return jl;
    }
    public static void dfs(int[][] same,String[] s,int[] num,String Line,int i){
        String tmp = Line;
        if(result <= Line.length()){
            result = Line.length();
        }
        for(int j = 0; j < s.length; j++){
            if(num[j] == 2) continue;
            if(same[i][j] != 0){
                if(same[i][j] == -1){
                    continue;
                }else {
                    Line = Line.concat(s[j].substring(same[i][j]));
                    num[j] ++;
                }
                dfs(same,s,num,Line,j);
                Line = tmp;
                num[j] --;
            }
        }
    }
    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int N = Integer.parseInt(bf.readLine().trim());

            int[] num = new int[N];//记录单词出现次数
            int[][] same = new int[N][N];
            String[] s = new String[N];//保存单词
            for(int i = 0; i < N; i++){
                s[i] = bf.readLine().trim();
            }
            String Start = bf.readLine().trim();
            same = Same_word(s,N);
            for(int i = 0; i < N; i++){
                if(s[i].substring(0,1).equals(Start)){
                    num[i] = 1;
                    Line = s[i];
                    dfs(same,s,num,Line,i);
                }
            }
            System.out.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
