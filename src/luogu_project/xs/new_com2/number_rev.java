package luogu_project.xs.new_com2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class number_rev {
    public void Print(char ss[],int L) {
        boolean zero = true;
        for (int k = 0; k < L; k++) {
            if (ss[k] == '0' && zero) {
                continue;
            } else {
                zero = false;
                System.out.print(ss[k]);
            }
        }
    }

    public static void main(String srgs[]) {
        number_rev nr = new number_rev();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            int sz = Integer.parseInt(s);
            if(sz != 0){
                char[] ss = s.toCharArray();
                int L = ss.length;
                double Ls = Math.ceil((double) (L / 2));
                char tmp;
                for (int i = 0; i < Ls; i++) {
                    tmp = ss[i];
                    ss[i] = ss[L - i - 1];
                    ss[L - i - 1] = tmp;
                }
                if (sz >= 0) {
                    nr.Print(ss,L);
                } else {
                    System.out.print("-");
                    nr.Print(ss,L-1);
                }
            }else
                System.out.print(0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
