package DailyPractice;

import java.util.*;

public class Arrayss {
    public static void main(String[] args) {
        int[] array = {3,2,1,5,4};
        for (int n : maxMin(array)){
            System.out.println(n);
        }
    }
    //Reverse the array
    public static int[] reverseArray(int[] arr){
        int start =0;
        int end =arr.length-1;

        while (start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =temp;
            start++;
            end--;
        }
        return arr;
    }
    //Find the maximum and minimum element in an array
    public static int[] maxMin(int[] arr){
        int max=arr[0];
        int min=arr[0];
        for (int i=1; i<arr.length; i++){
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        return new int[]{min,max};
    }

    //Find the "Kth" max and min element of an array
//    public static int kthSmallest(int[] arr,int k){
//
//    }

    //Sort Colors
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp = nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                int temp = nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    //First Missing Positive
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int b=1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==b)
            {
                b++;
            }

        }
        return b;
    }

    //Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }

        for (int n : nums2) {
            if (set1.contains(n))
                set2.add(n);
        }

        int [] result = new int[set2.size()];
        int index = 0;
        for (int n : set2){
            result[index++] = n;
        }

        return result;
    }

    //Write a program to cyclically rotate an array by one
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        reverseArray(nums, 0, n-1);
        reverseArray(nums,0, k-1);
        reverseArray(nums,k,n-1);
    }
    public static int[] reverseArray(int[] array,int start,int end){
        int n=array.length;
//        int start=0;
//        int end = n-1;
        while (start<end){
            int temp = array[start];
            array[start]=array[end];
            array[end]=temp;
            start++;
            end--;
        }
        return array;
    }

    //find Largest sum contiguous Subarray [V. IMP]
    public static int subArraySum(int[]  arr){
        int sum=0;
        int maxSum=arr[0];

        for (int i=1; i<arr.length; i++){
            sum=sum+arr[i];
            if (sum>maxSum){
                maxSum=sum;
            }
            if (sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

    //Minimise the maximum difference between heights
    public static int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || n<=0) return -1;
        Arrays.sort(arr);   // 4 7 8 12   k = 3 ==>  1,4 5 9  ==>  9 - 5 =4 ans

        int min = 0,max = 0,res = 0;
        res = arr[n-1] - arr[0];
        for (int i = 1;i<n;++i){
            if (arr[i]>=k){
                max = Math.max(arr[i-1]+k,arr[n-1]-k);
                min   =Math.min(arr[i]-k,arr[0]+k);

                res = Math.min(res,max-min);
            }else {
                continue;
            }
        }
        return res;
    }

    //Jump Game
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the maximum index you can reach to 0
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum reach, return false
            if (i > maxReach) {
                return false;
            }
            // Update the maximum reach if the current index + jump is greater
            maxReach = Math.max(maxReach, i + nums[i]);

            // If the maximum reach is greater than or equal to the last index, return true
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        // If you reach this point, it means you can't reach the end
        return false;
    }

    //Jump Game II
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < n - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    //find duplicate in an array of N+1 Integers
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans=0;
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                ans= nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return ans;
    }

    //Merge 2 sorted arrays without using Extra space.
    public void mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1; // Index for nums1
        int index2 = n - 1; // Index for nums2
        int mergedIndex = m + n - 1; // Index for the merged array

        // Merge the arrays from the end to the beginning
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[mergedIndex] = nums1[index1];
                index1--;
            } else {
                nums1[mergedIndex] = nums2[index2];
                index2--;
            }
            mergedIndex--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (index2 >= 0) {
            nums1[mergedIndex] = nums2[index2];
            index2--;
            mergedIndex--;
        }
    }

    //Kadane's Algo [V.V.V.V.V IMP]

    //Merge Intervals
    public int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1])
                // Overlapping intervals,
                // update the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {
                // Disjoint intervals,
                // add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] mergeInterval2(int[][] intervals) {

        Arrays.sort(intervals, (o1,o2)->Integer.compare(o1[0],o2[0]));          //sort the array on the basis of first interval
        ArrayList<int[]> list = new ArrayList<>();                              //to store the merge intervals
        int start = intervals[0][0];                                            //initialize start and end by the interval of the first row
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){                    //initialize i by 1, zeorth index intervals  already stored in start & end
            int s = intervals[i][0];                             //now store the intervals to compare with the previous one
            int e = intervals[i][1];

            if(s<=end){                                         //Now compare if the start (s) interval is less than the previous end interval then
                end=Math.max(end,e);                            //merge them, means update our end by the greater value of the end interval
            }else{                                              //if not means that interval is not overlapping in the current interval
                list.add(new int[]{start,end});                 //add that previous merged interval into list and update start & end by the current intervals
                start = s;
                end = e;
            }
        }

        list.add(new int[]{start,end});                         //Don't forget to add the last updated interval

        // int[][] res = new int[list.size()][2];               //we have to return the ans int 2D array format, you can do this or can also return directly
        // int i=0;
        // for(int[] ans : list){
        //     res[i] = ans;
        //     i++;
        // }

        return list.toArray(new int[list.size()][2]);            //by using toArray in built function BOTH are correct!
    }

    //Next Permutation
    public void nextPermutation(int[] nums) {
        int idx1 = -1;
        int idx2 = -1;

        for(int i= nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx1=i;
                break;
            }
        }

        if(idx1==-1){
            reverse(nums,0);
        }else{
            for(int i=nums.length-1; i>=0; i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1+1);
        }
    }
    private static void reverse(int[] nums, int start){
        int length = nums.length-1;

        while(start<length){
            swap(nums, start,length);
            start++;
            length--;
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Count Inversions
//    static int inversionCount(int arr[], int N)
//    {
//
//    }

    //Best time to buy and Sell stock
    public static int maxProfit(int[] prices){
        int buy_price =prices[0];
        int max_profit =0;
        for (int i=1; i<prices.length;i++){
            if (prices[i]>buy_price){
                int profit = prices[i]-buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price=prices[i];
            }
        }
        return max_profit;
    }

    //Count pairs with given sum
    public static int getPairsCount(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - arr[i])) {
                count += map.get(k - arr[i]);
            }
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
        return count;
    }

    //find common elements In 3 sorted arrays

    //Rearrange the array in alternating positive and negative items with O(1) extra space

    //Find if there is any subarray with sum equal to k
    //use 2 for loops
    //prefix sum
    //hashmap
    public int subarraySum(int[] nums, int K) {
        int count = 0;
        int sum = 0;
        // Store the cumulative sum and its frequency in a HashMap
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // To consider subarrays starting from index 0

        for (int num : nums) {
            sum += num;
            int diff = sum - K;

            if (sumFrequency.containsKey(diff)) {
                // If a cumulative sum (sum - K) exists in the HashMap,
                // it means there are subarrays with the desired sum
                count += sumFrequency.get(diff);
            }

            // Update the frequency of the current cumulative sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    //Find factorial of a large number


    //find maximum product subarray
    public int maxProduct(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];

        int max = dp[0];
        for(int i = 1; i < n; i++){
            // we are finding the max product so zero will cause the issue
            // anything multiplied by zero is zero, so if previous dp is zero then consider it as 1.
            dp[i] = Math.max(A[i], (dp[i - 1] == 0 ? 1 : dp[i - 1]) * A[i]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

    //Find longest coinsecutive subsequence
    public static int longestConsecutive(int[] nums){
        int longestLength=0;
        Map<Integer,Boolean> map = new HashMap<>();
        for (int num : nums){
            map.put(num,Boolean.FALSE);
        }

        for (int num : nums){
            int currLength=1;

            int nextNum = num+1;
            while (map.containsKey(nextNum) && map.get(nextNum)==false){
                currLength++;
                map.put(nextNum,Boolean.TRUE);
                nextNum++;
            }

            int prevNum=num-1;
            while (map.containsKey(prevNum) && map.get(prevNum)==false){
                currLength++;
                map.put(prevNum,Boolean.TRUE);
                prevNum--;
            }
            longestLength = Math.max(longestLength,currLength);
        }
        return longestLength;
    }

    //Given an array of size n and a number k, fin all elements that appear more than " n/k " times.


    //Maximum profit by buying and selling a share atmost twice


    //Find whether an array is a subset of another array
    static boolean isSubset(int[] arr1, int m, int[] arr2, int n)
    {
        // Create a Frequency Table using STL
        HashMap<Integer, Integer> frequency
                = new HashMap<Integer, Integer>();

        // Increase the frequency of each element
        // in the frequency table.
        for (int i = 0; i < m; i++) {
            frequency.put(arr1[i],
                    frequency.getOrDefault(arr1[i], 0)
                            + 1);
        }
        // Decrease the frequency if the
        // element was found in the frequency
        // table with the frequency more than 0.
        // else return 0 and if loop is
        // completed return 1.
        for (int i = 0; i < n; i++) {
            if (frequency.getOrDefault(arr2[i], 0) > 0)

                frequency.put(arr2[i], frequency.get(arr1[i]) - 1);
            else {
                return false;
            }
        }
        return true;
    }

    //Find the triplet that sum to a given value(three sum)
    public List<List<Integer>> threeSum(int[] num) {
        if (num==null || num.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(num);

        Set<List<Integer>> result = new HashSet<>();

        //fix the first element and find the other 2 elements
        for (int i=0; i<num.length-2; i++){

            if (i>0 && num[i]==num[i-1]){
                continue;
            }

            int left = i+1;
            int right = num.length-1;

            while (left<right){
                int sum= num[i] + num[left] + num[right];

                if (sum==0){
                    result.add(Arrays.asList(num[i],num[left],num[right]));

                    while (left<right && num[left]==num[left+1]){left++;}
                    while (left<right && num[right]==num[right-1]){right--;}

                    left++;
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }

    //Trapping Rain water problem
    public static int trapWater(int[] height){
        int n=height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n-1]=height[n-1];
        for (int i=n-2;i>=0; i--){
            rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }

        int trapWater = 0;
        for (int i=0; i<n; i++){
            int waterLevel =Math.min(leftMax[i],rightMax[i]);
            trapWater += waterLevel-height[i];
        }
        return trapWater;
    }

    //Chocolate Distribution problem


    //Smallest Subarray with sum greater than a given value
    public int minSubArrayLen(int target, int[] nums) {
        int result=Integer.MAX_VALUE;
        int value_sum=0;
        int left=0;

        for (int i=0; i<nums.length; i++){
            value_sum +=nums[i];

            while (value_sum >=target){
                result = Math.min(result, i-left+1);
                value_sum -= nums[left];
                left++;
            }
        }
        return result !=Integer.MAX_VALUE ? result :0;
    }

    //Minimum swaps required bring elements less equal K together

    //Minimum no. of operations required to make an array palindrome


    //Median of 2 sorted arrays
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//    }












}
