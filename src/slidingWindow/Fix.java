package slidingWindow;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class Fix {



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


}
