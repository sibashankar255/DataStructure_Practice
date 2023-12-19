package dynamicProgramming.adityaVerma;
import java.util.Arrays;
public class Misc {

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
    }

    //357. Count Numbers with Unique Digits
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){
            return 1;
        }

        int ans=10;
        int availableNumber =9;
        int current=9;

        while(n-->1 ){
            current = current*(availableNumber--);
            ans = ans + current;
        }
        return ans;
    }

    //978. Longest Turbulent SubArray
    public static int maxTurbulenceSize(int[] arr) {
        int increase=1, decrease=1, result=1;

        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[i-1]){
                decrease=increase+1;
                increase=1;
            }else if(arr[i]>arr[i-1]){
                increase = decrease+1;
                decrease=1;
            }else{
                increase=1;
                decrease=1;
            }
            result=Math.max(result, Math.max(decrease,increase));
        }
        return result;
    }

    //1155. Number of Dice Rolls With Target Sum
    /**
     * k -> no of faces of 1 dice
     * n -> no of dice
     * target -> sum of
     */
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return targetMemo(n,k,target,dp);

    }

    private static int targetMemo(int n, int k, int target, int[][] dp){
        if(n<0 || target<0) return 0;
        if(n==0 && target==0) return 1;

        if(dp[n][target] !=-1){
            return dp[n][target];
        }

        int totalWays=0;
        for(int i=1; i<=k; i++){
            if(i<=target){
                totalWays= (totalWays+targetMemo(n-1,k,target-i,dp))% 1000000007;
            }
        }
        dp[n][target] = totalWays;
        return totalWays;
    }

    //1262. Greatest Sum Divisible by Three
    public int maxSumDivThree(int[] nums) {
        int dp1[][] = new int[3][nums.length];
        dp1[nums[0]%3][0] = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int index1 = (nums[i] + dp1[0][i-1])%3;
            int index2 = (nums[i] + dp1[1][i-1])%3;
            int index3 = (nums[i] + dp1[2][i-1])%3;

            dp1[index1][i] = Math.max(dp1[index1][i],dp1[0][i-1] + nums[i]);
            dp1[index2][i] = Math.max(dp1[index2][i],dp1[1][i-1] + nums[i]);
            dp1[index3][i] = Math.max(dp1[index3][i],dp1[2][i-1] + nums[i]);

            dp1[0][i] = Math.max(dp1[0][i-1],dp1[0][i]);
            dp1[1][i] = Math.max(dp1[1][i-1],dp1[1][i]);
            dp1[2][i] = Math.max(dp1[2][i-1],dp1[2][i]);
        }

        return dp1[0][nums.length-1];
    }

    //decode ways

    /**
     * Input: s = "12"
     * Output: 2
     * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
     */
    public int numDecodings(String s) {

        int[] dp = new int[s.length()+1];
        int ans =numDecodings(s,0,dp);
        return ans;
    }
    public static int numDecodings(String s, int index,int[] dp){
        if (s.length()==index){
            return 1;
        }
        if (s.charAt(index)=='0'){
            return 0;
        }
        if (index ==s.length()-1){
            return 1;
        }

        if (dp[index]>0){
            return dp[index];
        }

        int way1= numDecodings(s,index+1,dp);
        int way2=0;
        if (Integer.parseInt(s.substring(index,index+2)) <=26){
            way2=numDecodings(s,index+2,dp);
        }
        dp[index]=way1+way2;
        return way1+way2;
    }


//    public int numSquares(int n) {
//        int[] dp = new int[n+1];
//        dp[0]=0;
//        dp[1]=1;
//
//        for (int i=2; i<=n ;i++){
//            int min=Integer.MAX_VALUE;
//            for (int j=1; j*j<=i;j++){
//                int rem=i-j*j;
//                if(dp[rem]<min){
//                    min=dp[rem];
//                }
//            }
//            dp[i]=min+1;
//        }
//        return dp[n];
//    }

    public int numSquares(int n) {
        int[] dp =new int[n+1];
        return numSquares(n,dp);
    }
    static int numSquares(int n, int[] dp){
        if (n<0){
            return Integer.MAX_VALUE;
        }
        if (n==0){
            return 0;
        }
        if (dp[n]>0){
            return dp[n];
        }
        int min = n;
        for (int i=1; i*i<=n; i++){
            min = Math.min(numSquares(n-(i*i),dp), min);
        }
        dp[n]=min+1;
        return min+1;
    }

}
