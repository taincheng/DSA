package luogu_project.pj.sort_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 该题使用了比较器，对二维数组指定行列进行比较
 */
public class p_1093 {
    public static void SortInArray(int[][] a, final int[] order){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for(int i = 0; i < order.length; i++){
                    int k = order[i];
                    if(k != order[order.length-1]){
                        if(o1[k] > o2[k]) return -1;
                        else if(o1[k] < o2[k]) return 1;
                        else continue;
                    }else{
                        if(o1[k] > o2[k]) return 1;
                        else if(o1[k] < o2[k]) return -1;
                        else continue;
                    }
                }
                return 0;
            }
        });
    }
    public static void main(String args[]){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(bf.readLine());
            int[][] grade = new int[num][5];
            for(int i = 1; i<=num; i++){
                String[] s = bf.readLine().split(" ");
                grade[i-1][0] = i;
                grade[i-1][1] = Integer.parseInt(s[0]);//语文
                grade[i-1][2] = Integer.parseInt(s[1]);
                grade[i-1][3] = Integer.parseInt(s[2]);
                grade[i-1][4] = grade[i-1][1] + grade[i-1][2] + grade[i-1][3];//总分
            }

            SortInArray(grade,new int[]{4,1,0});
            for(int i = 0; i<5;i++){
                System.out.println(grade[i][0]+ " " +grade[i][4]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
