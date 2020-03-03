package luogu_project.xs.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palin_Prime {
    public int jw(int a){
        /**
         * 处理进位
         */
        int b = 1;
        for(int k = 0; k < a; k++){
            b = b * 10;
        }
        return b;
    }
    public int ws(int a){
        /**
         * 得到位数
         */
        int b = 0;
        if(a == 0) return 1;
        while (a >= 1){
            a = a / 10;
            b +=1;
        }
        return b;
    }
    public int instead(int a, int ws){
        int n = 0;
        while (a >= 1){
            n = n + (a % 10) * jw(ws-1);
            ws--;
            a = a / 10;
        }
        return n;
    }
    public int[] Palin_ok(int a, int b,int Pal[]){
        /**
         * a为起始范围
         * b为结束范围
         * Pal[] 存放回文数
         * bit_num 为b的位数
         */

        //得到b的位数
        int bit_num = ws(b);
        //创造回文数,不想要讨论偶数位的回文数
        //得到回文前半部分的位数所能代表的最大数，例如三位数，则为10
        int bit_num_f = (bit_num - 1) / 2;
        int bit_num_fb = jw(bit_num_f);//得到前半位数能表达的最大数+1
        int js = 0;
//        if(a <=11&& b>=11){
//            js = 1;
//            Pal[0] = 11;
//        }
        for(int j = 0;j < bit_num_fb; j++){
            for(int i = 0; i <= 9;i++){
                int Pal_mid = 0;
                if(j == 0) Pal_mid = i;
                else {
                    if (i == 0) {
                        Pal_mid += j * jw(ws(j)+1) + instead(j,ws(j));
                    } else {
                        Pal_mid += j * jw(ws(j)+1) + i * jw(ws(j)) + instead(j,ws(j));
                    }
                }
                if(Pal_mid == 0 || Pal_mid == 1) continue;
                if(Pal_mid < a) continue;
                if(Pal_mid > b) break;
                Pal[js] = Pal_mid;
                js++;
            }
        }
        return Pal;
    }
    public boolean isPrime(int a){
        if(a == 0 || a == 1) return false;
        else{
            int p = (int)Math.sqrt((double) a);
            for (int i = 2; i <= p; i++){
                if (a % i == 0) return false;
            }
            return true;
        }
    }
    public static void main(String args[]){
        int a = 0,b = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine().trim();
            a = Integer.parseInt(s.split(" ")[0]);
            b = Integer.parseInt(s.split(" ")[1]);
            Palin_Prime pp = new Palin_Prime();
            int[] Pal = new int[10000000];
            int[] p_ok = pp.Palin_ok(a,b,Pal);

            int num_t = 0;
            while (p_ok[num_t] != 0){
                if(pp.isPrime(p_ok[num_t])){
                    if(p_ok[num_t] == 101 && a <= 11){
                        System.out.println(11);
                        System.out.println(p_ok[num_t]);
                    }else {
                        System.out.println(p_ok[num_t]);
                    }
                }
                num_t++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
