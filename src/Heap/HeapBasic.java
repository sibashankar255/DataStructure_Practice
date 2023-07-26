package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapBasic {
    public static PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    public static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public static void main(String[] args) {
        // Create a PriorityQueue with Integer elements and a custom comparator
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Adding elements
        pq.offer(5);
        pq.offer(2);
        pq.offer(8);

        // Retrieve the maximum element
//        int maxElement = pq.peek();
//        System.out.println("Maximum element: " + maxElement);
//
        int[] A={1, 2, 5, 4, 3};
        int[]  B={5, 17, 100, 11};

        for (int i: streamMedian(B)) {
            System.out.println(i);
        }

    }

    //given n ropes with lengths. cost of connecting 2 ropes is equal to sum of lengths of both.
    //find the min cost to connect all ropes
    //->maintained a sorted array for all the steps -> T.CO(n^2)
    //->use DS that supports
    //        ->insert()
    //        ->getMin()
    //        ->removeMin()
    // heap/priority queue

    //2 types of heaps
    //min heap - getMin()
    //max heap - getMax()
    public int connectRopes(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int cost = 0;

        while (minHeap.size() > 1) {
            int x = minHeap.poll();
            int y = minHeap.poll();
            cost += x + y;
            minHeap.add(x + y);
        }

        return cost;
    }


    //Heap(Binary heap)
    //1.structurally heap is a complete binary tree
    //2.types
    //   Min heap-> for every node.data <= the children's data(root has the smallest value)
    //   Max heap-> fir every node.data >= the children's data(root has the largest value)
    //3.no relation between left and right subtree


    //complete binary tree
    // A[i]
    //left child = A[2i+1]
    //right child=A[2i+2]
    //parent= A[(i-1)/2]

    //Heapify-> maintain the properties of heap after any modification


    //insert(x) -> T.C -> O(log n)
    //A.add(x);
    //i = A.size()-1;
    // A[i] < A[(i-1)/2] -> condition of swap
    //while(i>0 && A[i] < A[(i-1)/2]){
    // swap (A[i], A[(i-1)/2]);
    //i=(i-1)/2;
    // }

    //getMin() [minHeap]
    //return the value of A[0].(root) -> T.C-> O(1)


    //removeMin() [minHeap]
    //

    //Building Heap
    //1. insert all elements one by one ->T.C O(n log n)
    //2. sort elements and create the heap -> T.C O(n log n)
    //3. crate a heap and arrange


    //count the no. of ways to create a maxheap using n distinct elements
    //ways = (n-1)C(l) * ways(l) * ways(n-1-l)
    //h=height(in terms of no of edges)
    //total no of nodes upto 2nd last level = 2^h -1
    //no of nodes in the last level = n-(2^h -1) = n-2^h+1
    //no of ways in the left subtree of the root

    //Heap Sort -> TC->O(n log n) , SC->O(n)
    //sort n elements using a heap -> T.C -> O(n)
    //read the root(min) and delete it. do this step until heap is empty -> O(n logn)
    //A = {7 3 5 1 5 6 8 2 4}
    //


    //given an integer array with n elements and an integer k. in the array, every element is ay max k
    // distance away from its position in sorted array . sort the array
    //A = {3 1 5 6 2 4}, k=3
    // sort it using merge sort/heap sort -> TC O(n log n)
    // insertion sort -> TC O(n*k)

    //given n elements, find the kth smallest element
    //sort -> TC O(n log n)
    //min heap -> store all elements -> O(n) or o(n log n)
    //         -> delete (k-1) time -> O(k log n)
    //         -> peek -> O(1)
    public static int findKthSmallest(int arr[], int n, int k){ //TC O(n log k) //SC O(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i=0; i<k; i++){
            pq.add(arr[i]);
        }
        for (int i=k; i<n; i++){
            pq.add(arr[i]);
            pq.poll();
        }
        return pq.poll();
    }

    //given a running stream of integers, find the median at every step
    // A = {3 8 2 5 10} -> median {2 3 5 8 10}
    // B = {3 8 2 5 10 1} -> median {1 2 3 5 8 10}
    // IP -> 9  8  15  20  22  17  12  5  1  3 ......
    // OP -> 9 8.5  9  12  15  16  15

    public static void insertNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek()>=num){
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }

//        if (maxHeap.size() >minHeap.size()+1){
//            minHeap.add(maxHeap.poll());
//        }else {
//            maxHeap.add(minHeap.poll());
//        }
        balancingHeaps();


    }

    public static void balancingHeaps(){
        if(maxHeap.size() - minHeap.size() > 1) minHeap.offer(maxHeap.poll());
        else if(minHeap.size() - maxHeap.size() > 1) maxHeap.offer(minHeap.poll());

    }
    public static int findMedian(){
        if (maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2 + minHeap.peek()/2;
        }
        return maxHeap.peek();
    }
    public static int[] streamMedian(int[] arr){
        int[] ans = new int[arr.length];

        for (int i=0; i<arr.length; i++){
            insertNum(arr[i]);
            ans[i] = findMedian();
        }
        return ans;
    }







}