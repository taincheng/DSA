package luogu_project.xs.new_com2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class function {
    int[][][] array = new int[21][21][21];
    public int w(int a,int b,int c){
        if(a<=0 || b<=0 || c<=0) return 1;
        else if(array[a][b][c]!=0) return array[a][b][c];
        else if(a>20 || b>20 || c>20) array[a][b][c] = w(20,20,20);
        else if(a<b && b<c)
            array[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        else array[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
        return array[a][b][c];
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        function f = new function();
        int[][] keep = new int[100][3];
        int t = 0;
        while (true){
            try {
                String s = bf.readLine().trim();
                String[] s1 = s.split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                int c = Integer.parseInt(s1[2]);
                if(a == -1 && b == -1 && c == -1) break;
                keep[t][0] = a;
                keep[t][1] = b;
                keep[t][2] = c;
                t ++;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < t; i++){
            if((keep[i][0] > 20 || keep[i][1] > 20 || keep[i][2] > 20) &&
                    keep[i][0] > 0 && keep[i][1] > 0 && keep[i][2] > 0){
                System.out.println("w("+keep[i][0]+", "+keep[i][1]+", "+keep[i][2]+") = " +
                        ""+f.w(20,20,20));
            }else{
                System.out.println("w("+keep[i][0]+", "+keep[i][1]+", "+keep[i][2]+") = " +
                        ""+f.w(keep[i][0],keep[i][1],keep[i][2]));
            }

        }
    }
}
