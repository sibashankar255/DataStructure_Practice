package DailyPractice.twoPointer;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Vector;
import java.util.stream.IntStream;

class Base extends Exception{}
class Derived extends Base{}

class MyVector extends Vector{
    int i=1;
    public MyVector(){
        i=20;
    }
}

class MyNewVector extends MyClass{
    public MyNewVector(){
        i=4;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        IntStream stream = Arrays.stream(arr);
        stream.map(e -> e+10).filter(e -> e%2==0).forEach(e -> System.out.println(e));
    }
}



public class Child extends Parent{
//    public void method() throws Exception{
//        System.out.println("child class");
//    }

    static int doStuff(String[] args){
        return Integer.parseInt(args[0]);
    }

    public static void main(String[] args) throws IOException {

//        HashSet<String> set = new HashSet<>();
//        set.add("apple");
//        set.add("mango");
//        set.add("apple");
//        set.add("applemango");
//
//        System.out.println(set);


//        PriorityQueue toDo = new PriorityQueue<>();
//        toDo.add("dishes");
//        toDo.add("laundry");
//        toDo.add("bills");
//        toDo.offer("bills");
//        System.out.println(toDo.size()+" "+toDo.poll());
//        System.out.println(" "+toDo.peek()+toDo.poll());
//        System.out.println(" "+toDo.poll()+toDo.poll());


//        try {
//            System.out.println(doStuff(args));
//        }catch (Exception e){
//            System.out.println("exe");
//        }
//        doStuff(args);










//        Parent obj= new Child();
//        obj.method();

//        String s1 ="abc";
//        String s2 =s1;
//        s1+="d";
//        System.out.println(s1+" "+s2+" "+(s1==s2));
//        StringBuffer sb1 = new StringBuffer("abc");
//        StringBuffer sb2 = sb1;
//
//        sb1.append("d");
//        System.out.println(sb1+" "+sb2+" "+(sb1==sb2));

//        try{
//            throw new Derived();
//        }catch (Base b){
//            System.out.println("caught base class exception");
//        }catch (Derived d){
//            System.out.println("caught derived class exception");
//        }

    }
}
