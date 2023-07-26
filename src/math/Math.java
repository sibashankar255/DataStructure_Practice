package math;

import java.util.Arrays;

public class Math {
    public static void main(String[] args) {

        boolean[] isPrime = prime(20);
        for (int i=0; i<=20; i++){
            System.out.println(isPrime[i]+" ");
        }
    }

    public static boolean[] prime(int n){
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;

        for (int i=2; i*i<n; i++){
            for (int j=2*i; j<=n ;j+=i){
                isPrime[j]=false;
            }
        }
        return isPrime;
    }

    //gcd of 2 numbers
    //gcd(a,b) = gcd(a-b,b)

    static int gcd(int a, int b){
//        if (b==0){
//            return a;
//        }
//        return gcd(b,a%b);

        return a%b==0 ? b : gcd(b,a%b);
    }
}
