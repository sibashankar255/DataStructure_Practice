package sorting;

public class Sorting {
    public static void main(String[] args) {

        int[] A = {4,3,7,1,5};

        for (int i: quickSort(A)) {
            System.out.println(i);
        }

    }

    //bubble sorting-> T.C. -> O(n^2)
    public static int[] bubbleSort(int[] A){
        for (int i=0; i<A.length; i++){
            for (int j=0; j<A.length-i-1; j++){
                if (A[j]>A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        return A;
    }
    //insertion sort-> T.C. -> O(n^2)
    public static int[] insertionSort(int[] A){
        for (int i=0; i<A.length; i++){
            int temp = A[i];
            int j=i-1;
            while (j>=0 && A[j]>temp){
                A[j+1]=A[j];
                j--;
            }
            A[j+1]=temp;
        }
        return A;
    }

    //selection sort
    public static int[] selectionSort(int[] arr){
        for (int i=0; i<arr.length; i++){
            int min=i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp = arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    //quick sort
    public static int[] quickSort(int[] arr){
        if (arr==null || arr.length==0){
            return arr;
        }
        sort(arr, 0, arr.length-1);
        return arr;
    }
    private static void sort(int[] arr, int low, int high) {
        if (low<high){
            int pivot=partition(arr,low,high);
            sort(arr,low,pivot-1);
            sort(arr,pivot+1,high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i =low-1;

        for (int j=low; j<high; j++){
            if (arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    private static void swap(int[] arr, int i, int high) {
        int temp =arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){

        }
    }


}
