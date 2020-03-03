package luogu_project.pj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 */
public class quick_sort {
    public static void main(String args[]) {
        quick_sort qs = new quick_sort();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bf.readLine();
            String s1 = bf.readLine();

            int N = Integer.parseInt(s);
            String[] S = s1.split(" ");
            int[] sz = qs.change(S,N);
            qs.Sort(sz, 0, N - 1);
            for(int i = 0; i < N; i++){
                if(i != N-1){
                    System.out.print(sz[i] + " ");
                }else{
                    System.out.print(sz[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Sort(int[] sz, int lo, int hi){
        if(hi <= lo) return;
        int j = partition(sz, lo, hi);
        Sort(sz, lo, j-1);
        Sort(sz,j+1, hi);
    }
    public int partition(int[] sz, int lo, int hi){
        int i = lo, j = hi+1;//左右扫描指针
        int v = sz[lo];//切分元素
        while(true){
            //扫描左右，检查扫描是否结束并交换元素
            while(less(sz[++i], v)) if(i == hi) break;
            while(less(v, sz[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(sz,i,j);
        }
        exch(sz,lo,j);//把v特征值从开头放在中间，v本来就是排序的标准。
        return j;
    }
    public boolean less(int i, int v){
        if(i == v) return false;
        return i < v;
    }
    public void exch(int[] sz, int i, int j){
        int temp;
        temp = sz[i];
        sz[i] = sz[j];
        sz[j] = temp;
    }
    public int[] change(String[] s,int N){
        int[] a = new int[N];
        List<Integer> ls = new ArrayList<>(N);
        for(int i = 0; i< N; i++){
            ls.add(Integer.parseInt(s[i]));
        }
        Collections.shuffle(ls);
        for(int i =0; i< N;i++){
            a[i] = ls.get(i);
        }
        return a;
    }
}
