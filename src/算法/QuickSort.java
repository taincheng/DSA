package 算法;

import java.util.Random;

/**
 * @Author TianCheng
 * @Date 2020/1/21 18:29
 */
public class QuickSort {
    private void sort(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        swap(arr, L + (int)(Math.random() * (R - L +1) ), R);
        int[] p = partition(arr, L, R);
        sort(arr, L, p[0] - 1);
        sort(arr, p[1] + 1, R);
    }

    private int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while(L < more){
            if(arr[L] < arr[R]){
                swap(arr, ++less, L++);
            }else if(arr[L] > arr[R]){
                swap(arr, --more, L);
            }else{
                L ++;
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int less, int l) {
        int tmp = arr[less];
        arr[less] = arr[l];
        arr[l] = tmp;
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int n = new Random().nextInt(100);
        int[] arr = new int[n];
        for (int i = 0; i < n ; i ++){
            arr[i] = new Random().nextInt(100);
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        qs.sort(arr, 0, n-1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
