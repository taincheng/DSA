package luogu_project.xs.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match_sticks {
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int b = 0;
        int num = 0;
        try {
            String s = bf.readLine();
            b = Integer.parseInt(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int j = 0;
        int[] c={6,2,5,5,4,5,6,3,7,6};
        int[] a = new int[2000];
        a[0] = 6;
        for(int i = 0; i < 2000; i++){
            j = i;
            while (j >= 1){
                a[i] = a[i] + c[j % 10];
                j = j / 10;
            }
        }

        for(int k = 0; k < 1000; k++){
            for(int i = 0; i < 1000; i++){
                if((a[k] + a[i] + a[k+i] + 4) == b) num++;
            }
        }
        System.out.print(num);
    }
}
