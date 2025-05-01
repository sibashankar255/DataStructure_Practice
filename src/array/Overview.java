package array;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Overview {

    public static void main(String[] args) {
        int[] arr = {3,7,2,5,8,4,6,1};
        System.out.println(longestConsecutive(arr));

    }

    /**
     * take one boolean variable as false
     * traverse all elements and check if ith element is greater than the next element
     * if first time it found then change the variable to true
     * if found for the next time then return false
     * to check the last element with first element use (i+1)%n to check the rotated one
     */
    public static boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (rotated) {
                    return false;
                }
                rotated = true;
            } else if (nums[i] == nums[(i + 1) % n]) {
                continue;
            }
        }

        return true;
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // If the array is empty, there are no unique elements.
        }

        int k = 1; // Initialize a count to track unique elements.

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i]; // Replace the k-th element with the i-th element (a new unique element).
                k++; // Increment the count of unique elements.
            }
        }

        return k; // Return k, which represents the number of unique elements in the modified array.
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k=k%n;
        reverse(nums, 0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k,n-1);
    }
    public int[] reverse(int[] A, int s, int e){
        int k=0;
        while(s<e){
            k=A[s];
            A[s]=A[e];
            A[e]=k;
            s++;
            e--;
        }
        return A;
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int num:nums){
            if(num != 0){
                nums[i] = num;
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }

    //Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums){
            queue.add(i);
        }

        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }


        int curr = queue.poll();
        int count=1;
        return 0;
//        while (!queue.isEmpty()){
//            if (queue.poll() ==curr+1){
//                count++;
//            }else {
//
//            }
//
//        }
    }
}

