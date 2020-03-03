package luogu_project.pj.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _八皇后 {
    static int MaxQueen = 0;
    static int num = 0;

    public static void GetQueen(int n,int[] cols) {
        boolean[] rows = new boolean[MaxQueen];

        for (int i = 0; i < n; i++) {
            rows[cols[i]] = true;//第几行有皇后，将这一行设置为true，为不可用
            int d = n - i;
            if (cols[i] - d >= 0) rows[cols[i] - d] = true; // cols[i] - d 表示斜线所在的行上，>=0说明没有越界
            if (cols[i] + d <= MaxQueen - 1) rows[cols[i] + d] = true;
        }
        for(int i = 0; i < MaxQueen; i++){
            if(rows[i]) continue;
            cols[n] = i;
            if(n < MaxQueen -1){
                GetQueen(n+1,cols);
            }else{
                num ++;
                if(num <=3){
                    Print(cols);
                }
            }
        }
    }
    public static void Print(int[] s){

        for(int i = 0; i<s.length;i++){
            System.out.print(s[i]+1 + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            MaxQueen = Integer.parseInt(bf.readLine().trim());
            int[] cols = new int[MaxQueen];
            GetQueen(0,cols);
            System.out.print(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
