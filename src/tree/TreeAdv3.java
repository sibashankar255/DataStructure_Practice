package tree;

public class TreeAdv3  {
    public static void main(String[] args) {

    }
    //Binary Search Tree
    //It is a Binary tree where every node(x) follows this property
    //-> every node in left subtree of x has data <= x.data
    //-> every node in right subtree of x has data > x.data
    //from root->
    //keep moving to left till you encounter null-> the last non-null node has the lowest value
    //keep moving to right till you find null -> last non-null node has the greatest value


    // Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
    //T.C -> O(height)
    //S.C -> O(1)
    public static boolean isPresent(TreeNode root, int val){
        TreeNode curr = root;
        while (curr != null){
            if (curr.data == val){
                return true;
            }
            if (val < curr.data){
                curr = curr.left;
            }else {
                curr = curr.right;
            }
        }
        return false;
    }

    //Insertion in a BST
    //T.C -> log(n)
    //S.C -> O()
    public static TreeNode insertionBST(TreeNode root, int val){
        if (root==null){
            return new TreeNode(val);
        }
        if (val<root.data){
            root.left=insertionBST(root.left,val);
        }
        if (val> root.data){
            root.right=insertionBST(root.right,val);
        }
        return root;
    }

    //deletion in BST
    //search the node and keep track of its parents
    // if target node is a leaf delete the target->
    //parent.left =null -> if target is parent.left
    //parent.right=null -> if target is parent.right
    //if the target node has 1 child->
    //parent.left/right = target.left/right
    //if the target node has 2 children->
    // find the greatest element in left sub-tree -> y
    // delete y from LST
    //change x->y
    public static TreeNode deleteNode(TreeNode root, int val){
        TreeNode temp = root;
        TreeNode parent=temp;
        while (temp != null){
            if (temp.data==val){
                break;
            }
            parent = temp;
            if (temp.data > val){
                temp=temp.left;
            }else {
                temp = temp.right;
            }
        }
        if (temp ==null){//search element is not there
            return root;
        }
        //case 1
        if (temp.left==null && temp.right==null){
            if (parent ==null){
                return null;
            }if (parent.data > temp.data){
                parent.left=null;
            }else {
                parent.right=null;
            }
            return root;
        }
        if (temp.left==null){
            if (parent==null){
                root=temp.right;
                return root;
            }
            if (parent.data>temp.data){
                parent.left=temp.right;
            }else {
                parent.right = temp.right;
            }
            return root;
        }
        if (temp.right==null){
            if (parent==null){
                root=temp.left;
                return root;
            }
            if (parent.data>temp.data){
                parent.right=temp.left;
            }else {
                parent.left = temp.left;
            }
            return root;
        }
        TreeNode x=temp.left;
        while (x.right !=null){
            x=x.right;
        }
        deleteNode(root,x.data);
        if (parent.data>temp.data){
            parent.left=x;
            x.left=temp.left;
        }else {
            parent.right=x;
            x.left=temp.left;
        }
        return root;
    }

    //construct a balanced BST from a sorted array
    //A = {1  3  5  8  10  15  18  20}
    //T.C -> O(n)
    //S.C -> O(height)
    public static TreeNode buildBST(int[] A, int start, int end){
        int n = A.length;
        if (start>end){
            return null;
        }
        int mid= (start+end)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left=buildBST(A,start,mid-1);
        root.right= buildBST(A,mid+1,end);
        return root;
    }

    //check if a given binary tree is a BST
    public static boolean checkBST(TreeNode root, int start, int end){
        if (root==null){
            return true;
        }
        if (root.data>end || root.data<start){
            return false;
        }
        return checkBST(root.left,start,root.data-1) && checkBST(root.right,root.data+1,end);
    }

    //find the largest BST subtree in a Binary Tree

}
