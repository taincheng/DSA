package luogu_project.xs.new_com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class apple_improve {
    public void sort_a(int[][] a){
        int n = a.length;
        int t1,t2;
        for(int i = 0;i < n - 1;i++){
            for(int j = 0; j < n - i -1; j++){
                if(a[j][1] > a[j+1][1]){
                    t1 = a[j][1]; t2 = a[j][0];
                    a[j][1] = a[j+1][1]; a[j][0] = a[j+1][0];
                    a[j+1][1] = t1; a[j+1][0] = t2;
                }
            }
        }
    }
    public int get_apple(int apple_num,int strong,int char_h,int man_h,String a[]){
        int num = 0;
        int[][] num_a = new int[a.length][2];
        int total_h = char_h + man_h;
        int app_h,need_s;
        //得到二维int摘苹果条件.
        for(int k = 0; k< apple_num; k++){
            num_a[k][0] = Integer.parseInt(a[k].split(" ")[0]);
            num_a[k][1] = Integer.parseInt(a[k].split(" ")[1]);
        }
        sort_a(num_a);
        for (int i =0; i < apple_num; i++){
            app_h = num_a[i][0];
            need_s = num_a[i][1];
            if(strong < 0){
                return num;
            }else {
                if (total_h >= app_h && strong >= need_s) {
                    num++;
                    strong -= need_s;
                }
            }
        }
        return num;
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            apple_improve ai = new apple_improve();
            String s1 = bf.readLine();
            String s2 = bf.readLine();
            int apple_num = Integer.parseInt(s1.split(" ")[0]);
            int strong = Integer.parseInt(s1.split(" ")[1]);

            int char_h = Integer.parseInt(s2.split(" ")[0]);
            int man_h = Integer.parseInt(s2.split(" ")[1]);

            String[] a_num = new String[apple_num];
            for(int n = 0; n < apple_num; n++){
                a_num[n] = bf.readLine();
            }

            int num = ai.get_apple(apple_num,strong,char_h,man_h,a_num);
            System.out.print(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
