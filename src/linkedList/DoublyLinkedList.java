package linkedList;
class DoubleNode{
    int data;
    DoubleNode next;
    DoubleNode prev;
    public DoubleNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
//starting at any node in a DLL, we can travel the entire list
public class DoublyLinkedList {
    public static void main(String[] args) {
        DoubleNode node1 = new DoubleNode(10);
        DoubleNode node2= new DoubleNode(20);
        node2.prev=node1;
        node1.next=node2;
        DoubleNode node3 = new DoubleNode(30);
        node3.prev=node2;
        node2.next=node3;
        DoubleNode node4= new DoubleNode(40);
        node3.next=node4;
        node4.prev=node3;
        printList(node1);
        printList(deleteNode(node1,20));
    }
    public static void printList(DoubleNode head) {
        DoubleNode current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }


    //delete the first occurrence of x in a DLL. if not present , do nothing
    public static DoubleNode deleteNode(DoubleNode head, int x){
        DoubleNode temp = head;
        while (temp !=null){
            if (temp.data ==x){
                break;
            }
            temp=temp.next;
        }
        if (temp==null){
            return head;
        }
        if (temp.prev ==null && temp.next==null){
            return null;
        }
        if (temp.prev==null){
            temp.next.prev=null;
            return temp.next;
        }
        if (temp.next==null){
            temp.prev.next=null;
            return head;
        }
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        return head;
    }

    //given a running stream of integers and a fixed memory size m(any data structure of size m).
    //For every integer intake, the memory should have the most recent m items.
    //LRU -> Least Recently Used
    //10 15 19 20 18 23 20 19 17 17 10
    //m=5




}
