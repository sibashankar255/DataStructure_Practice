package linkedList;

public class LInkedListAdv2 {
    public static void main(String[] args) {
        //1 -> 2 -> 1 -> 1 -> 1 -> 2 -> 3 -> 2 -> null
        Node node1 = new Node(1);

        Node node2 = new Node(2);
        node1.next = node2;

        Node node3 = new Node(2);
        node2.next = node3;



        //printLinkedList(reverseList(node1));

//        Node node5 = new Node(1);
//        node4.next = node5;

        System.out.println(palindrome(node1));

//        Node node6 = new Node(2);
//        node5.next = node6;
//
//        Node node7 = new Node(3);
//        node6.next = node7;
//
//        Node node8 = new Node(2);
//        node7.next = node8;



        //System.out.println(longestPalindrome(node1));

    }

    //check if the given linked list is a palindrome
    // 12 -> 16 -> 16 -> 12
    // 1 -> 2 -> 1 -> 2
    //palindrome -> left half of LL = reverse of right half of LL
    //find middle of LL
    //reverse 2nd half of LL
    //compare both LL
    //T.C -> O(n)

    public static int palindrome(Node head){
        int length=lengthOfList(head);
        if (length==1 || head==null){
            return 1;
        }

        Node secondHalf = reverseList(findMiddle(head).next);
        Node firstHalf = head;

        while (secondHalf.next !=null && firstHalf.next!=null){
            if(firstHalf.data != secondHalf.data){
                return 0;
            }else {
                firstHalf=firstHalf.next;
                secondHalf=secondHalf.next;
            }
        }
        return 1;
    }

    public static void printLinkedList(Node temp){
        //Node temp = A;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static int lengthOfList(Node A){
        int count=1;
        Node temp = A;
        while (temp.next!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public static Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
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



    //find the length of longest odd length palindromic length in the given linked list
    //1 -> 2 -> 1 -> 1 -> 1 -> 2 -> 3 -> 2 -> null
    //S.C -> O(1)
    public static int longestPalindrome(Node head){
        int ans =0;
        Node prev = null;
        Node curr =head;
        while (curr != null){
            Node next = curr.next;
            int count = countNodes(prev,next);
            ans = Math.max(ans, 2*count+1);
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return ans;
    }
    public static int countNodes(Node prev, Node next){
        int count =0;
        Node x = prev;
        Node y= next;

        while (x != null && y != null){
            if ( x.data != y.data){
                break;
            }
            count++;
            x=x.next;
            y=y.next;
        }
        return count;
    }



}
