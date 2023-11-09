package sorting;

public class Overview {
    public static void main(String[] args) {
        /*
        Sorting:-
1.Bubble sort O(n^2), O(1)
2.Selection sort O(n^2), O(1)
3.Insertion sort O(n^2), O(1)
4.Merge sort O(nlogn), O(n)
5.Quick sort O(nlogn), O(logn)
6.Radix sort O(kn), O(n)
7.Heap sort O(nlogn), O(1)

         */

        int array[] = {13,46,24,52,20,9};
        int[] a = insertionSort(array);
        for (int x : a){
            System.out.println(x);
        }
    }
    public static int[] bubbleSort(int[] arr){

        for (int i=1; i<arr.length; i++){
            for (int j=0; j<arr.length-1; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j] =temp;
                }
            }
        }
        return arr;
    }
    public static int[] insertionSort(int[] arr){

        for (int i=1; i<arr.length; i++){
            int j=i;
            while (j>0 && arr[j-1]>arr[j]){
                int temp = arr[j-1];
                arr[j-1]=arr[j];
                arr[j]=temp;
                j=j-1;
            }
        }
        return arr;
    }
//    public static int[] selectionSort(int[] arr){
//
//    }



}
