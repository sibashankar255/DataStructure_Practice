package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class HashBasic {

    public static void main(String[] args) {

//        //create Hashmap
//        HashMap<String, Integer> hashMap = new HashMap<>();
//
//        //insert
//        hashMap.put("india", 100);
//        hashMap.put("china", 150);
//        hashMap.put("us", 50);
//        hashMap.put("nepal",10);
//        System.out.println(hashMap);
//
//        //hashmap is an unordered ds
//
//        //get
//        int popu =hashMap.get("india");
//        System.out.println(popu);
//
//        //containsKey
//        System.out.println(hashMap.containsKey("india"));//true
//        System.out.println(hashMap.containsKey("indo"));//false
//
//        //remove
//        System.out.println(hashMap.remove("nepal"));
//        System.out.println(hashMap);
//
//        //size
//        System.out.println(hashMap.size());
//
//        //IsEmpty
//        System.out.println(hashMap.isEmpty());
//
//
//        //Set iterate
//        Set<String> keys = hashMap.keySet();
//        System.out.println(keys);
//        for (String k: keys) {
//            System.out.println(k+" "+hashMap.get(k));
//        }

//        int[] A ={1,3,2,3,1,3,1,3,1};
//        majorityElement(A);

        //HastSet
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.contains(1);
        set.remove(1);


        //linkedHashSet
        //ordered using double linked list

        //TreeSet
        //sorted in ascending order
        //null value not allowed




    }

    //majority element
    //given an integer array of size n, fina all elements that appears more than n/3 times
    //A ={1,3,2,5,1,3,1,5,1}
    public static void majorityElement(int[] A){
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i=0 ; i<A.length; i++){
            if (hashMap.containsKey(A[i])){
                hashMap.put(A[i], hashMap.get(A[i])+1);
            }else {
                hashMap.put(A[i],1);
            }
        }
        Set<Integer> keySet = hashMap.keySet();
        for(Integer keys : keySet){
            if (hashMap.get(keys) > A.length/3){
                System.out.println(keys);
            }
        }
    }

    //valid anagram
    public static boolean anagram(String string1, String string2){
        if (string1.length()!=string2.length()){
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i=0 ; i<string1.length(); i++){
            char ch = string1.charAt(i);
            if (hashMap.containsKey(ch)){
                hashMap.put(ch, hashMap.get(ch)+1);
            }else {
                hashMap.put(ch,1);
            }
        }

        for (int i=0; i<string2.length();i++){
            char ch = string2.charAt(i);
            if (hashMap.get(ch) != null){
                if (hashMap.get(ch)==1){
                    hashMap.remove(ch);
                }else {
                    hashMap.put(ch, hashMap.get(ch)-1);
                }
            }else {
                return false;
            }
        }
        return hashMap.isEmpty();

    }

    //union & intersection of 2 arrays
    //arr1 ={7,3,9}
    //arr2 ={6,3,9,2,9,4}

    public  static void unionIntersection(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();

        //union
        for (int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for (int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println("union: "+set.size());

        //intersection
        set.clear();
        for (int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int count=0;
        for (int i=0; i<arr2.length; i++){
            if (set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println("intersection: "+count);
    }

    //find Itinerary from tickets


    //largest subarray sum with zero sum







}