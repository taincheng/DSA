package luogu_project.pj.pj_moli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class arrange_seats {
    int K_k = 0;
    int L_l = 0;
    public static void main(String args[]) {
        arrange_seats as = new arrange_seats();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int[] seat_num = new int[4];
            String s1 = bf.readLine();
            int M = Integer.parseInt(s1.split(" ")[0]);//行
            int N = Integer.parseInt(s1.split(" ")[1]);//列
            int K = Integer.parseInt(s1.split(" ")[2]);//输出第几行隔开位置
            int L = Integer.parseInt(s1.split(" ")[3]);//输出第几列隔开位置
            int D = Integer.parseInt(s1.split(" ")[4]);//D行交头接耳的学生位置
            int[] pass_M = new int[K];
            int[] pass_N = new int[L];
            for(int i = 0; i < D; i++){
                String s = bf.readLine();
                as.seat_numAdd(s,seat_num);
                as.send_pass(seat_num,pass_M,pass_N);
            }
            for(int i = 0; i < K;i++){
                System.out.print(pass_M[i]);
                if(i < K-1) System.out.print(" ");
            }
            System.out.println();
            for(int i = 0; i < L;i++){
                System.out.print(pass_N[i]);
                if(i < L-1) System.out.print(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void seat_numAdd(String s,int[] seat_num){
        String[] S = s.split(" ");
        for(int i = 0; i< 4;i++){
            seat_num[i] = Integer.parseInt(S[i]);
        }
    }
    public void send_pass(int[] seat_num,int[] pass_M,int[] pass_N){
        if(seat_num[1] == seat_num[3]){
            int a = Math.min(seat_num[0],seat_num[2]);
            if(is_contain(pass_M,a)) pass_M[K_k] = a; K_k++;
        }
        if(seat_num[0] == seat_num[2]){
            int a = Math.min(seat_num[1],seat_num[3]);
            if(is_contain(pass_N,a)) pass_N[L_l] = a; L_l++;
        }
    }

    public boolean is_contain(int[] pass_M,int a){
        int L = pass_M.length;
        for(int i = 0; i < L; i++){
            if(pass_M[i] == a) return false;
        }
        return true;
    }
}
