package tree;

import java.util.*;
public class TreeAdv5 {
    public static void main(String[] args) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(10);
        result.add(20);
        result.add(30);
        result.add(40);
        result.add(50);
        result.add(60);

        System.out.println(result.toString());
        System.out.println(result.get(1));

    }

    //invert a Binary Tree
    public static TreeNode invertBinaryTree(TreeNode root){
        if (root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertBinaryTree(root.left);
        root.right = invertBinaryTree(root.right);
        return root;
    }

    //Given a binary tree A. Check whether it is possible to partition the tree to two
    // trees which have equal sum of values after removing exactly one edge on the original tree.
    // if sum of all nodes of given binary tree is odd then -> false
    // if even then check!


    //fina the kth smallest element in a BST
    //-> inorder traversal -> elements in the sorted order
    // morris inorder traversal -> T.C->O(n), S.C-> O(1)
    public int kthSmallest(TreeNode A, int B) {
        if(A==null){
            return 0;
        }
        List<Integer> li=new ArrayList();
        dfs(A,li);
        return li.get(B-1);
    }
    public static void dfs(TreeNode root,List<Integer> li){
        if(root==null) return;
        dfs(root.left,li);
        li.add(root.data);
        dfs(root.right,li);
    }

    //check if the given binary tree has root to leaf path sum equal to K.
    public  static int check(TreeNode root, int k){
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return (k==root.data) ? 1:0;
        }

        int leftPath = check(root.left, k - root.data);
        int rightPath = check(root.right, k - root.data);

        return leftPath | rightPath;

        //return  check(root.left, k-root.data) || check(root.right,k-root.data) ? 1 :0;
    }




}
