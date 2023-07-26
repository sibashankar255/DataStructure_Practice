package sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {4,3,7,1,5};

        for (int i: bubbleSort(A)) {
            System.out.println(i);
        }
    }

    public static int[] bubbleSort(int[] arr){
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    arr[j] = arr[j]^arr[j+1];
                    arr[j+1]=arr[j]^arr[j+1];
                    arr[j]=arr[j]^arr[j+1];
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
