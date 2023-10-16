package leetcode150;

public class array {


    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));
    }

    //Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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


    public static int removeDuplicates(int[] nums) {
        int k = 0; // Initialize a count to track unique elements.

        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[i] > nums[k - 2]) {
                nums[k] = nums[i]; // Replace the k-th element with the i-th element (a new unique element).
                k++; // Increment the count of unique elements.
            }
        }

        return k; // Return k, which represents the number of unique elements in the modified array.
    }


    public static boolean canJump(int[] nums) {
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

    public static int jump(int[] nums) {
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

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }




}
