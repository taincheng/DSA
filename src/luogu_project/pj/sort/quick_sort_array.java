package luogu_project.pj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quick_sort_array {
    public static void main(String[] args){
        quick_sort_array quickSortArray = new quick_sort_array();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = bf.readLine();
            int N = s1.length();
            List array = new ArrayList();
            for(int i = 0; i < N;i++){
                array.add(Integer.parseInt(s1.split("")[i]));
            }
            Collections.shuffle(array);
            quickSortArray.QuickSort(array, 0, N-1);
            System.out.println(array.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void QuickSort(List array, int start, int end){
        if(end <= start) return;
        int j = partition(array,start,end);
        QuickSort(array, start,j-1);
        QuickSort(array, j+1 ,end);
    }

    public int partition(List array, int start, int end){
        int i = start;
        int j = end + 1;
        int compare = (int)array.get(start);
        while (true){
            while (less(compare, (int)array.get(++i))) if (i == end) break;
            while (less((int)array.get(--j), compare)) if (j == start) break;
            if (i >= j) break;
            chang(array,i,j);
        }
        chang(array,start,j);
        return j;
    }

    public boolean less(int a, int b){
        if(a == b) return false;
        return a < b;
    }

    public void chang(List array, int a, int b){
        int tamp = 0;
        tamp = (int)array.get(a);
        array.set(a,array.get(b));
        array.set(b,tamp);
    }
}
