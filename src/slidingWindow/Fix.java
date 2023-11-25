package slidingWindow;

import java.util.*;

public class Fix {


    //Maximum Sum Subarray of size K
    public static int maxSum(int arr[], int n, int k)
    {
        // k must be smaller than n
        if (n < k) {
            return -1;
        }

        // Compute sum of first window of size k
        int res = 0;
        for (int i=0; i<k; i++)
            res += arr[i];

        // Compute sums of remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.
        int curr_sum = res;
        for (int i=k; i<n; i++)
        {
            curr_sum += arr[i] - arr[i-k];
            res = Math.max(res, curr_sum);
        }
        return res;
    }



    //max of all subarray of size k
    public int[] maxSlidingWindow(int[] A, int B) {
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[A.length-B+1];

        int i=0;
        for (;i<B; i++){
            priorityQueue.add(A[i]);
        }

        int k=1;
        res[0] = priorityQueue.peek();

        priorityQueue.remove(A[0]);

        for (; i<A.length; i++){
            priorityQueue.add(A[i]);
            res[k]=priorityQueue.peek();
            k++;
            priorityQueue.remove(A[i-B+1]);
        }

        return res;
    }


    //Sliding Window Maximum
    public int[] maxSlidingWindowDqueue(int[] nums, int k) {
        Deque<Integer> qi = new ArrayDeque<>();
        int i;
        int n = nums.length;

        for (i=0; i<k; i++){
            while (!qi.isEmpty() && nums[i]>nums[qi.peekLast()]){
                qi.removeLast();
            }
            qi.addLast(i);
        }

        int j=0;
        int[] res = new int[nums.length-k+1];

        for (; i<n;i++){
            res[j]=nums[qi.peek()];
            j++;

            while ((!qi.isEmpty()) && qi.peek() <=i-k){
                qi.removeFirst();
            }

            while ((!qi.isEmpty()) && nums[i]>=nums[qi.peekLast()]){
                qi.removeLast();
            }

            qi.addLast(i);
        }
        res[j]=nums[qi.peek()];
        return res;
    }

    //First Negative Number in every Window of Size K


}
