package tree;

public class TreeAdv4 {
    public static void main(String[] args) {

    }

    //in a given BST, two nodes are swapped. find the two nodes


    //LCA in BST
    public static TreeNode lcaBST(TreeNode root, int B, int C){
        TreeNode curr = root;
        while (curr!= null){
            if (B< curr.data && C< curr.data){
                curr=curr.left;
            }
            else if (B> curr.data && C> curr.data){
                curr=curr.right;
            }
            else {
                return curr;
            }
        }
        return curr;
    }
}
