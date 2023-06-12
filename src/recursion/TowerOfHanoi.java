package recursion;

public class TowerOfHanoi {
    //Rules:-
    //1. Only one disk transferred in 1 step
    //2. Smaller disks are always kept on the top of larger disks
    //O(2^n -1 ) ~ O(2^n)

    public static void main(String[] args) {
        int n=4;
        towerOfHanoi(n, "Source","Helper","Destination");
    }
    public static void towerOfHanoi(int n, String src, String helper, String dest){

        if (n==1){
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src,dest, helper);
        System.out.println("transfer disk "+ n + " from "+ src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);

    }
}
