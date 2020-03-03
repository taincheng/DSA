package luogu_project.pj.pj_jcmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1042 {
    public static void main(String args[]){
        p1042 p = new p1042();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int s11 = 11,s21 = 21;
            String s = "";
            while (true){
                String s1 = bf.readLine();
                s = s.concat(s1);
                if(s1.contains("E")) break;
            }
            s = s.substring(0,s.indexOf("E"));
            p.bisai(s,s11);
            System.out.println("\n");
            p.bisai(s,s21);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void bisai(String s,int s_num){
        char[] c = s.toCharArray();
        int L = c.length;
        int w = 0,l = 0;
        if(L == 0){
            System.out.print("0:0");
        }else{
            for(int i = 0; i < L; i++){
                if(c[i] == 'W'){
                    w++;
                }else l++;
                if((w >= s_num || l >= s_num)&&(Math.abs(w-l) >= 2)){
                    System.out.println(w+":"+l);
                    w = 0;
                    l = 0;
                }
                if(i == L-1){
                    System.out.print(w+":"+l);
                }
            }
        }

    }
}
