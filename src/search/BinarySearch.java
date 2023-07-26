package search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a={1,2,4,78,5,6,7658,3,34,7,8};
        System.out.println(binary(a,7658,0,a.length-1));

    }

    public static int binary(int[] arr,int k,int low, int high){
        low=0;
        high=arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid]==k){
                return mid;
            }else if (k>arr[mid]){
                low=mid+1;
            }else {
                high=mid-1;
            }
        }
        return -1;
    }

    //search in an infinite sorted array
    public static int searchInfinite(int[] arr, int key){
        int low=0;
        int high = 1;
        while (arr[high]<key){
            low=high;
            high =2*high;
        }
        return binary(arr,key,low,high);
    }

    //search in a rotated sorted array
    public int rotatedArray(int[] arr,int key){
        int low=0;
        int high=arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if (arr[mid]==key){
                return mid;
            }
            if (arr[low]<arr[mid]){
                if (key>=arr[low] && key<arr[mid]){
                    high=mid-1;
                }else {
                    low =mid+1;
                }
            }else {
                if (key>arr[mid] && key<=arr[high]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

}
