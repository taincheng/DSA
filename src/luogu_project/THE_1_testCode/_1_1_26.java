package THE_1_testCode;

public class _1_1_26 {
    public static void main(String[] args){

    }
    public static double[][] binomial(int N, int k, double p){
        double[][] a = new double[N+1][k+1];
        a[0][0] = 1;
        for(int j=1;j<N+1;j++){
            a[j][0] = a[j-1][0]*(1-p);
        }
        for(int i = 0;i<N+1;i++){
            for(int j = 1;j<=i&&j<k+1;j++){
                a[i][j] = (1-p)*a[i-1][j]+p*a[i-1][j-1];
            }
        }
        return a;
    }
}
