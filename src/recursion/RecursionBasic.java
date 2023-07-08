package recursion;

public class RecursionBasic {
    public static void main(String[] args) {
        //print(5);
        //System.out.println(factorial(5));
        //System.out.println(sumNatural(10000));
        //System.out.println(fibonacci(20));
//        int[] a ={1,2,3,4,5};
//        System.out.println(isSorted(a,0));

        System.out.println(tilingProb(5));
    }

    public static void print(int x){
        if (x==1){
            System.out.println(1);
            return;
        }
        print(x-1);
        System.out.println(x);
    }

    public static int factorial(int n){
        if (n==0){
            return 1;
        }
        int fact = n * factorial(n-1) ;
        return fact;
    }

    public static int sumNatural(int n){
        if(n==1){
            return 1;
        }
        int sum = n+ sumNatural(n-1);
        return sum;
    }

    public static int fibonacci(int n){
        if (n==0 || n==1){
             return n;
        }
        int f = fibonacci(n-2)+fibonacci(n-1);
        return f;
    }

    //check if the array is sorted or not
    public static boolean isSorted(int[] arr, int i){
        if (i==arr.length){
            return true;
        }
        if (arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    //first occurence of an element in an array
    public static int firstOccr(int[] arr, int key, int i){
        if (i==arr.length){
            return -1;
        }
        if (arr[i]==key){
            return i;
        }
        return firstOccr(arr,key,i+1);
    }

    //find the last occurence of an element in an array
    public static int lastOccr(int[] arr, int key, int i){
        if (i==arr.length){
            return -1;
        }
        int isFound = lastOccr(arr, key, i+1);

        if (isFound != -1 && arr[i]==key){
            return i;
        }

        return isFound;
    }

    public static int pow(int x, int n){
        if (n==0){
            return 1;
        }
        int p = x * pow(x, n-1);
        return p;
    }

    public static int optimizedPow(int x, int n){
        if (n==0){
            return 1;
        }
        int halfP = optimizedPow(x, n/2) ;

        int halfPow = halfP* halfP;

        //if n odd
        if (n%2!=0){
            halfPow = n * halfPow;
        }
        return halfPow;
    }

    //tiling problem
    //given 2*n floor and tiles of size 2*1, count the number of ways to tile
    // the given board using the 2*1 tiles.
    public static int tilingProb(int n){

        if (n==0 || n==1){
            return 1;
        }

        int horizontal = tilingProb(n-1);
        int vertical = tilingProb(n-2);

        int towWays = horizontal+vertical;

        return towWays;
    }

    //remove duplicates in a string
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){
        if (idx ==str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if (map[currChar-'a']==true){
            //duplicate
            removeDuplicates(str,idx+1, newStr, map);
        }else {
            map[currChar-'a'] =true;
            removeDuplicates(str,idx+1,newStr.append(currChar),map);
        }
    }

    //friend pairing problem
    //given n friends, each one can remain single or can be paired up with some other friend.
    //each friend can be paired only once. find the total no of ways in which friend can
    //remain single or can be paired up

    //binary string problem
    //print all binary strings of size n without consecutive ones





}
