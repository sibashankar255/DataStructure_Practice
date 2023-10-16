package leetcode150;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {

//        int[] nums = {3,2,1,5,6,4};
//        int k = 2;
//        System.out.println(findKthLargest(nums,k));
//
//        int[][] numbers = {{1,3},{-2,2}};
//        int[][] num = {{3,3},{5,-1},{-2,4}};
//
//        System.out.println(kClosest(num,2));

        int[][] arr ={{1,5,9},{10,11,13},{12,13,15}};
        System.out.println(kthSmallest(arr,8));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int size;
        for (int i=0; i<nums.length; i++){
            heap.add(nums[i]);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    //LC #973 - K closest points to origin
    public static int[][] kClosest(int[][] points, int K) {
        if(K == points.length) return points;

        PriorityQueue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            }
        });

        for(int[] point: points) {
            pq.add(point);
            if(pq.size() > K) pq.poll();
        }
        return pq.toArray(new int[0][0]);
    }

    //347. Top K Frequent Elements
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(freq.get(a), freq.get(b)));

        int[] ans = new int[k];
        int i = 0;

        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);


        for (int key : freq.keySet()) {
            heap.offer(key);
            if (heap.size() > k) heap.poll();
        }
        while (!heap.isEmpty())
            ans[i++] = heap.poll();

        return ans;
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = matrix.length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(pq.size() < k){
                    pq.add(matrix[i][j]);
                }else{ //equal to k
                    if(matrix[i][j] < pq.peek()){ //if incoming element is less than peek
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }

        return pq.peek();
    }

    //295. Find Median from Data Stream




}
