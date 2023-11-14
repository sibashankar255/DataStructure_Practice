package DailyPractice.linkedList;


import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Overview {
    public static void main(String[] args) {

    }
    //Write a Program to reverse the Linked List. (Both Iterative and recursive)
    public static ListNode reverseList(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr!= null){
            curr.next = prev;
            prev = curr;
            curr=next;
            if (curr!=null){
                next=curr.next;
            }
        }
        return prev;
    }

    //Reverse a Linked List in group of Given Size. [Very Imp]
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1 ){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy, next = dummy, pre =dummy;

        int count =0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }

        while(count >=k){
            curr = pre.next;
            next = curr.next;
            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = pre.next;
                pre.next =next;
                next = curr.next;
            }
            pre=curr;
            count-=k;
        }
        return dummy.next;
    }

    //Reverse Linked List II
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
    //Write a program to Detect loop in a linked list.
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    //Write a program to Delete loop in a linked list.
    public static Node detect(Node head){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast=fast.next.next;
            if (slow==fast){
                return slow;
            }
        }
        return null;
    }
    public static Node detectFirstNodeRemove(Node head){
        Node meet = detect(head);
        Node meetPrev =meet;
        Node start =head;
        while (start != meet){
            start = start.next;
            meetPrev=meet;
            meet = meet.next;
        }
        meetPrev.next=null;
        return head;
    }

    //Find the starting point of the loop
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast == null || fast.next == null) return null;
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    //Remove Duplicates in a sorted Linked List.
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list = head;

        while(list != null) {
            if (list.next == null) {
                break;
            }
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }
    //Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates2(ListNode head) {
        // Special case...
        if (head == null || head.next == null)
            return head;
        // create a fake node that acts like a fake head of list pointing to the original head and it points to the original head......
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode curr = fake;
        // Loop till curr.next and curr.next.next not null
        while(curr.next != null && curr.next.next != null){         // curr.next means the next node of curr pointer and curr.next.next means the next of next of curr pointer...
            // if the value of curr.next and curr.next.next is same...
            // There is a duplicate value present in the list...
            if(curr.next.val == curr.next.next.val) {
                int duplicate = curr.next.val;
                // If the next node of curr is not null and its value is eual to the duplicate value...
                while(curr.next !=null && curr.next.val == duplicate) {
                    // Skip those element and keep updating curr...
                    curr.next = curr.next.next;
                }
            }
            // Otherwise, move curr forward...
            else{
                curr = curr.next;
            }
        }
        return fake.next;       // Return the linked list...
    }

    //Write a Program to Move the last element to Front in a Linked List.
    public void reorderList(ListNode head) {
        //find middle element
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the second half of the list starting from the middle
        ListNode prev = null;
        while(slow != null)
        {
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        //Merge two halves
        ListNode p1 = head;
        ListNode p2 = prev;
        while(p1 != null){
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p1.next =p2;
            p2.next = next1;
            p1=next1;
            p2=next2;
        }
    }

    //Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        int lenA = lengthOfList(A);
        int lenB = lengthOfList(B);
        while (lenA>lenB){
            lenA--;
            A= A.next;
        }
        while (lenB>lenA){
            lenB--;
            B=B.next;
        }
        while (A != B){
            A=A.next;
            B=B.next;
        }
        return A;
    }
    public static int lengthOfList(ListNode A){
        int count=1;
        ListNode temp = A;
        while (temp.next!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    //merge two sorted linked list into a single linked list
    //head 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
    //head 11 -> 22 -> 33 -> 44 -> 55 -> 66 -> null
    public static ListNode mergeLinkedList(ListNode h1, ListNode h2){
        if (h1 ==null){
            return h2;
        }
        if (h2==null){
            return h1;
        }
        ListNode head=null, p1=null, p2=null;
        if (h1.val <h2.val){
            head = h1;
            p1 = h1.next;
            p2=h2;
        }else {
            head=h2;
            p1=h1;
            p2=h2.next;
        }
        ListNode temp = head;
        while (p1 != null && p2!=null){
            if (p1.val <= p2.val){
                temp.next = p1;
                temp=p1;
                p1=p1.next;
            }else {
                temp.next = p2;
                temp = p2;
                p2= p2.next;
            }
        }
        if (p1 ==null){
            temp.next=p2;
        }else {
            temp.next=p1;
        }
        return head;
    }

    public static ListNode mergeSortNode(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode head2 = mid.next;
        mid.next =null;
        head  = mergeSortNode(head);
        head2 = mergeSortNode(head2);

        return mergeLinkedList(head, head2);
    }
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    //Palindrome Linked List
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }

        int length = 0;
        ListNode p = head;
        while(p != null) {
            length ++;
            p = p.next;
        }
        p = head;
        if(length == 1) {
            return true;
        }

        int half = (length + 1) / 2;
        ListNode q = head;
        for(int i = 0; i < half; i ++) {
            q = q.next;
        }

        ListNode r = q.next;
        q.next = null;
        ListNode m;
        while(r != null) {
            m = r.next;
            r.next = q;
            q = r;
            r = m;
        }

        while(q != null && p != null) {
            if(p.val == q.val) {
                q = q.next;
                p = p.next;
            }else {
                return false;
            }

        }
        return true;

        // Stack<ListNode> reverse = new Stack<ListNode>(); // F-I-L-O
        // ListNode dummy = head; // we use head for forward traversing and dummy to store in stack
        // while(dummy != null){
        //     reverse.push(dummy);
        //     dummy = dummy.next;
        // }
        // while(head !=null && !reverse.isEmpty()){
        //     // if value in head doesnt match stack val: return false
        //     if(reverse.pop().val != head.val) return false;
        //     // if value matches then move head to next el
        //     else{
        //         head = head.next;
        //     }
        // }
        // return true;
    }

    //Partition List
    public ListNode partition(ListNode head, int B) {
        if (head == null || head.next == null) {
            return head;
        }

        // Create two separate lists for nodes less than B and nodes greater than or equal to B
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);
        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        ListNode current = head;

        while (current != null) {
            if (current.val < B) {
                lessTail.next = current;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = current;
                greaterTail = greaterTail.next;
            }
            current = current.next;
        }

        // Connect the two lists
        lessTail.next = greaterHead.next;
        greaterTail.next = null;

        return lessHead.next;
    }

    //Swap Nodes in Pairs
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode point = dummy;

        while (point.next !=null && point.next.next!=null){
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            swap1.next = swap2.next;
            swap2.next= swap1;

            point.next = swap2;
            point =swap1;
        }
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

    // Copy List with Random Pointer
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and map original nodes to copied nodes
        Map<Node, Node> nodeMap = new HashMap<>();
        Node current = head;
        while (current != null) {
            nodeMap.put(current, new Node(current.val));
            current = current.next;
        }

        // Step 2: Set the next and random pointers of copied nodes
        current = head;
        while (current != null) {
            Node copiedRandomListNode = nodeMap.get(current);
            copiedRandomListNode.next = nodeMap.get(current.next);
            copiedRandomListNode.random = nodeMap.get(current.random);
            current = current.next;
        }

        // Step 3: Return the head of the copied list
        return nodeMap.get(head);
    }

    //Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy =new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode curr = head;
        while(curr != null){
            if(curr.val==val){
                prev.next=curr.next;
            }else{
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    //Add Two Numbers
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry=0;

        while (l1 != null || l2 != null){
            int sum=0+carry;

            if (l1!=null){
                sum = sum+l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                sum=sum+l2.val;
                l2=l2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ptr.next =new ListNode(sum);
            ptr=ptr.next;
        }
        if (carry==1){
            ptr.next=new ListNode(1);
        }
        return result.next;
    }

    //Merge K sorted linked lists
    public ListNode mergeKLists(ListNode[] A) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.val)
        );

        // Add head pointers to the min heap
        for (ListNode head : A) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                minHeap.add(node.next);
            }
        }

        return dummy.next;
    }





}
