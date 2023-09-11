package Heap;

import tree.Pair;
import tree.TreeNode;

import java.util.*;

public class Overview {

    public static void main(String[] args) {
//        int[] a ={-1,5,-6,-6,4,4,1,1,1};
//        int t[] = frequencySort(a);

        int x[] ={5, 17, 100, 11};
        int ans[] = runningMedian(x);

        for (int p:
             ans) {
            System.out.println(p);
        }
    }

    //identification
    //k
    //smallest/ largest
    //

    //Kth smallest Element in an Array
    public int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int size = heap.size();
        for (int i=0; i<size; i++){
            heap.add(nums[i]);
            if (heap.size()>k){
                heap.poll();
            }
        }
        return heap.peek();
    }

    //K largest Elements in array


    // Sort a K Sorted Array
    public static int[] nearlySorted(int[] array, int n, int k) {
        // Write your code here.
        int[] a = new int[array.length];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int size;
        int j=0;
        for (int i=0; i<array.length; i++){
            heap.add(array[i]);
            if (heap.size()>k){
                a[j] = heap.poll();
                j++;
            }
        }
        while(heap.size()>0){
            a[j] = heap.poll();
            j++;
        }
        return a;
    }

    //K Closest Numbers

    // Top K Frequent Numbers
    public int[] topKFrequent(int[] nums, int k) {

        //HashMap<Integer, Integer> hashMap= new HashMap<>();

        var freq = new HashMap<Integer, Integer>();
        var heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(freq.get(a), freq.get(b)));
        var ans = new int[k];
        var i = 0;

        for (var n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        for (var key : freq.keySet()) {
            heap.offer(key);
            if (heap.size() > k)
                heap.poll();
        }
        while (!heap.isEmpty())
            ans[i++] = heap.poll();

        return ans;

    }

    //frequency sort
    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(freq.get(a), freq.get(b)));
        int[] ans = new int[nums.length];

        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        for (int key : freq.keySet()) {
            heap.offer(key);
        }


        int i=0;
        while (!heap.isEmpty()) {
            int a=heap.poll();
            System.out.println(a);
            for (int j=0; j<freq.get(a); j++){
                ans[i++]=a;
            }
        }
        return ans;

    }

    //K Closest Points To Origin
    public int[][] kClosest(int[][] points, int k) {
        //Create a priority queue that compares the second element(distance^2) from small to large
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        //Iterate through the array to calculate the distance^2 and add it to the pq
        for(int i = 0; i < points.length; i++){
            int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            pq.add(new int[] {i,sum});
        }
        //Create a new response array and poll k elements from the queue into the array
        //That will be the k-smallest distance^2, and we don't have to do the square root necessarily
        int[][] res = new int[k][];
        while(k > 0){
            res[k-1] = points[pq.poll()[0]];
            k--;
        }
        return res;
    }

    //connecting ropes
    public static int connectingRopes(int[] arr){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
        }

        int cost=0;

        while (minHeap.size()>1){
            int x = minHeap.poll();
            int y = minHeap.poll();
            cost = cost+x+y;
            minHeap.add(x+y);
        }
        return cost;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static int[] runningMedian(int[] arr) {
        int[] ans = new int[arr.length];

        for (int i=0; i<arr.length; i++){
            insertNum(arr[i]);
            ans[i] = findMedian();
        }
        return ans;
    }

    public static void insertNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek()>num){
            maxHeap.add(num);
        }else {
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() +1) {
            minHeap.add(maxHeap.poll());
        }else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

    }

    public static int findMedian(){
        if (maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2 + minHeap.peek()/2;
        }
        return maxHeap.peek();
    }



}

