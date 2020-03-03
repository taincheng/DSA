package luogu_project.xs.new_com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class three_click {
    public boolean sele_zero(int num){
        for(int i = 2; i > 0; i--){
            if(num % 10 == 0){
                return false;
            }
            num = num / 10;
        }
        return true;
    }
    public boolean zj(int num){
        int[] a = new int[3];
        for(int j = 0; j < 3; j++){
            a[j] = num % 10;
            num = num / 10;
        }
        for(int k =0; k < 3; k++){
            for(int i = k+1;i < 3; i++){
                if(a[k] == a[i]) return false;
            }
        }
        return true;

    }
    public boolean compare(int num, int total){
        int[] a = new int[3];
        int[] b = new int[3];

        int al = a.length;
        int bl = b.length;
        for(int x = al - 1; x >= 0; x--){
            a[x] = total % 10;
            total = total / 10;
        }
        for(int i = bl - 1; i >= 0; i--){
            b[i] = num % 10;
            num = num / 10;
        }

        for(int z = 0; z < al; z++){
            for(int j = 0; j < bl; j++){
                if(a[z] == b[j]) return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            three_click tc = new three_click();
            String s = bf.readLine();
            //A<B<C
            int A = Integer.parseInt(s.split(" ")[0]);
            int B = Integer.parseInt(s.split(" ")[1]);
            int C = Integer.parseInt(s.split(" ")[2]);

            int tmp1 = 0, tmp2 = 0,total,js=0;
            for(int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    if (i == j) continue;
                    for (int k = 1; k <= 9; k++) {
                        if (i != k && j != k) {
                            total = i * 100 + j * 10 + k;
                            tmp1 = (total * B) / A;
                            tmp2 = (total * C) / A;
                            if (tc.zj(tmp1) && tc.zj(tmp2)) {
                                if (tc.sele_zero(tmp1) && tc.sele_zero(tmp2)) {
                                    if (tmp2 < 999) {
                                        if (tc.compare(total, tmp1) && tc.compare(total, tmp2)
                                                && tc.compare(tmp1, tmp2)) {
                                            js++;
                                            System.out.println(total + " " + tmp1 + " " + tmp2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(js == 0){
                System.out.print("No!!!");
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
