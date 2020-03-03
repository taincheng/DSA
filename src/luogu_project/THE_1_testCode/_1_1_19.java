package THE_1_testCode;

public class _1_1_19 {
    static int N = 4000;
    static long[] a = new long[N];

    public static long F(int n){
        if(n == 1) return 1;
        if(n == 0) return 0;
        if(a[n-1] != 0) return a[n-1];
        a[n-1] = F(n-1) + F(n-2);
        return a[n-1];
    }
    public static void main(String[] args){
        a[0] = a[1] = 0;
        float t1 = System.currentTimeMillis();
        long c = F(N);
        float t2 = System.currentTimeMillis();
        float t = t2-t1;
        System.out.println(t1);
        System.out.println(t2);
        //System.out.println("%.3f\n",t);
        System.out.println(c);
    }
}
