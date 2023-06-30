package tries;
class Node{
    Node children[];
    Node(){
        children = new Node[2];
    }
}
public class BinaryNode {
    public static void main(String[] args) {

    }

    //given an integer array A, find the max value of A[i] ^ A[j] for every i,j pair
    public static int findMaxXOR(int arr[], int n){
        Node root = new Node();
        for (int i=0; i<arr.length; i++){
            insert(arr[i], root);
        }
        int ans=0;
        for (int i=0; i<n; i++){
            ans = Math.max(ans, getMax(arr[i], root));
        }
        return ans;
    }
    public static int getMax(int x, Node root){
        Node curr = root;
        int ans=0;
        for (int i=30; i>=0; i--){
            int idx = ((x>>i) & 1);
            if (curr.children[idx] ==null){
                curr=curr.children[1 ^ idx];
                ans = (ans << 1);
            }
            else {
                curr = curr.children[idx];
                ans = ((ans<<1) |1);
            }
        }
        return ans;
    }
    public static void insert(int x, Node root){
        Node curr = root;
        for (int i=30; i>=0; i--){
            int idx = ((x>>i) &1);
            if (curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////

    //given an integer A, find the max XOR of a subArray


    //flatten binary tree to linked list as per preorder traversal


}
