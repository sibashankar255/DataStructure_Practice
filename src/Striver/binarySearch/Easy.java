package Striver.binarySearch;

import java.util.ArrayList;

public class Easy {
    public static void main(String[] args) {
        int[] arr ={1,2,1,3,5,6,4};

//        System.out.println(findPeakElement(arr));


    }

    //Binary Search
    public int search(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;

        while (start<=end){
            int mid = start+(end-start)/2;

            if (nums[mid]==target){
                return mid;
            } else if (nums[mid]<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return -1;
    }


    //Search Insert Position
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;

        while (start<=end){
            int mid = start+(end-start)/2;

            if (nums[mid]==target){
                return mid;
            } else if (nums[mid]<target) {
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return start;
    }

    //Floor/Ceil in Sorted Array
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }
    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    //Find First and Last Position of Element in Sorted Array
    public int[] searchRange(int[] nums, int target) {
        int[] arr={-1,-1};

        arr[0]=findInd(nums,target,true);
        arr[1]=findInd(nums,target,false);

        return arr;
    }
    public int findInd(int[] nums,int target,boolean flag)
    {
        int left=0;
        int right=nums.length-1;
        int i=-1;

        while(left<=right)
        {
            int mid=(left+right)/2;

            if(nums[mid]>target)
            {
                right=mid-1;
            }else if(nums[mid]<target)
            {
                left=mid+1;
            }else if(nums[mid]==target)
            {
                i=mid;
                if(flag){
                    right=mid-1;;
                }else{
                    left=mid+1;
                }
            }
        }

        return i;
    }

    //Count Occurrences in Sorted Array

    //Search in Rotated Sorted Array
    public int searchRotated(int[] nums, int target) {
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

    //Search in Rotated Sorted Array II



    //Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
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

    //Find out how many times the array has been rotated



    //Find Peak Element
    public static int findPeakElement(ArrayList<Integer> arr) {
        int n = arr.size(); // Size of array

        // Edge cases:
        if (n == 1) return 0;
        if (arr.get(0) > arr.get(1)) return 0;
        if (arr.get(n - 1) > arr.get(n - 2)) return n - 1;

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;

            // If arr[mid] is the peak:
            if (arr.get(mid - 1) < arr.get(mid) && arr.get(mid) > arr.get(mid + 1))
                return mid;

            // If we are in the left:
            if (arr.get(mid) > arr.get(mid - 1)) low = mid + 1;

                // If we are in the right:
                // Or, arr[mid] is a common point:
            else high = mid - 1;
        }
        // Dummy return statement
        return -1;
    }

    //Koko Eating Bananas
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);

        //apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);
            if (totalH <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }


    //Kth Missing Positive Number
    public int findKthPositive(int[] arr, int k) {
        return k;
    }

    //Painter's partition



}
