package dynamicProgramming.adityaVerma;

import java.util.Arrays;

public class MCM {

    //MCM
    //printing MCM
    //evaluate expression to true
    //boolean paranthesization
    //min/max value of an expression
    //palindrome partitioning
    //scramble string
    //egg dropping problem

    public static void main(String[] args) {
        String s ="aba";

        System.out.println(palindromePartitioning(s,1,s.length()-1));
    }


    //recursive code
    public static int mcmRec(int[] arr, int i , int j){
        if (i>=j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1; k++){
            int tempAns = mcmRec(arr,i,k)+mcmRec(arr,k+1,j) + arr[i-1]*arr[k]*arr[j];

            if (tempAns<min){
                min=tempAns;
            }
        }
        return min;
    }



    //Memoization code

    public static int mcmMemoGlobal(int arr[]){
        int[][] dp = new int[1001][1001];
        for (int i=1; i<=1001; i++){
            for (int j=1; j<=1001; j++){
                dp[i][j]=-1;
            }
        }
        return mcmMemo(arr,1,arr.length-1,dp);
    }
    public static int mcmMemo(int[] arr, int i, int j, int[][] dp){
        if (i>=j){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j-1; k++){
            int tempAns = mcmMemo(arr,i,k,dp)+mcmMemo(arr,k+1,j,dp) + arr[i-1]*arr[k]*arr[j];

            if (tempAns<min){
                min=tempAns;
            }
        }
        return dp[i][j]=min;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////


    //palindrome partitioning
    public static int palindromePartitioning(String s, int i, int j){
        if (i>=j){
            return 0;
        }
        if (isPalindrome(s,i,j)){
            return 0;
        }


        int min =Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){
            int temp = 1+ palindromePartitioning(s,i,k)+palindromePartitioning(s,k+1,j);

            if (temp<min){
                min=temp;
            }
        }
        return min;
    }

    static boolean isPalindrome(String s, int i, int j){
        if (i==j){
            return true;
        }
        if (i>j){
            return true;
        }
        while (i<j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }




    public static int palindromePartitioningMemo(String s){
        int[][] dp = new int[1001][1001];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return palindromePartitioningMemo(s,1, s.length()-1,dp);
    }
    public static int palindromePartitioningMemo(String s, int i, int j, int[][] dp){
        if (i>=j){
            return 0;
        }
        if (isPalindrome(s,i,j)){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }


        int min =Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){

            int temp = 1+ palindromePartitioningMemo(s,i,k,dp)+palindromePartitioningMemo(s,k+1,j,dp);

            if (temp<min){
                min=temp;
            }
        }
        return dp[i][j]=min;
    }

    public static int palindromePartitioningMemoOptimal(String s, int i, int j, int[][] dp){
        if (i>=j){
            return 0;
        }
        if (isPalindrome(s,i,j)){
            return 0;
        }

        if (dp[i][j] != -1){
            return dp[i][j];
        }

        int min =Integer.MAX_VALUE;
        for (int k=i; k<=j-1; k++){

            int left, right;

            if (dp[i][k] != -1){
                left= dp[i][k];
            }else {
                left = palindromePartitioningMemo(s,i,k,dp);
                dp[i][k]=left;
            }

            if (dp[k+1][j] != -1){
                right= dp[k+1][j];
            }else {
                right = palindromePartitioningMemo(s,k+1,j,dp);
                dp[k+1][j]=right;
            }


            int temp = 1+ left+right;

            if (temp<min){
                min=temp;
            }
        }
        return dp[i][j]=min;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////

    //evaluate expression to true
    //boolean paranthesization





}
