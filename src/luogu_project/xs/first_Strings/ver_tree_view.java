package luogu_project.xs.first_Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ver_tree_view {
    public String scan(){
        /**
         * 输入的数据整合
         */
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String a5 = "";
        try {
            String a1 = input.readLine();
            String a2 = input.readLine();
            String a3 = input.readLine();
            String a4 = input.readLine();
            a5 = a5.concat(a1).concat(a2).concat(a3).concat(a4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a5;
    }

    public String Be_String(String s){
        /**
         * 变成一条长字符串
         */
        String last = "";
        String test = s.trim();
        String[] array = test.split(" ");
        int n = array.length;
        for(int i = 0; i < n; i++){
            last = last.concat(array[i]);
        }
        return last;
    }

    public int[] Char_Count(String s){
        /**
         * 计算字符的数
         */
        int num = s.length();
        int[] char_num = new int[26];
        for(int j = 0; j<char_num.length;j++){
            char_num[j] = 0;
        }
        for(int i = 0;i<num;i++){
           if(s.charAt(i)<='Z'&&s.charAt(i)>='A'){
               char_num[s.charAt(i)-'A'] ++;
           }
           if(s.charAt(i)<= 'z' && s.charAt(i) >= 'a'){
               char_num[s.charAt(i)-'a'] ++;
           }
        }
        return char_num;
    }

    public void print_star(int[] a){
        int max = 0;
        for(int i = 0;i<a.length;i++){
            if(max<=a[i]){
                max = a[i];
            }
        }
        for(int j = max; j > 0; j--){
            for(int k = 0;k<26; k++){
                if(a[k]>=j){System.out.print("* ");}
                else{System.out.print("  ");}
            }
            System.out.println();
        }
        for(char x = 'A'; x<='Z'; x++){
            System.out.print(x+ " ");
        }

    }

    public static void main(String args[]){
        ver_tree_view vtv = new ver_tree_view();
        String a = vtv.Be_String(vtv.scan());
        int[] num = vtv.Char_Count(a);
        vtv.print_star(num);
    }
}
