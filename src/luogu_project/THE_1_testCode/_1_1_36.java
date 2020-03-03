package THE_1_testCode;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.random;

public class _1_1_36 {
    public static int[] initialization(int[] a){
        /*
        初始化数组
         */
        for (int i = 0;i<a.length;i++){
            a[i] = i;
        }
        return a;
    }
    public static int[] rank(int[] a){
        /*
        随机打乱数组
         */
        Random random = new Random();
        for (int i = 0;i<a.length;i++){
            int r = i + random.nextInt(a.length-i);
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
        return a;
    }

    public static void main(String[] args){
        int[] a = new int[10];
        initialization(a);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println();
        rank(a);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]);
        }
    }
}
