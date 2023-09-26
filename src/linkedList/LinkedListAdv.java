package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListAdv {
    public static void main(String[] args) {
        Node node1 = new Node(10);

        Node node2 = new Node(20);
        node1.next = node2;

        Node node3 = new Node(30);
        node2.next = node3;

        Node node4 = new Node(40);
        node3.next = node4;

        Node node5 = new Node(50);
        node4.next = node5;

        Node node6 = new Node(60);
        node5.next = node6;

        Node node=null;

        //System.out.println(accessKthElement(node,2));
        //System.out.println(checkTheElement(node1,0));
        //printLinkedList(node1);
        //printLinkedList(deleteTheElement(node1,30));
        printLinkedList(reverseList(node1));
    }


    //print the linkedlist
    public static void printLinkedList(Node temp){
        //Node temp = A;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static int accessKthElement(Node head, int k){
        Node temp = head;
        if (temp==null){
            return 0;
        }
        for (int i =1; i<k; i++){
            temp = temp.next;
        }

        return temp.data;
    }

    public static boolean checkTheElement(Node head, int x){
        Node temp = head;

        while (temp != null){
            if (temp.data==x){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    //insert a node with data x at kth position
    //time complexity -> O(n)
    //space complexity -> O(1)
    public static Node insertKthPosition(Node A, int x, int k){

        Node newNode = new Node(x);

        //if A is null
        if (A==null){
            return newNode;
        }

        //at the beginning
        if (k==0){
            newNode.next = A;
            return newNode;
        }

        //at the end
        if (lengthOfList(A)==k) {
            Node temp = A;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return A;
        }

        //at kth position
        Node temp = A;
        for (int i=1; i<k; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return A;

    }



    //delete the first occurrence of Node with data x
    public static Node deleteTheElement(Node A, int x){
        //if A is null
        if (A==null){
            return null;
        }

        //if A
        if (A.data==x){
            return A.next;
        }

        Node prev = A;
        Node currNode = A.next;
        while (currNode.next != null){
            if (currNode.data==x){
                prev.next = currNode.next;
                return A;
            }
            prev = currNode;
            currNode = currNode.next;
        }
        return A;
    }


    //length of linked list
    public static int lengthOfList(Node A){
        int count=1;
        Node temp = A;
        while (temp.next!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }


    //reverse linked list(not by updating data)
    //head 3 -> 18 -> 5 -> 6 -> 2 -> 19 -> null

    //null   <- 3   <- 18   <- 5   <- 6   <- 2   <- 19  head
    //prev1   curr1  next1
    //        prev2  curr2  next2
    //               prev3  curr3  next3
    //                      prev4  curr4  next4
    //                             prev5  curr5  curr5
    //                                    prev6  curr6  next6
    //T.C -> O(n)
    //S.C -> O(1)
    public static Node reverseList(Node head){
        Node prev =null;
        Node curr = head;
        Node next = curr.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr !=null){
                next = curr.next;
            }
        }
        return prev;
    }


    //given a linked list where every node has a random pointer along with next pointer.
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and map original nodes to copied nodes
        Map<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode current = head;
        while (current != null) {
            nodeMap.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        // Step 2: Set the next and random pointers of copied nodes
        current = head;
        while (current != null) {
            RandomListNode copiedRandomListNode = nodeMap.get(current);
            copiedRandomListNode.next = nodeMap.get(current.next);
            copiedRandomListNode.random = nodeMap.get(current.random);
            current = current.next;
        }

        // Step 3: Return the head of the copied list
        return nodeMap.get(head);
    }
    // create a deep copy of this list



    // Reverse Linked List II
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // create a dummy node to mark the head of this list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // make markers for currentNode and for the node before reversing
        ListNode leftPre = dummy;
        ListNode currNode = head;

        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        // make a marker to node where we start reversing
        ListNode subListHead = currNode;

        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        // Join the pieces
        leftPre.next = preNode;
        subListHead.next = currNode;

        return dummy.next;
    }



    //Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move the second pointer B nodes ahead
        for (int i = 1; i <= n + 1; i++) {
            if (second == null) {
                return head.next;
            }
            second = second.next;
        }

        // Move the first and second pointers simultaneously until the second pointer reaches the end
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        // Remove the Bth node from the end
        first.next = first.next.next;

        return dummy.next;
    }


    //Remove Duplicates from Sorted List
    public ListNode deleteDuplicates(ListNode A) {
        ListNode prev = A;
        ListNode temp = prev.next;

        while(temp != null){
            if(temp.val ==prev.val){
                temp=temp.next;
                continue;
            }
            //prev.next=temp;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return A;
    }



}
