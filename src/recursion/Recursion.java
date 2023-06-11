package recursion;

public class Recursion {

    public static void main(String[] args) {
        //printNumb(5);
        //sumOfNaturalNumbers(1,10,0);
        //System.out.println(factorial(5));
        //fibonacci(0,1,5);
        System.out.println(calPower(2,5));
        System.out.println(calPowerDynamic(2,5));

    }

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
