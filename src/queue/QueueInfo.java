package queue;

import linkedList.Node;

import java.util.LinkedList;
import java.util.Queue;

class QueueL{
    Node head, tail;
    int cnt;
    QueueL(){
        head=tail=null;
        cnt=0;
    }
    void enqueue(int x){
        Node newNode = new Node(x);
        if (head==null){
            head=tail=newNode;
            cnt++;
            return;
        }
        tail.next=newNode;
        tail=tail.next;
        cnt++;
    }
    void dequeue(){
        if (head==null){
            return;
        }
        head=head.next;
        cnt--;
        if (head==null){
            tail=null;
        }
    }
}

public class QueueInfo {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();



    }

    //FIFO
    //Operations of a queue
    //1.enqueue(x) -> insert x at the rear end
    //2.dequeue() -> delete the element at the front end
    //3.isEmpty() -> checks if the queue is empty
    //4. size() -> return the no of elements in the queue
    //5.front() -> gives the element at the front
    //6. rear() -> gives the element at the rear

    //implement a queue using linked list
    //implement a queue using stack

    

}
