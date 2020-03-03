package luogu_project.xs.new_com2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cantor {
    public void cantor(int N) {
        for (int i = 1; ; i++) {
            if (N <= i) {
                if (i % 2 == 0) {
                    System.out.print(N + "/" + (i - N + 1));
                } else {
                    System.out.print((i - N + 1) + "/" + N);
                }
                break;
            }
            N = N - i;
        }
    }

    public static void main(String sr[]) {
        Cantor ct = new Cantor();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine().trim();
            int N = Integer.parseInt(s);
            ct.cantor(N);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
