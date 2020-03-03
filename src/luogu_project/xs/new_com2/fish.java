package luogu_project.xs.new_com2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fish {
    public void isOk(int s, int x){
        double S = (double)s;
        double X = (double)x;
        double Long = 7;
        int time = 1;
        double SS = S - X;
        double S_c = S - X;
        if(SS > 0){
            while(S_c > 0){
                if(time == 1){
                    S_c = S_c - Long;
                }else{
                    Long *= 0.98;
                    S_c = S_c - Long;
                }
                time ++;
            }
            double L = S_c + Long;
            double L_time = (L / Long);
            double R_time = (1 - L_time);
            double R_time_re = (2*X - Math.abs(S_c)) / (Long * 0.98);
            if(Math.abs(S_c) >= 2*X){
                System.out.print("n");
            }else{
                if((R_time_re + R_time) >= 1){
                    System.out.print("y");
                }else System.out.print("n");
            }
        }else{
            if(7 > (S+X)){
                System.out.print("n");
            }else System.out.print("y");
        }

    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            fish f = new fish();
            String s1 = bf.readLine().trim();
            String[] a = s1.split(" ");
            int s = Integer.parseInt(a[0]);//距离
            int x = Integer.parseInt(a[1]);//半径
            f.isOk(s,x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
