package luogu_project.xs.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class select_num {
    static int js = 0;
    static int[] x = new int[20];
    public int panduan(int k, int sum, int start, int end){
        int sum_s = 0;
        if(k == 0) {
            if(isprime(sum)){
                return ++js;
            }
        }
        for(int i = start; i <= end; i++){
            if((end - start+1) < k){
                break;
            }else {
                sum_s += panduan(k - 1, sum + x[i], i + 1, end);
            }
        }
        return sum_s;
    }
    public boolean isprime(int n){
        int s = (int)Math.sqrt((double)n);
        if(n == 0 || n == 1) return false;
        else {
            for (int i = 2; i <= s; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            select_num sn =new select_num();
            String s = bf.readLine();//分别是 n k
            String num_s = bf.readLine();//具体数

            int n = Integer.parseInt(s.split(" ")[0]);
            int k = Integer.parseInt(s.split(" ")[1]);
            String[] a = num_s.split(" ");
            for(int i = 0; i < a.length; i++){
                x[i] = Integer.parseInt(a[i]);
            }
            int sum = 0;
            sn.panduan(k,sum,0,n-1);
            System.out.println(js);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
