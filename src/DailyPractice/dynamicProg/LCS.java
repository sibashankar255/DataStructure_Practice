package DailyPractice.dynamicProg;

public class LCS {

    public static void main(String[] args) {
        /*
        largest common substring
        print LCS
        shortest common super sequence
        print shortest common super sequence
        min # of insertion and deletion to convert a->b
        the largest repeating subsequence
        length of largest subsequence of a which is a substring in b
        subsequence pattern matching
        count how many times a appear as subsequence in b
        largest palindromic subsequence
        largest palindromic substring
        count of palindromic substring
        min # of deletion in a string to make it a palindrome
        min # of insertion in a string to make it a palindrome

         */
        String text1 = "abcde";
        String text2 = "";
        System.out.println(lcsTopDownPrint(text1,text2,5,0));

        System.out.println(string);


    }
    //largest common subsequence:-
    //x:- a b c d g h //n -> length
    //y:- a b e d f h a //m -> length
    //base condition:-
    //if(n==0 || m==0){
    // return 0}
    //if last character is matching then remove the last characters of both the text +1 call recursive
    //if it does not match then remove 1 character from end from both text one by one and check which is
    //maximum as we are checking the largest common
    static int lcs(String text1,String text2, int m, int n){
        if (n==0 || m==0){
            return 0;
        }
        if (text1.charAt(n-1)==text2.charAt(n-1)){

            return 1+lcs(text1,text2,m-1,n-1);
        }else {
            return Math.max(lcs(text1,text2,m-1,n), lcs(text1,text2,m,n-1));
        }
    }

    //memoized
    public static int lcsMemo(String text1,String text2, int m, int n){
        int[][] dp = new int[n+1][m+1];
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                dp[i][j]=-1;
            }
        }
        return lcsUtil(m,n,text1,text2,dp);
    }
    private static int lcsUtil(int m, int n, String text1, String text2, int[][] dp) {
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

    //top-down
    //i-> m -> length of text1
    //j-> n -> length of text2
    public static int lcsTopDown(String text1,String text2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (text1.charAt(i-1) ==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //largest common substring
    //text1 = abcde
    //text2 = abfce
    int longestCommonSubstring(String text1,String text2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (text1.charAt(i-1) ==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }

    //print LCS
    static String string = "";
    public static int lcsTopDownPrint(String text1,String text2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (text1.charAt(i-1) ==text2.charAt(j-1)){
                    string =  string+text1.charAt(i-1);
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }


    //length of supersequence of s1 and s2
    //s1 = ABCA
    //s2 = ACDB
    //super sequence = ABCADB
    //lcs = AC = length =2
    //total = m+n-l
    public int shortestCommonSupersequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        int lcs =lcsUtilTabular(m,n,text1,text2,dp);
        return m+n-lcs;
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

    //minimum insertion and deletion to convert s1 t s2
    //s1 = ABCA
    //s2 = ACDB
    //lcs = AC = length=2
    //total = m+n-2l


    //Longest Palindromic Subsequence
    //reverse the given string and find the common subsequence
    public int longestPalindromeSubseq(String text1) {
        String text2 =  new StringBuilder(text1).reverse().toString();

        int m=text1.length();
        int n=text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                dp[i][j]=-1;
            }
        }
        return lcsUtilLps(m,n,text1,text2,dp);
    }
    private static int lcsUtilLps(int m, int n, String text1, String text2, int[][] dp) {
        if (m==0 || n==0){
            return 0;
        }
        if (dp[m][n] != -1){
            return dp[m][n];
        }
        if(text1.charAt(m-1) ==text2.charAt(n-1)){
            dp[m][n] = 1+lcsUtilLps(m-1,n-1,text1,text2,dp);
            return dp[m][n];
        }else {
            dp[m][n] = Math.max(lcsUtilLps(m,n-1,text1,text2,dp),lcsUtilLps(m-1,n,text1,text2,dp));
            return dp[m][n];
        }
    }

    //minimum number of deletion in a string to make it Palindromic
    //determine the length of longest palindromic subsequence
    //string length - length of longest palindromic subsequence

    //the largest repeating subsequence
    //text = AABEBCDD
    //ABD is repeating 2 times
    static int findLongestRepeatingSubSeq(String str)
    {
        int n = str.length();

        // Create and initialize DP table
        int dp[][] = new int[n+1][n+1];
        for (int i=0; i<=n; i++)
            for (int j=0; j<=n; j++)
                dp[i][j] = 0;

        // Fill dp table (similar to LCS loops)
        for (int i=1; i<=n; i++)
        {
            for (int j=1; j<=n; j++)
            {
                // If characters match and indexes are
                // not same
                if (str.charAt(i-1)== str.charAt(j-1) && i != j)
                    dp[i][j] =  1 + dp[i-1][j-1];

                    // If characters do not match
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }

    //subsequence pattern matching
    //text1 = axy
    //text2 = adxcpy
    //if text1 is a subsequence of text2
    public static boolean subsequenceMatching(String text1, String text2){

        if (lcsTopDownPattern(text1,text2,text1.length(),text2.length())==text1.length()){
            return true;
        }
        return false;
    }
    public static int lcsTopDownPattern(String text1,String text2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<m+1; i++){
            for (int j=1; j<n+1; j++){
                if (text1.charAt(i-1) ==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //Number of Matching Subsequences
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
        for(int i=0; i<words.length; i++){
            if (lcsTopDownPattern(words[i],s,words[i].length(),s.length())==words[i].length()){
                count++;
            }
        }
        return count;
    }

    //minimum number of insertion in a string to make it Palindromic
    //determine the length of longest palindromic subsequence
    //string length - length of longest palindromic subsequence

    //Edit distance
    //
    public int minDistance(String s1, String s2) {
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










}
