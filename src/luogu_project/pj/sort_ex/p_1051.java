package luogu_project.pj.sort_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1051 {
    public String Name(String s){
        String[] view = s.split(" ");
        String sp = view[0];
        return sp;
    }
    public int how_reword(String s){
        //YaoLin 87 82 Y N 0
        int num = 0;
        String[] view = s.split(" ");
        String name = view[0];
        int ks_cj = Integer.parseInt(view[1]);//平均成绩
        int py_cj = Integer.parseInt(view[2]);//班级评议成绩
        String is_cadre = view[3];
        String is_west = view[4];
        int paper_num = Integer.parseInt(view[5]);

        //计算奖金数
        if(ks_cj > 80 && paper_num >= 1) num += 8000;
        if(ks_cj > 85 && py_cj > 80) num += 4000;
        if(ks_cj > 90) num += 2000;
        if(ks_cj > 85 && "Y".equals(is_west)) num += 1000;
        if(py_cj > 80 && "Y".equals(is_cadre)) num += 850;

        return num;
    }
    public void Sort(String[][] s){
        int l = s.length;
        for(int i = 0; i < l; i++){
            for(int j = i + 1; j < l; j++){
                if(Integer.parseInt(s[i][1]) < Integer.parseInt(s[j][1])){
                    String en = s[i][0];
                    s[i][0] = s[j][0];
                    s[j][0] = en;

                    String em = s[i][1];
                    s[i][1] = s[j][1];
                    s[j][1] = em;

                }
            }
        }
    }
    public static void main(String args[]){
        p_1051 p = new p_1051();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int Total = 0;
            int num = Integer.parseInt(bf.readLine().trim());
            String[][] student_reword = new String[num][2];
            for(int i = 0; i<num; i++){
                String s = bf.readLine();
                int reword_total = p.how_reword(s);
                Total += reword_total;
                String name = p.Name(s);
                student_reword[i][0] = name;
                student_reword[i][1] = String.valueOf(reword_total);
            }
            p.Sort(student_reword);
            System.out.println(student_reword[0][0]);
            System.out.println(student_reword[0][1]);
            System.out.print(Total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
