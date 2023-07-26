package BitManipulation;

public class Bit {
    public static void main(String[] args) {
        int[] a={1,1,2,5,2,3,3,4};
        for (int i:twoRemaining(a)) {
            System.out.println(i);
        }
    }

    public static int[] twoRemaining(int[] arr){
        int res =arr[0];
        for (int i=1; i<arr.length;i++){
            res=res^arr[i];
        }
        int temp1=res;
        for (int i=0; i<arr.length;i++){
            if ((arr[i] &1) ==1){
                temp1=temp1^arr[i];
            }
        }

        int[] arr2=new int[2];
        arr2[0]=temp1;
        arr2[1]=res^temp1;
        return arr2;
    }

    //2's complement
    //inverse all bits
    //add one

    //left shift operator
    //(number>>1) == number/2


    //right shift operator
    //(number<<1) == number*2


    //masking
    //if (number&1)==0 -> even
    //if (number&1)==1 -> odd

    //swapping
    // a=5 , b=7
    // a=a^b;
    // b=a^b;
    // a=a^b;


    //Bit masking
    //find ith bit
    //n->   1 0 0 1 1 0 1 0 1
    //mask->0 0 0 1 0 0 0 0 0
    //mask = 1<<ith times
    //find ith bit = n & mask -> 0 or 1


    //set ith bit
    //n->   1 0 0 1 1 0 1 0 1
    //mask->0 0 0 1 0 0 0 0 0
    //mask = 1<<ith times
    //set ith bit = n | mask


    //clear ith bit
    //n->   1 0 0 1 1 0 1 0 1
    //1<<i->0 0 0 1 0 0 0 0 0
    //mask->1 1 1 0 1 1 1 1 1
    //mask=~(1<<i)
    //res = n & mask

    //find number of bits to change to convert a to b

    //no of digits in a number(n)
    // do the & operation n&(n-1) till its 0




}
