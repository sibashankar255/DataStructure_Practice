package DailyPractice.dynamicProg;

import java.util.*;
public class LIS {

    public static void main(String[] args) {

        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }


    public static int lengthOfLIS(int[] arr) {
        int n= arr.length;

        //take a dp array to store, how many previous elements smaller than arr[i]
        int[] dp = new int[n];

        int overall_max=0;

        for (int i=0; i<n; i++){
            //at every element need to check the maximum how many elements smaller than itself
            //initialize max
            int max=0;
            //check how many elements(0 to i) smaller than arr[i], running another loop
            for (int j=0; j<i; j++){
                if (arr[j]<arr[i]){
                    //if arr[i] is greater than arr[j] then check if dp[j] > max and update it
                    if (dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            //if no element is smaller than this element then update it with 1
            dp[i] = max+1;

            //overall maximum subsequence
            overall_max = Math.max(dp[i],overall_max);
        }

        return overall_max;
    }

    public static int lengthOfLIS1(int[] nums) {
        int n = nums.length;

        // Initialize an array to store the length of LIS ending at each index
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);  // Initialize LIS values to 1

        // Dynamic Programming: Calculate LIS for each index
        //we will move the i pointer from 0 to n-1 and check how many previous elements are smaller than itself
        //move the j pointer from 0 to i everytime i++
        //if(arr[j] < arr[i]) => length of LIS at i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if the current element can be added to the LIS ending at index j
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);  // Update LIS[i] if a longer sequence is found
                }
            }
        }

        // Find the maximum LIS value in the array
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            ans = Math.max(ans, LIS[i]);
//        }

        int largest = Arrays.stream(LIS).max().getAsInt();

        return largest;  // Return the length of the longest increasing subsequence
    }



    //russian envelope
    //
    public int maxEnvelopes(int[][] envelopes) {
        // Sort envelopes based on widths in ascending order and heights in descending order
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // Find the LIS based on heights
        int n = envelopes.length;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);

        int result=1;

        //width -> 0
        //height-> 1
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] ) {
                    lis[i] = Math.max(lis[i],lis[j] + 1);
                }
                result = Math.max(result,lis[i]);
            }
        }

        // Find the maximum value in the LIS array
//        int maxLIS = 0;
//        for (int length : lis) {
//            maxLIS = Math.max(maxLIS, length);
//        }

        return result;
    }
}
