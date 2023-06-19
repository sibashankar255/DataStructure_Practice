package linkedList;

public class CircularLinkedList {
    public static void main(String[] args) {

    }

    //check if the given linked list has a cycle
    public static boolean checkCircularList(Node head){
        Node s =head,f=head;
        while (f.next !=null && f.next.next !=null){
            f=f.next.next;
            s=s.next;
            if (s==f){
                return true;
            }
        }
        return false;
    }

    //given a linked list with a cycle, find the start of the cycle
    //floyd's cycle detection method

}
