package hashing;
import java.util.*;
public class Hashing {
    //insert add - O(1)
    //search Contains - O(1)
    //Delete Remove - O(1)

    public static void main(String[] args) {

        //creating
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        //search
        if (set.contains(1)){
            System.out.println("set contains 1");
        }
        if (!set.contains(6)){
            System.out.println("set does not contain 6");
        }

        //size
        System.out.println("size of set "+ set.size());

        //print
        System.out.println(set);

        //iterator
        Iterator iterator = set.iterator();
        //hasNext; -> will return true or false
        // next; -> will return the value

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //delete
        set.remove(1);
        if (!set.contains(1)){
            System.out.println("does not contains 1");
        }

    }

}
