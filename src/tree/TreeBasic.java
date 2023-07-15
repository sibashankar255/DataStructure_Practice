package tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeBasic {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left=treeNode2;
        treeNode1.right= treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;


//        preOrderTraversal(treeNode1);
//        preOrderTraversalArr(treeNode1);


        //inOrderTraversal(treeNode1);

        postOrderTraversal(treeNode1);

        //System.out.println(size(treeNode1));
        //System.out.println(height(treeNode4));

    }

    static ArrayList<Integer> arrayList = new ArrayList<>();


    public static void preOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.print(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void preOrderTraversalArr(TreeNode root){
        if (root == null) {
            return;
        }

        arrayList.add(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data);
        inOrderTraversal(root.right);

    }
    public static void postOrderTraversal(TreeNode root){
        if (root==null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }

    public static int size(TreeNode root){
        if (root==null){
            return 0;
        }
        int l = size(root.left);
        int r = size(root.right);
        return l+r+1;
    }

    public static int height(TreeNode root){
        if (root==null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r) + 1;
    }
}