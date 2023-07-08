package linkedList;

import java.util.List;

public class LinkedList1 {

    public static void printLinkedList(Node temp){
        //Node temp = A;
        while (temp != null){
            System.out.println(temp.data);
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



        printLinkedList(reorderList(node1));
        //printLinkedList(reorderList());


    }


    //given a linked list where every node has a random pointer along with next pointer.
    // create a deep copy of this list

    //Remove Nth Node from List End
    //fast and slow pointer



    //detect cycle and remove cycle
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

    //Swap List Nodes in pairs
    public static ListNode swapNode(ListNode head){
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

    //reorder list
    //find the middle & break the list into two
    //reverse the second one
    //merge the 2 lists
    public static Node reorderList(Node head) {
        Node l1= head;
        Node slow = head;
        Node fast = head;

        while (fast.next!= null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node l2 = slow.next;
        slow.next = null;

        return l2;
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode head = l1;
        while(l1 !=null){
            ListNode l1_next = l1.next;
            ListNode l2_next = l2.next;

            l1.next=l2;

            if(l1_next ==null){
                break;
            }
            l2.next=l1_next;
            l1=l1_next;
            l2=l2_next;
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode prev =null;
        ListNode curr_node=head;
        while (curr_node != null){
            ListNode next_node = curr_node.next;
            curr_node.next=prev;
            prev=curr_node;
            curr_node=next_node;
        }
        return prev;
    }

    public static ListNode addList(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry=0;

        while (l1!=null || l2!=null){
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
        return result;
    }


}
