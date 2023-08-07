package recursion;

public class RecursionQues {
    public static void main(String[] args) {
        System.out.println(findAthFibonacci(50));
    }

    //fibonacci number
    public static int[] finbonacciCache;
    public static int findAthFibonacci(int A) {
        finbonacciCache = new int[A+1];
        return finbonacci(A);
    }
    public static int finbonacci(int n){
        if(n==0 || n==1){
            return n;
        }

        if(finbonacciCache[n] !=0){
            return finbonacciCache[n];
        }

        int nthFibonacciNumber = finbonacci(n-2)+finbonacci(n-1);

        finbonacciCache[n]=nthFibonacciNumber;

        return nthFibonacciNumber;
    }

    //factorial number
    public static int factorial(int n){
        if(n==1){
            return n;
        }
        return factorial(n-1)*n;
    }

    public static boolean checkPalindrome(String str, int low, int high){
        if (low>=high){
            return true;
        }


        return str.charAt(low)==str.charAt(high) ? checkPalindrome(str,low+1,high-1) : false;
    }
}
