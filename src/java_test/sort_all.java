package java_test;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sort_all {
    public static void main(String[] args) {
        sort_all sort_all = new sort_all();
        int[] a = new int[]{5, 4, 7, 3, 2, 1};
        //a = sort_all.BubbleSort(a);//冒泡排序
        //a = sort_all.xuanzhe(a);//选择排序
        //a = sort_all.chalu(a);//插入排序
        //int[] b = sort_all.change(a);//让数组混乱，给快速排序准备
        //sort_all.QuickSort(b,0,b.length-1);//快速排序
        //sort_all.mergeSort(a, 0, a.length - 1);//原地归并
        sort_all.Shell_Sort(a,0,a.length-1);//希尔排序
        sort_all.Print(a);
    }

    public void Swap(int[] a, int x, int y) {
        int tmpt = a[x];
        a[x] = a[y];
        a[y] = tmpt;
    }

    public void Print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 冒泡排序算法
     *
     * @param a 要排序的数组
     * @return 从小到大的排序
     */
    public int[] BubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (a[i] > a[j]) {
                    Swap(a, i, j);
                }
            }
        }
        return a;
    }

    /**
     * 找出最小的数
     *
     * @param a 数组
     * @param k 从k下标开始查找最小的
     * @return 最小数的下标
     */
    public int min(int[] a, int k) {
        int xb = k;
        int len = a.length;
        int min = a[k];
        for (int i = k; i < len; i++) {
            if (min > a[i]) {
                min = a[i];
                xb = i;
            }
        }
        return xb;
    }

    /**
     * 选择排序
     *
     * @param a
     * @return
     */
    public int[] xuanzhe(int[] a) {
        /*
        核心思想：把最小或最大的找出来放在一边
         */
        for (int i = 0; i < a.length; i++) {
            int xb = min(a, i);
            Swap(a, xb, i);
        }
        return a;
    }

    /**
     * 选择排序
     *
     * @param a
     * @return
     */
    public int[] chalu(int[] a) {
        for (int i = 1; i < a.length; i++) {//从第二个元素，开始遍历每一个元素
            for (int j = i - 1; j >= 0; j--) {//与左边的元素比较，小就交换位置
                if (a[j + 1] < a[j]) {
                    Swap(a, j + 1, j);
                }
            }
        }
        return a;
    }

    /**
     * 原地归并排序算法(不会消耗大量的空间)
     * 普通的归并算法会在每一次分割数组时，开辟一个原数组一般空间大小的数组来存放。
     * 这样的后果就是额外花费的空间和排序数组的长度N成正比。所以出现原地归并来解决该问题。
     * 使用了递归。
     *
     * @param a : 排序数组， left : 左指针, right : 右指针
     * @return void
     */
    public void mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid + 1, right);
        }
    }

    public void merge(int[] a, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = right;
        while (i < j && j <= k) {
            int step = 0;
            while (i < j && a[i] < a[j]) {
                i++;
            }
            while (j < k && a[j] < a[i]) {
                j++;
                step++;
            }
            exchang(a, i, j, step);
            i = i + step;
        }
    }

    /**
     * 对调旋转，实现将两端数组交换位置
     *
     * @param a
     * @param i
     * @param j
     * @param step
     */
    public void exchang(int[] a, int i, int j, int step) {
        reverse(a, i, j - step - 1);
        reverse(a, j - step, j);
        reverse(a, i, j);
    }

    /**
     * 将数组逆序，[i,j)
     *
     * @param a
     * @param i
     * @param j
     */
    public void reverse(int[] a, int i, int j) {
        while (i < j) {
            Swap(a, i, j);
            i++;
            j--;
        }
    }

    /**
     * 快速排序
     *
     * @param sz 要排序的数组
     * @param lo 首指针
     * @param hi 尾指针
     */
    public void QuickSort(int[] sz, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(sz, lo, hi);
        QuickSort(sz, lo, j - 1);
        QuickSort(sz, j + 1, hi);
    }

    public int partition(int[] sz, int lo, int hi) {
        int i = lo, j = hi + 1;//左右扫描指针
        int v = sz[lo];//切分元素
        while (true) {
            //扫描左右，检查扫描是否结束并交换元素
            while (less(sz[++i], v)) if (i == hi) break;
            while (less(v, sz[--j])) if (j == lo) break;
            if (i >= j) break;
            Swap(sz, i, j);
        }
        Swap(sz, lo, j);//把v特征值从开头放在中间，v本来就是排序的标准。
        return j;
    }

    public boolean less(int i, int v) {
        if (i == v) return false;
        return i < v;
    }

    //利用Collections集合类方法shuffle 将数值打乱，降低快速排序的复杂度。
    public int[] change(int[] a) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            ls.add(a[i]);
        }
        Collections.shuffle(ls);
        for (int i = 0; i < a.length; i++) {
            a[i] = ls.get(i);
        }
        return a;
    }

    /*
    希尔排序
     */
    public void Shell_Sort(int[] a,int start,int end){
        int increment = a.length;
        int temp = 0;
        do{
            increment = increment / 3 + 1;
            for(int i  = start + increment; i <= end; i++){
                if(a[i - increment] > a[i]){
                    temp = a[i];
                    int j = i - increment;
                    do{
                        a[j + increment] = a[j];
                        j -= increment;
                    }while (j > start && a[j] > temp);
                    a[j + increment] = temp;
                }
            }
        }while (increment > 1);
    }

    /*
    堆排序
     */

}
