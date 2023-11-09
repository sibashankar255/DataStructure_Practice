package DailyPractice;

import java.util.Arrays;
import java.util.*;

public class Oct31 {
    public static void main(String[] args) {

        int[] arr = {7,8,9,11,12};

        System.out.println(firstMissingPositive(arr));

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


    //Find the maximum and minimum element in an array

    //Find the "Kth" max and min element of an array
    //sort the array and check the kth element
    //use priority queue to solve the problem

    //Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo
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

    //Move all the negative elements to one side of the array
    public static int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int b=1;
        for(int i=0;i<n;i++) {
            if(nums[i]==b) {
                b++;
            }
        }
        return b;
    }

    //Find the Union and Intersection of the two sorted arrays.
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

    public int[] intersect(int[] nums1, int[] nums2) {
        // Sort both the arrays first...
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // Create an array list...
        ArrayList<Integer> arr = new ArrayList<Integer>();
        // Use two pointers i and j for the two arrays and initialize both with zero.
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            // If nums1[i] is less than nums2[j]...
            // Leave the smaller element and go to next(greater) element in nums1...
            if(nums1[i] < nums2[j]) {
                i++;
            }
            // If nums1[i] is greater than nums2[j]...
            // Go to next(greater) element in nums2 array...
            else if(nums1[i] > nums2[j]){
                j++;
            }
            // If both the elements intersected...
            // Add this element to arr & increment both i and j.
            else{
                arr.add(nums1[i]);
                i++;
                j++;
            }
        }
        // Create a output list to store the output...
        int[] output = new int[arr.size()];
        int k = 0;
        while(k < arr.size()){
            output[k] = arr.get(k);
            k++;
        }
        return output;
    }


    //find Largest sum contiguous Sub-array
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum=0;
        int max_sum=nums[0];
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum>max_sum){
                max_sum=sum;
            }
            if(sum<0){
                sum=0;
            }
        }

        return max_sum;
    }

    //Minimise the maximum difference between heights
    // min value will increase by k
    // max value will decrease by k
    public static int getMinDiff(int[] arr, int n, int k) {
        if (arr == null || n<=0) return -1;
        Arrays.sort(arr);   // 4 7 8 12   k = 3 ==>  1,4 5 9  ==>  9 - 5 =4 ans

        int ans = arr[n-1]-arr[0];
        int mina=0,maxa=0;
        int low = arr[0]+k;
        int high = arr[n-1]-k;

        for(int i=0;i<n;i++){
            if(arr[i]>=k){
                mina = Math.min(arr[i]-k,low);
                maxa = Math.max(arr[i-1]+k,high);
                ans = Math.min(ans,maxa-mina);
            }
        }
        return ans;
    }

    //


}
