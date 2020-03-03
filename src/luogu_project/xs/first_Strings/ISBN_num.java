package luogu_project.xs.first_Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISBN_num {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = 0;
            int mod = 0;
            int total = 0;
            String a1 = br.readLine().trim();
            int l = a1.length() - 1;

            for(int i = 0; i < l; i++){
                if(a1.charAt(i) != '-'){
                    n += 1;
                    total = total + Integer.parseInt(a1.substring(i,i+1)) * n;
                }
            }
            mod = total % 11;
            if(mod == 10){
                if(a1.substring(l).equals("X")){
                    System.out.print("Right");
                }else{
                    String k = a1.substring(0,l).concat("X");
                    System.out.print(k);
                }
            }else{
                String x = String.valueOf(mod);
                if(x.equals(a1.substring(l))){
                    System.out.print("Right");
                }else{
                    String s = a1.substring(0,l).concat(x);
                    System.out.print(s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
