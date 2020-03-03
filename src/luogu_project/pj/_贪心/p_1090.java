package luogu_project.pj._贪心;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p_1090 {
    public static void main(String args[]) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(bf.readLine().trim());
            String[] s = bf.readLine().split(" ");

            int[] S = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                S[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(S);
            int Total = 0;
            for (int i = 0; i < S.length; i++) {
                if((i+1) == S.length) break;
                Total = S[i] + S[i + 1] + Total;
                S[i+1] = S[i] + S[i+1];
                Arrays.sort(S,i+1,S.length);
            }
            System.out.print(Total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
