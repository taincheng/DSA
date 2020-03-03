package THE_1_testCode;

public class _1_1_24 {
    public static void main(String[] args){
        System.out.println(gcd(45,55));
    }
    public static int gcd(int p ,int q){
        if (p == 1 || q == 1) {
            System.out.println("p: " + p + "  q: " + q);
            return 1;
        }
        if (p < q) {
            int tmp = p;
            p = q;
            q = tmp;
        }
        System.out.println("p: " + p + "  q: " + q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q ,r);
    }
}
