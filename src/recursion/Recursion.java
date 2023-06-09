package recursion;

import java.util.HashSet;

public class Recursion {

    public static void main(String[] args) {
        //printNumb(5);
        //sumOfNaturalNumbers(1,10,0);
        //System.out.println(factorial(5));
        //fibonacci(0,1,5);
        //System.out.println(calPower(2,5));
        //System.out.println(calPowerDynamic(2,5));

        //String str ="abcd efgh ijkl";
        //printRev(str, str.length()-1);

        //int arr[] = {1,3,3};
        //System.out.println(isSorted(arr,0));

        //String str = "axbcxxd";
        //moveAllX(str,0,0,"");

        //String str = "abbccda";
        //removeDuplicates(str,0, "");

        //String str = "abc";
        //HashSet<String> set = new HashSet<>();
        //subsequence(str,0,set);

        //String str= "abc";
        //printPermutation(str,"");

        //System.out.println(countPaths(0,0,3,3));
        //System.out.println(placeTiles(4,2));

        System.out.println(callGuests(4));
    }

    //print all the subsets of a set of first n natural numbers




    //place Tiles of size 1*m in a floor of size n*m
    public static int placeTiles(int n, int m){
        if (n==m){
            return 2;
        }
        if (n<m){
            return 1;
        }
        int vertPlacements = placeTiles(n-m, m);
        int horPlacements = placeTiles(n-1, m);

        return vertPlacements+horPlacements;
    }


    //find the number if ways in which you can invite n people to your party,single or in pairs
    public static int callGuests(int n){

        if (n<=1){
            return 1;
        }
        //single
        int ways1 = callGuests(n-1);

        //pair
        int ways2 = (n-1)* callGuests(n-2);

        return ways1+ways2;
    }
    //count total paths in a maze to move from (0,0) to (n,m)
    public static int countPaths(int i, int j, int n, int m){
        if (i==n || j==m){
            return 0;
        }
        if (i==n-1 && j==m-1){
            return 1;
        }

        //move down
        int downPaths  = countPaths(i+1, j, n, m);

        //move right
        int rightPaths = countPaths(i,j+1,n,m);

        return downPaths+rightPaths;

    }


    //print all permutations of a string
    //"abc" -> abc, acb, bac, bca, cab, cba
    public static void printPermutation(String str, String permutation){

        if (str.length()==0){
            System.out.println(permutation);
            return;
        }

        for (int i=0; i<str.length(); i++){
            char currChar = str.charAt(i);
            //"abc" -> "ab"
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPermutation(newStr,permutation+currChar);
        }
    }



    //print all the unique subsequence of a string



    //print all subsequences of a string
    public static void subsequence(String str, int idx, String newString){
        if (idx==str.length()){
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        subsequence(str, idx+1, newString+currChar);

        subsequence(str, idx+1, newString);
    }

    //remove duplicates in a string
    //"abbccda" -> "abcd"
    public  static boolean[] map = new boolean[26];
    public static void removeDuplicates(String str, int idx, String newString){
        if (idx==str.length()){
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if (map[currChar-'a']){
            removeDuplicates(str,idx+1, newString);
        }else {
            newString += currChar;
            map[currChar -'a']=true;
            removeDuplicates(str, idx+1, newString);
        }
    }



    //move all 'x' to the end of the string
    //"axbcxxd" -> "abcdxxx"
    public static void moveAllX(String str, int idx, int count, String newString){
        if (idx==str.length()){
            for (int i=0; i<count; i++){
                newString+='x';
            }
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        if (currChar=='x'){
            count++;
            moveAllX(str,idx+1, count,newString);
        }else {
            newString += currChar; // newString = newString + currChar
            moveAllX(str,idx+1,count,newString);
        }
    }


    //check if an array is sorted (Strictly increasing)
    public static boolean isSorted(int arr[], int idx){
        if (idx==arr.length-1){
            return true;
        }
        if (arr[idx] >= arr[idx+1]) {
            //array is sorted till now
            return isSorted(arr,idx+1);
        }else {
            return false;
        }

    }


    //find the first and last occurance of the string
    public static int first =-1;
    public static int last =-1;
    public static void findOccurance(String str, int idx, char element){

        if (idx==str.length()){
            System.out.println(first);
            System.out.println(last);
        }
        char currChar = str.charAt(idx);
        if (currChar==element){
            if (first==-1){
                first=idx;
            }else {
                last=idx;
            }
        }
        findOccurance(str,idx+1, element);
    }

    //print the reverse of the string
     public static void printRev(String str, int idx){
        if (idx==0) {
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        printRev(str,idx-1);
     }

     //
    public static int calPowerDynamic(int x, int n){
        if(n==0){
            return 1;
        }
        if (x==0){
            return 0;
        }
        if (n%2==0){ //if n is even
            return calPowerDynamic(x,n/2) * calPowerDynamic(x, n/2);
        }else { // if n is odd
            return calPowerDynamic(x,n/2) * calPowerDynamic(x, n/2) * x;
        }
    }


    public static int calPower(int x,int n){
        if(n==0){
            return 1;
        }
        if (x==0){
            return 0;
        }
        int xPow1 = calPower(x, n-1);
        int xPow = x * xPow1;
        return xPow;

    }

    public static void fibonacci(int a, int b,int n){
        if (n==0)
            return;
        int c =a+b;
        System.out.println(c);
        fibonacci(b, c, n-1);
    }

    public static int factorial(int n){
        if (n==1 || n==0){
            return 1;
        }

        int factorialOfNM1 = factorial(n-1);
        int factorialOfN = n* factorialOfNM1;
        return factorialOfN;
    }

    public static void sumOfNaturalNumbers(int i,int n, int sum){
        if (i>n){
            //sum+=i;
            System.out.println(sum);
            return;
        }
        sum +=i;
        sumOfNaturalNumbers(i+1, n, sum);
    }

    public static void printNumb(int n){
        if(n==0)
            return;
        printNumb(n-1);
        System.out.println(n);

    }
}
