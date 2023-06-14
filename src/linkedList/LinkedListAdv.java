package linkedList;

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
    // create a deep copy of this list

}
