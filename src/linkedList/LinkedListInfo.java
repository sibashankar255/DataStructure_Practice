package linkedList;

import java.util.LinkedList;

public class LinkedListInfo {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        node1.next = node2;

        Node node3 = new Node(60);
        node2.next = node3;

        Node node4 = new Node(40);
        node3.next = node4;

        LinkedList list = new LinkedList<>();

        //list.indexOf(9);

        //printLinkedList(insertAtBeginning(node1,1));
        //System.out.println("///////////////////////////////////");
        //printLinkedList(insertAtEnd(node1,50));
        //System.out.println(lengthOfList(node1));

        //Node node = insertAtKthPosition(node1,2,100);
        //printLinkedList(node);

        //printLinkedList(deleteHead(node1));

        //printLinkedList(deleteEnd(node1));

        //printLinkedList(deleteKthNode(node1, 2));

        //System.out.println(searchNode(node1,99));

        System.out.println(checkSorted(node1));

    }

    //print the linkedlist
    public static void printLinkedList(Node temp){
        //Node temp = A;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    //insert value at the beginning
    public static Node insertAtBeginning(Node A, int val){
        Node newNode = new Node(val);
        newNode.next = A;
        return newNode;
    }

    //insert value at the end
    public static Node insertAtEnd(Node A, int val){
        if (A ==null){
            Node newNode = new Node(val);
            return newNode;
        }
        Node temp = A;
        while (temp.next != null){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return A;
    }

    //length of the linked list
    public static int lengthOfList(Node A){
        int count=0;
        Node temp = A;
        while (temp!=null){
            temp = temp.next;
            ++count;
        }
        return count;
    }

    //insert at the kth position of the list
    public static Node insertAtKthPosition(Node A,int k, int val){
        if (k==0){
            return insertAtBeginning(A,val);
        }
        if (k==lengthOfList(A)-1){
            return insertAtEnd(A,val);
        }
        Node temp = A;
        for(int i=1; i<k; i++){
            temp = temp.next;
        }
        Node newNode = new Node(val);
        Node save = temp.next;
        temp.next = newNode;
        newNode.next = save;
        return A;
    }

    //delete the head node
    public static Node deleteHead(Node A){
        A = A.next;
        return A;
    }

    //delete the end node
    public static Node deleteEnd(Node A){
        Node secondLastNode = A;
        Node lastNode = A.next;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next=null;
        return A;
    }

    //delete the kth node
    public static Node deleteKthNode(Node A, int k){
        if (k==0){
            deleteHead(A);
        }
        if (k==lengthOfList(A)-1){
            deleteEnd(A);
        }
        Node currNode = A;
        for (int i=1; i<k; i++){
            currNode = currNode.next;
        }
        Node needToDelete = currNode.next;
        currNode.next = needToDelete.next;
        needToDelete.next=null;
        return A;
    }

    //search the value in the node
    public static String searchNode(Node A, int val){
        if (A==null){
            return "not found";
        }
        int size = lengthOfList(A);

        if (A.data==val){
            return "found";
        }
        for (int i=1; i<size; i++){
            A = A.next;
            if (A.data ==val){
                return "found";
            }
        }
        return "not found";
    }

    //reverse the linked list
    public static Node reverseLinkedList(Node A){
        Node prev = null;
        Node curr = A;
        Node next = curr.next;
        while (curr != null){
            curr.next=prev;
            prev=curr;
            curr= next;
            if (curr!=null){
                next=curr.next;
            }
        }
        return prev;
    }


    //kth element
    public static int kthElement(Node head, int k){
        int size=lengthOfList(head);
        if (head==null || k>size-1){
            return 0;
        }
        if (k==0){
            return head.data;
        }
        for (int i=1; i<=k; i++){
            head = head.next;
            if (i==k){
                return head.data;
            }
        }
        return 0;
    }

    //check sorted linked list
    public static String checkSorted(Node head){
        Node curr = head;
        while (curr != null && curr.next!= null){
            if (curr.data > curr.next.data){
                return "false";
            }
            curr=curr.next;
        }
        return "true";
    }

    //compare 2 linked list
    public static int compare(Node A, Node B){
        int aSize =lengthOfList(A);
        int bSize =lengthOfList(B);
        if (aSize != bSize){
            return 0;
        }
        while (A.next != null){
            Node x=A;
            Node y=B;
            if (x.data != y.data){
                return 0;
            }
            A=A.next;
            B=B.next;
        }
        return 1;
    }


}
