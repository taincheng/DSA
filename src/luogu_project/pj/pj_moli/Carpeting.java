package luogu_project.pj.pj_moli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Carpeting {
    public void isok(int[][] carpet, int x, int y) {
        int L = carpet.length;
        int i = 0;
        for (i = L - 1; i >= 0; i--) {
            int X = carpet[i][0] + carpet[i][2];
            int Y = carpet[i][1] + carpet[i][3];
            if ((x >= carpet[i][0] && x <= X) && (y >= carpet[i][1] && y <= Y)) {
                System.out.print(i + 1);
                break;
            }
        }
        if (i == -1) {
            System.out.print(-1);
        }
    }

    public static void main(String args[]) {
        Carpeting ct = new Carpeting();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(bf.readLine().trim());
            int[][] carpet = new int[num][4];
            for (int i = 0; i < num; i++) {
                String s = bf.readLine().trim();
                for (int j = 0; j < 4; j++) {
                    carpet[i][j] = Integer.parseInt(s.split(" ")[j]);
                }
            }
            String xy = bf.readLine();
            int x = Integer.parseInt(xy.split(" ")[0]);
            int y = Integer.parseInt(xy.split(" ")[1]);
            ct.isok(carpet, x, y);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
