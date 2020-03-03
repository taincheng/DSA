package luogu_project.pj._字符串处理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class p_1603 {
    public static int printArray(String[] numS,String value) {
        for (int i = 0; i < numS.length; i++) {
            if (numS[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        String[] numS = new String[]{
                "zero","one","two","three","four","five",
                "six","seven","eight","nine","ten","eleven",
                "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty","a","both","another","first","second","third"
        };
        int[] numI = new int[]{0,1,4,9,16,25,36,49,64,81,0,21,44,69,96,25,56,89,24,61,0,1,4,1,1,4,9};

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            String[] S = s.split(" ");
            int[] re_num = new int[numS.length];
            int k = 0;
            for(int i = 0; i < S.length; i++){
                int x = printArray(numS,S[i]);
                if(x !=-1){
                    re_num[k] = numI[x];
                    k++;
                }
            }
            if(k != 0){
                Arrays.sort(re_num);
                //StringBuilder stringBuilder = new StringBuilder("");
                String str = "";
                for(int j: re_num){
                    if(j != 0){
                        if(j/10 <1){
                            str = str.concat("0"+String.valueOf(j));
                        }else
                            str = str.concat(String.valueOf(j));
                    }
                }
                int b = 0;
                for(;;){
                    if(str.charAt(b) !='0') break;
                    b++;
                }
                System.out.print(str.substring(b,str.length()));
            }else{
                System.out.print(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
