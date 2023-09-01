package dynamicProgramming;

import java.util.Arrays;

public class OneD {
    public static void main(String[] args) {

    }

    //climbing stairs
    public int climbStairs(int A) {
        if(A==1){
            return 1;
        }
        int[] dp = new int[A+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3; i<=A; i++){
            dp[i]=(dp[i-1]+dp[i-2]) % 1000000007;
        }
        return dp[A];
    }

    //fibonacci series
//    static int n;
//    static int[] array = new int[n+1];
//    Arrays.fill(array,-1);
    public static int findFibonacci(int[] array,int n){
        if(n<=1){
            return n;
        }
        if(array[n]>=0){
            return array[n];
        }
        array[n] = findFibonacci(array,n-1)+findFibonacci(array,n-2);
        return array[n];
    }

    //Minimum Number of Squares
    public static int countMinSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for (int i=2; i<=n ;i++){
            int min=Integer.MAX_VALUE;
            for (int j=1; j*j<=i;j++){
                int rem=i-j*j;
                if(dp[rem]<min){
                    min=dp[rem];
                }
            }
            dp[i]=min+1;
        }
        return dp[n];
    }

    //Max Product Subarray
    public int maxProduct(final int[] A) {
        int pre=1,suff=1;
        int ans =Integer.MIN_VALUE;
        int n=A.length;
        for (int i=0; i<n; i++){
            if (pre==0){
                pre=1;
            }
            if (suff==0){
                suff=1;
            }
            pre=pre*A[i];
            suff=suff*A[n-i-1];

            ans=Math.max(ans,Math.max(pre,suff));
        }
        return ans;
    }
}
