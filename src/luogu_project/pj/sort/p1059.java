package luogu_project.pj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class p1059 {
    public static void main(String args[]){
        p1059 p = new p1059();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine().trim();
            String s2 = bf.readLine();
            int N = Integer.parseInt(s1);
            String[] s = s2.split(" ");
            int L = s.length;
            TreeSet<Integer> a = new TreeSet<>();
            for(int i = 0; i < L; i++){
                a.add(Integer.parseInt(s[i]));
            }
            System.out.println(a.size());
            for(int i : a){
                System.out.print(i+ " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
