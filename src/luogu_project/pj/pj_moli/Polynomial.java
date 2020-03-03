package luogu_project.pj.pj_moli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polynomial {
    public void poly_Print(int n,int[] xs){
        int L = xs.length;
        for(int i = 0;i<L;i++,n--){
            if (i < L-2 ) {
                if(xs[i] < 0){
                    if(xs[i] == -1) System.out.print("-x^"+n);
                    else System.out.print(xs[i]+"x^"+n);
                }else if(xs[i] == 0){}
                else{
                    if(i == 0){
                        if(xs[i] == 1){
                            System.out.print("x^"+n);
                        }else
                            System.out.print(xs[i]+"x^"+n);
                    }else {
                        if(xs[i] == 1){
                            System.out.print("+x^"+n);
                        }else{
                            System.out.print("+"+xs[i]+"x^"+n);
                        }
                    }
                }
            }else{
                if (i == L-1) {
                    if(xs[i] < 0)System.out.print(xs[i]);
                    else if(xs[i] == 0 ){}
                    else System.out.print("+"+xs[i]);
                }
                if(i == L-2){
                    if(xs[i] < 0){
                        if(xs[i] == -1) System.out.print("-x");
                        else System.out.print(xs[i]+"x");
                    }
                    else if(xs[i] == 0) {}
                    else {
                        if(xs[i] == 1){
                            System.out.print("+x");
                        }else{
                            System.out.print("+"+xs[i]+"x");
                        }
                    }
                }
            }
        }
    }
    public static void main(String srgs[]){
        Polynomial pn = new Polynomial();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine().trim();
            String s2 = bf.readLine().trim();
            int n = Integer.parseInt(s1);//多项式的次数
            int[] xs = new int[n+1];
            for(int i = 0;i<n+1;i++){
                xs[i] = Integer.parseInt(s2.split(" ")[i]);
            }
            pn.poly_Print(n,xs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
