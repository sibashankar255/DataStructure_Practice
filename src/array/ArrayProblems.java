package array;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class ArrayProblems {
    public static void main(String[] args) {
        int arr[] = { 1000, 11, 445, 1, 330, 3000,6 };
        //System.out.println(minMaxDiff(arr));

//        for (int a : reverse(arr)){
//            System.out.println(a);
//        }
        int arr1[] = {1,2, 3,3,5};
//        for (int a : repeatMissing(arr1)){
//            System.out.println(a);
//        }

        //System.out.println(kthLargestElement(arr,2));

        int arr2[] ={4,2,0,3,2,5};
        System.out.println(trapWater(arr2));
    }

    //1.minimum and maximum elements of an array
    public static int minMaxDiff(int[] arr){
        int n =arr.length;
        int max=arr[0];
        int min=arr[0];

        for (int i=1; i<n; i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }

        return max-min;
    }

    //2.reverse an array
    public static int[] reverse(int[] arr){
        int n=arr.length-1;
        int start =0;
        int end = n;
        while (start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;

            start++;
            end--;
        }
        return arr;
    }

    //3. maximum subarray

    //4. contains duplicate
    public static boolean duplicate(int[] arr){
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i=0; i<arr.length; i++){
            if (hashSet.contains(arr[i])){
                return true;
            }
            hashSet.add(arr[i]);
        }
        return false;
    }

    //5.Chocolate Distribution Problem -> subset, sorting

    //6.Search in Rotated Sorted Array
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // Target element found at index mid
            }
            if (nums[left] <= nums[mid]) {
                // Left half is sorted in ascending order
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Continue searching in the left half
                } else {
                    left = mid + 1; // Continue searching in the right half
                }
            } else {
                // Right half is sorted in ascending order
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Continue searching in the right half
                } else {
                    right = mid - 1; // Continue searching in the left half
                }
            }
        }
        return -1; // Target element not found in the array
    }

    //7.Next Permutation


    //8.Best time to Buy and Sell Stock
    //prices = [7,1,5,3,6,4]
    public static int buySellStocks(int[] prices){
        int buy_price =prices[0];
        int max_profit =0; 
        for (int i=1; i<prices.length;i++){
            if (buy_price<prices[i]){
                int profit = prices[i]-buy_price;
                max_profit = Math.max(max_profit,profit);
            }else {
                buy_price=prices[i];
            }
        }
        return max_profit;
    }


    //9.Repeat and Missing Number Array
    public static int[] repeatMissing(final int[] arr){
        int n = arr.length;
        int[] repeatMissing = new int[2];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i=0; i<arr.length; i++){
            if (hashSet.contains(arr[i])){
                repeatMissing[0] = arr[i];
            }
            hashSet.add(arr[i]);
        }

        long expected_sum = (long) (n*(n+1))/2;
        long actual_sum = 0;
        for (int i=0; i<n; i++){
            actual_sum = actual_sum+arr[i];
        }
        actual_sum =actual_sum-repeatMissing[0];

        repeatMissing[1] =(int) (expected_sum-actual_sum);

        return repeatMissing;
    }

    //10.Kth-Largest Element in an Array
    public static int kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<arr.length;i++){
            pq.add(arr[i]);
        }

        for (int i=0; i<k-1;i++){
            pq.remove();
        }
        return pq.peek();
    }

    //11.Trapping Rain Water
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

    //12.Product of Array Except Self
    //nums = [1,2,3,4]
    public static int[] productExceptSelf(int[] nums){
        int n= nums.length;

        int[] pre = new int[n];
        pre[0] = 1;
        for (int i=1; i<n; i++){
            pre[i] = pre[i-1] * nums[i];
        }

        int[] suff = new int[n];
        suff[n-1]=1;
        for (int i=n-2; i>=0; i--){
            suff[i]= suff[i+1] * nums[i+1];
        }

        int[] product = new int[n];
        for (int i=0; i<n; i++){
            product[i] = pre[i]*suff[i];
        }

        return product;
    }

    //13.Find Minimum in Rotated Sorted Array
    public static int miniSortedArray(int[] nums){
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            final int m = (l + r) / 2;
            if (nums[m] < nums[r])
                r = m;
            else
                l = m + 1;
        }

        return nums[l];
    }

    //14.Find Pair with Sum in Sorted & Rotated Array

    //15.3 sum

    //16.Container With Most Water

    //17.Kth - Smallest Element

    //18.Merge Overlapping Intervals

    //all subarray, subset, subsequences problems
    //two pointer
    //2D roblems
    //prefix sum
    //carry forward
    //sliding window

    //bit manipulation
    //hashing
    //recursion








}
