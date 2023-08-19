package array;

import java.util.HashSet;
import java.util.Set;

public class Subsequence {
    public static void main(String[] args) {

    }

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

    //Longest Palindromic Subsequence
    //reverse the given string and find the common subsequence

    //minimum insertion and deletion to convert s1 t s2
    //s1 = ABCA
    //s2 = ACDB
    //lcs = AC = length=2
    //total = m+n-2l

    //length of supersequence of s1 and s2
    //s1 = ABCA
    //s2 = ACDB
    //super sequence = ABCADB
    //lcs = AC = length =2
    //total = m+n-l

    //longest repeating subsequence
    //s1 = AAPDRCDBBT
    //s2 = string
    //s1.charAt(i-1)==s2.charAt(j-1) && i!=j



    //Longest Palindromic Substring
    public static String longestPalindrome(String s) {

        int start=0,end=0;
        for (int i=0; i<s.length(); i++){
            int len1=expandFromCenter(s,i,i+1);
            int len2=expandFromCenter(s,i,i);
            int len = Math.max(len1,len2);
            if(end-start<len){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int expandFromCenter(String s, int i, int j) {
        while (i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        Set<Character> seen = new HashSet<>();
        int max=0;
        while (right<s.length()){
            char c = s.charAt(right);
            if (seen.add(c)){
                max = Math.max(right-left+1,max);
                right++;
            }else {
                while (s.charAt(left) != c){
                    seen.remove(s.charAt(left));
                    left++;
                }
                seen.remove(c);
                left++;
            }
        }
        return max;
    }


}
