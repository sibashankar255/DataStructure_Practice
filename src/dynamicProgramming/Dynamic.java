package dynamicProgramming;

import java.util.Arrays;

public class Dynamic {
    public static void main(String[] args) {


        //Coin Change Problem
        int n=18;
        int[] dp =new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        int[] arr = {7,5,1};
        int ans=minCoin(arr,18,dp);



    }



    //Coin Change Problem
    public static int minCoin(int[] coins, int amount,int[] dp){
        if(amount==0){ return 0; }
        int ans = Integer.MAX_VALUE;

        for (int i=0; i<coins.length; i++){
            if(amount-coins[i]>=0){
                int subAns = 0;
                if(dp[amount-coins[i]] !=-1){
                    subAns = dp[amount-coins[i]];
                }else {
                    subAns = minCoin(coins,amount-coins[i], dp);
                }

                if (subAns != Integer.MAX_VALUE && subAns+1<ans){
                    ans=subAns+1;
                }
            }
        }
        dp[amount]=ans;
        return ans;
    }

    //0/1 Knapsack Problem


    //Longest Common Subsequence
    //s1=ABCAB
    //s2=AECB
    public int longestCommonSubsequence(String text1, String text2) {
        String s =  new StringBuilder(text1).reverse().toString();

        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                dp[i][j]=-1;
            }
        }
        return lcsUtil(m,n,text1,text2,dp);
    }
    private int lcsUtil(int m, int n, String text1, String text2, int[][] dp) {
        if (m==0 || n==0){
            return 0;
        }
        if (dp[m][n] != -1){
            return dp[m][n];
        }
        if(text1.charAt(m-1) ==text2.charAt(n-1)){
            dp[m][n] = 1+lcsUtil(m-1,n-1,text1,text2,dp);
            return dp[m][n];
        }else {
            dp[m][n] = Math.max(lcsUtil(m,n-1,text1,text2,dp),lcsUtil(m-1,n,text1,text2,dp));
            return dp[m][n];
        }
    }

    //Longest Common Subsequence - tabular solution
    public static int lcsUtilTabular(int m, int n, String s1, String s2, int dp[][]){
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    //edit distance
    public static int editDistance(String s1, String s2){
        int m = s1.length();
        int n= s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i=0; i<=m; i++){dp[i][0]=i;}
        for (int j=0; j<=n; j++){dp[0][j]=j;}

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    //palindromic partitioning
    public static int palindromicPartition(String s){
        int n= s.length();
        int[][] dp = new int[n][n];

        for (int gap=1; gap<n; gap++){
            for (int row=0, col=gap; row<n-gap; row++,col++){
                if (isPalindrome(s,row,col)){
                    dp[row][col]=0;
                }else {
                    dp[row][col]=Integer.MAX_VALUE;
                    for (int k=row;k<col;k++){
                        dp[row][col]=Math.min(dp[row][col], 1+dp[row][k]+dp[k+1][col]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
    static boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if (s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }


    //Rod Cutting Problem
    public static int cutRod(int[] prices){
        int n = prices.length;
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++){
            for (int j=0; j<i; j++){
                dp[i] = Math.max(dp[i],prices[j]+dp[i-j-1]);
            }
        }
        return dp[n];
    }



}
