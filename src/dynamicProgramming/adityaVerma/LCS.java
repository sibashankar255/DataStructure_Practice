package dynamicProgramming.adityaVerma;

public class LCS {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        String s= "abba";

//        System.out.println(lcsRecursion(text1,text2,text1.length(),text2.length()));
//        System.out.println(lcs(text1,text2));
//        System.out.println(longestSubstring(text1,text2));
//        System.out.println(longestCommonSubsequence(text1,text2));

        System.out.println(anyTwo(s));
    }

    //longest common subsequence
    //print LCS
    //shortest common supersequence
    //print shortest common supersequence
    //min # of insertion and deletion a-> b
    //longest repeating subsequence
    //length of longest subsequence of a which is substring in b
    //subsequence pattern matching
    //count how many times a appears as subsequence in b
    //longest palindromic subsequence
    //longest palindromic substring
    //count of palindromic substring
    //min # of deletion in a string to make it a palindrome
    //min # of insertion in a string to make it a palindrome

    public static int lcsRecursion(String text1, String text2, int n, int m){
        if(n==0 || m==0){
            return 0;
        }
        if (text1.charAt(n-1) == text2.charAt(m-1)){
            return 1+lcsRecursion(text1,text2,n-1,m-1);
        }
        return Math.max(lcsRecursion(text1,text2,n,m-1),lcsRecursion(text1,text2,n-1,m));
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public static int lcs(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=n; i++){
            for (int j=1; j<=m; j++){
                dp[i][j]=-1;
            }
        }
        return lcsMemo(text1,text2,n,m,dp);
    }

    public static int lcsMemo(String text1, String text2, int n, int m,int[][] dp){
        if(n==0 || m==0){
            return 0;
        }

        if (dp[n][m] != -1){
            return dp[n][m];
        }

        if (text1.charAt(n-1) == text2.charAt(m-1)){
            return dp[n][m]= 1+lcsRecursion(text1,text2,n-1,m-1);
        }
        return  dp[n][m] = Math.max(lcsRecursion(text1,text2,n,m-1),lcsRecursion(text1,text2,n-1,m));

    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    public static int longestCommonSubsequence(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        return lcsUtilTabular(m,n,text1,text2,dp);

    }
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

    ///////////////////////////////////////////////////////////////////////////////////////////

    //longest common substring
    public static int longestSubstring(String text1, String text2) {

        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        return lcsUtilTabular(m,n,text1,text2,dp);

    }
    public static int longestSubstringUtil(int m, int n, String s1, String s2, int dp[][]){
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

    /////////////////////////////////////////////////////////////////////////////////

    //minimum number of deletion in a string to make it palindrome
    //
    //length of string - lcs length


    //Wildcard Matching


    //minimum number of insertion in a string to make it palindrome



    //longest repeating Subsequence
    public static int anyTwo(String A) {
        String B=A;
        int m=A.length();
        int n=B.length();
        int[][] dp = new int[m+1][n+1];
        int l= lcsUtilTabular(m,n,A,B,dp);

        return l;
    }
    public static int lcsUtilRepeating(int m, int n, String s1, String s2, int dp[][]){
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (s1.charAt(i-1)==s2.charAt(j-1) && i!=j){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }





}
