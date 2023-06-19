package linkedList;

public class LinkedListAdv1 {
    public static void printLinkedList(Node temp){
        //Node temp = A;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
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


        Node node11 = new Node(11);
        Node node22 = new Node(2);
        node11.next = node22;
        Node node33 = new Node(33);
        node22.next = node33;
        Node node44 = new Node(4);
        node33.next = node44;
        Node node55 = new Node(55);
        node44.next = node55;

        //System.out.println(slowFastPointer(node1).data);

        //printLinkedList(mergeLinkedList(node1,node11));

        printLinkedList(mergeSortNode(node11));

    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //find the middle element of the linked list
    //head 3 -> 18 -> 5 -> 6 -> 2 -> 19 -> null

    //traverse through the linked list and find its size-> n
    //got for the node at position n/2 (i.e (n/2-1) steps infornt of the head )
    //T.C -> O(n)

    //fast and slow pointer approach
    //fast pointer -> two nodes forward at a time
    //slow pointer -> one nodes forward at a time
    //T.C -> O(n)
    //S.C -> O(1)
    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////

    //merge two sorted linked list into a single linked list
    //head 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
    //head 11 -> 22 -> 33 -> 44 -> 55 -> 66 -> null
    public static Node mergeLinkedList(Node h1, Node h2){
        if (h1 ==null){
            return h2;
        }
        if (h2==null){
            return h1;
        }
        Node head=null, p1=null, p2=null;
        if (h1.data <h2.data){
            head = h1;
            p1 = h1.next;
            p2=h2;
        }else {
            head=h2;
            p1=h1;
            p2=h2.next;
        }
        Node temp = head;
        while (p1 != null && p2!=null){
            if (p1.data <= p2.data){
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

    /////////////////////////////////////////////////////////////////////////////////////////
    //sort the given linked list using merge sort
    //head 10 -> 2 -> 30 -> 4 -> 50 -> 6 -> null
    //T.C -> O(n logn)
    //S.C -> O(log n)
    public static Node mergeSortNode(Node head){
        if (head==null || head.next==null){
            return head;
        }
        Node mid = findMiddle(head);
        Node head2 = mid.next;
        mid.next =null;
        head  = mergeSortNode(head);
        head2 = mergeSortNode(head2);

        return mergeLinkedList(head, head2);
    }
}
