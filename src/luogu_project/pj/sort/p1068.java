package luogu_project.pj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1068 {
    public static void main(String args[]) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine().trim();
            int n = Integer.parseInt(s1.split(" ")[0]);
            int m = Integer.parseInt(s1.split(" ")[1]);
            int[][] grade = new int[10005][105];
            int[] person = new int[105];
            for (int i = 0; i < n; i++) {
                String s = bf.readLine();
                int a = Integer.parseInt(s.split(" ")[0]);
                int b = Integer.parseInt(s.split(" ")[1]);
                grade[a][b]++;
                person[b]++;
            }
            int grade_line_p = (int) (m * 1.5);
            int grade_line_man = 0;
            int grade_line = 0;
            for (int i = 100, s = grade_line_p; s > 0; i--) {
                if (person[i] != 0) {
                    grade_line_man += person[i];
                    grade_line = i;
                    s -= person[i];
                }
            }
            System.out.println(grade_line+ " " + grade_line_man);
            for(int i = 100; i >=grade_line; i--){
                for(int j = 1000; j<=9999; j++){
                    if(grade[j][i] != 0){
                        System.out.println(j + " " + i);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
