package luogu_project.pj._字符串处理;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_1071 {
    public static boolean is_ok(Collection<String> a){
        HashSet<String> s = new HashSet<>();
        for(String q : a){
            s.add(q);
        }
        if(s.size() < 26) return false;
        else {
            return true;
        }
    }
    public static void tran(String[] jm,String[] od,String[] test){
        HashMap<String,String> map = new HashMap<>();
        int len = jm.length;
        for(int i = 0; i < len; i++){
            if(map.containsKey(jm[i]) && !map.get(jm[i]).equals(od[i]) ){
                System.out.print("Failed");
                return;
            }else {
                map.put(jm[i],od[i]);
            }
        }
        if(map.size() < 26) System.out.print("Failed");
        else if(!is_ok(map.values())) System.out.print("Failed");
        else{
            for(int i = 0; i<test.length; i++){
                System.out.print(map.get(test[i]));
            }
        }
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            String s2 = bf.readLine();
            String s3 = bf.readLine();

            String[] jm = s1.trim().split("");
            String[] od = s2.trim().split("");
            String[] test = s3.trim().split("");

            tran(jm,od,test);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
