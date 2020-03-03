package luogu_project.pj._带有技巧的搜索;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p_1433 {

    static double min = Double.MAX_VALUE;
    /**
     *
     * @param i 已经吃到的奶酪数
     * @param sum 距离总和
     * @param array 所有奶酪对象
     * @param is_work 判断是否已经吃过
     * @param num 当前的奶酪对象
     */
    public static void dfs(int i, double sum, ArrayList<NUM> array,boolean[] is_work, NUM num){
        if(sum > min) return; //剪枝，如果sum已经大于了最短路径，就不用继续。
        if(i == array.size()){
            if(sum < min) min = sum;
            return;
        }
        for(int j = 0; j < array.size(); j++){
            if(is_work[j] == false){
                is_work[j] = true;
                NUM tmpt = array.get(j);
                dfs(i + 1,sum + tmpt.getXY(num),array,is_work,tmpt);
                is_work[j] = false;
            }
        }
    }

    public static void main(String[] args){
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<NUM> array = new ArrayList<>();
        try {
            double N = Integer.parseInt(bf.readLine().trim());
            for(int i = 0; i < N; i++){
                NUM h = new NUM();
                String s = bf.readLine().trim();
                h.x = Double.parseDouble(s.split(" ")[0]);
                h.y = Double.parseDouble(s.split(" ")[1]);
                array.add(h);
            }
            boolean[] is_work = new boolean[array.size()];
            //ArrayList<double[]> dis_all = search_ALL(array);
            NUM num = new NUM();
            num.x = 0; num.y = 0;
            dfs(0,0,array,is_work,num);
            System.out.printf("%.2f",min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class NUM{
    double x,y;
    public double getXY(NUM num){
        return Math.sqrt(Math.pow(this.x-num.x,2) + Math.pow(this.y-num.y,2));
    }
}
