package luogu_project.xs.new_com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach_con {
    public boolean isOdd(int a){
        if(a % 2 == 0) {
            return false;
        }else{
            return true;
        }
    }
    public boolean isPrime(int a){
        for (int i = 2; i*i <= a; i++){
            if((a % i) == 0) return false;
        }
        return true;
    }
    public void seach(int num){
        int tmp = 0;
        int n = num - 4;
        if(isOdd(n) && isPrime(n)){
            System.out.print(2 + " " + 2 + " "+n);
        }else{
            for (int i = 3; i < num; i++){
                if(isPrime(i)&&isOdd(i)){
                    for (int j = i; j < num; j++){
                        if(isOdd(j)&&isPrime(j)){
                            tmp = num - i -j;
                            if(isPrime(tmp)){
                                System.out.print(i + " "+ j + " " + tmp);
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            Goldbach_con gc = new Goldbach_con();
            String s = bf.readLine().trim();
            int num = Integer.parseInt(s);//9 < num < 20000
            gc.seach(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
