package luogu_project.pj._分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p_1226 {
    public static void main(String[] args){
        p_1226 p = new p_1226();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            int num = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            int k = Integer.parseInt(s.split(" ")[2]);
            int ans = p.pow(num, b, k);
            System.out.printf("%d^%d mod %d=%d\n",num,b,k,ans%k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int pow(int num, int b, int c){
        int ans = 1;
        int base = num % c;
        while (b != 0){
            int k = b & 1;
            if(k != 0){
                ans = (ans * base) % c;
            }
            base = (base * base) % c;
            b >>= 1;
        }
        return ans;
    }
}
