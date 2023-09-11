package Striver.array;

import java.util.*;

public class Hard {
    public static void main(String[] args) {

    }

    //Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascel = new ArrayList<>();
        for (int i=1; i<=numRows; i++){
            pascel.add(generateRow(i));
        }
        return pascel;
    }
    public static List<Integer> generateRow(int row){
        int ans=1;
        List<Integer> list = new ArrayList<>();
        list.add(ans);
        for (int col=1; col<row; col++){
            ans = ans*(row-col);
            ans = ans/col;
            list.add(ans);
        }
        return list;
    }

    //Majority Element II (n/3 times)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int num1=-1,num2=-1,count1=0,count2=0,len=nums.length;

        for (int i=0; i<len; i++){
            if (nums[i]==num1){
                count1++;
            } else if (nums[i]==num2) {
                count2++;
            } else if (count1==0) {
                num1=nums[i];
                count1=1;
            } else if (count2==0) {
                num2=nums[i];
                count2=1;
            }else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for (int i=0; i<len; i++){
            if (nums[i]==num1){
                count1++;
            } else if (nums[i]==num2) {
                count2++;
            }
        }

        if (count1>len/3){
            ans.add(num1);
        }
        if (count2>len/3){
            ans.add(num2);
        }
        return ans;
    }

    //3Sum
    public List<List<Integer>> threeSum(int[] num) {
        if (num==null || num.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(num);

        Set<List<Integer>> result = new HashSet<>();

        //fix the first element and find the other 2 elements
        for (int i=0; i<num.length-2; i++){
            int left = i+1;
            int right = num.length-1;

            while (left<right){
                int sum= num[i] + num[left] +num[right];
                if (sum==0){
                    result.add(Arrays.asList(num[i],num[left],num[right]));
                    left++;
                    right++;
                }else if(sum<0){
                    left++;
                }else {
                    right++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> three(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        for (int i=0; i<num.length; i++){
            if (i>0 && num[i]==num[i-1]){
                continue;
            }
            int j=i+1;
            int k=num.length-1;
            while (j<k){
                int sum=num[i]+num[j]+num[k];
                if (sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else {
                    ans.add(Arrays.asList(num[i], num[j], num[k]));

                    while (j<k && num[j]==num[j+1]){j++;}
                    while (j<k && num[k]==num[k-1]){k--;}

                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
    //4Sum
    //brute force approach -> take 4 loops and get the target O(n^4)
    //2 pointer -> O(n^3)
    //hashmap ->
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n<4){
            return ans;
        }

        Arrays.sort(nums);
        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }
        return ans;

    }

    //Largest Subarray with 0 Sum
    int maxLen(int A[], int n) {
        // Your code here
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for(int i = 0;i<n;i++) {
            sum += A[i];
            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(ans.get(sum) != null) {
                    maxi = Math.max(maxi, i - ans.get(sum));
                }
                else {
                    ans.put(sum, i);
                }
            }
        }
        return maxi;
    }

    //Subarray with given XOR



    //Merge Intervals
    public int[][] merge(int[][] intervals) {
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

    //Merge Sorted Array
    public void merge(int[] A, int n, int[] B, int m) {
        int[] mergedArray = new int[n+m];
        int p1=0;
        int p2=0;
        int k=0;
        while (p1<n && p2<m){
            if (A[p1]<=B[p2]){
                mergedArray[k]=A[p1];
                p1++;
            }else {
                mergedArray[k]=B[p2];
                p2++;
            }
            k++;
        }
        while (p1<n){
            mergedArray[k]=A[p1];
            k++;p1++;
        }
        while (p2<m){
            mergedArray[k]=B[p2];
            k++;p2++;
        }

    }

    //Find the repeating and missing numbers
    public int repeatingNumber(int[] nums){
        int missing = missingNumber(nums);
        int sum=0;
        for (int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        int total = sum+missing;
        int n=nums.length;
        int totalSum = n*(n+1)/2;

        return total-totalSum;
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0;
        int xor2 = 0;
        for(int i=1; i<n; i++){
            xor1= xor1^i;
        }
        for(int i=0; i<n; i++){
            xor2= xor2^nums[i];
        }

        xor1=xor1^n;

        return xor1^xor2;

    }

    //Count inversions in an array

    //Reverse Pairs

    //Maximum Product Subarray
    public int maxProduct(int[] A) {
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
