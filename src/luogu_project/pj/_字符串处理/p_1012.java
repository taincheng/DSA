package luogu_project.pj._字符串处理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1012 {
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(bf.readLine());
            String s = bf.readLine();

            String[] S = s.split(" ");
            for(int i = 0; i < S.length; i++){
                for(int j = i+1; j < S.length; j++){
                    if(Integer.parseInt(S[j]+S[i]) > Integer.parseInt(S[i] + S[j])){
                        String tmp = S[i];
                        S[i] = S[j];
                        S[j] = tmp;
                    }
                }
            }
            for(String i : S){
                System.out.print(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
