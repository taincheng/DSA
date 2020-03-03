package THE_1_testCode;

public class _1_1_22 {
    public static int rank(int key,int[] a, int lo, int hi, int q){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo)/2;
        if (key < a[mid]) {
            q += 1;
            System.out.println(q);
            System.out.println("\t*q");
            return rank(key, a, lo, mid-1, q);
        }
        if (key > a[mid]) {
            q += 1;
            System.out.println(q);
            System.out.println("\t*q");
            return rank(key, a, mid+1, hi, q);
        }
        else{
            return mid;
        }
    }
    public static void main(String[] args){
        int q = 0;
        int[] a = {1,3,4,5,6};
        rank(2,a,0,a.length-1,q);
    }
}
