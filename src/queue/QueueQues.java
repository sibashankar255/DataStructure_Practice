package queue;

import java.util.*;
public class QueueQues {
    public static void main(String[] args) {
//        int[] frequency = new int[26];
//        for (int i = 0; i < frequency.length; i++) {
//            System.out.println(frequency[i]);
//        }

//        int[]  A = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] B = slidingWindow(A,3);
//        for (int i=0; i<B.length; i++){
//            System.out.println(B[i]);
//        }

//        int[] A = {1,2,3,4,5};
//        Queue<Integer> queue = reverseQueue(A, 3);
//        for (int element : queue) {
//            System.out.println(element+" ");
//        }


    }

    //First non-repeating character
    public static String processStream(String A) {
        StringBuilder B = new StringBuilder();
        int[] frequency = new int[26];
        Queue<Character> queue = new LinkedList<>();

        for (char c : A.toCharArray()) {
            frequency[c - 'a']++; // Increase the frequency of the current character

            // Add the current character to the queue
            queue.offer(c);

            // Process the queue until a non-repeating character is found
            while (!queue.isEmpty() && frequency[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                B.append(queue.peek()); // Append the first non-repeating character to B
            } else {
                B.append('#'); // Append '#' if no non-repeating character is found
            }
        }
        return B.toString();
    }


    //sliding window maximum
    public static int[] slidingWindow(int[] A, int B){
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[A.length];

        int i;
        for (i=0; i<B; i++){
            while (!deque.isEmpty() && A[i] >= A[deque.peekLast()]){
                deque.removeLast();
                deque.addLast(i);
            }
        }
        for (; i<A.length; ++i){
            res[i] = A[deque.peek()];

            while( (!deque.isEmpty()) && deque.peek()<=i-B ){

                deque.removeFirst();

                while( (!deque.isEmpty()) && A[i]>=A[deque.peekLast()]){
                    deque.removeLast();

                    deque.addLast(i);
                }
            }
        }
        res[i] =A[deque.peek()];
        return res;
    }

    //Reversing the first K elements of a Queue
    public static Queue<Integer> reverseQueue(int[] A, int B){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            queue.offer(A[i]);
        }

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<B; i++){
            stack.push(queue.remove());
        }
        int y=stack.size();


        for (int i=0; i<B; i++){
            queue.add(stack.pop());
        }

        for (int i=0; i<A.length-y; i++){
            queue.add(queue.remove());
        }


        return queue;


    }

}
