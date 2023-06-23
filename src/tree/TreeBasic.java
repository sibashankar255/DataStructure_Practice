package tree;

import java.util.ArrayList;
import java.util.Stack;

public class TreeBasic {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(20);
        TreeNode treeNode3 = new TreeNode(30);
        treeNode1.left=treeNode2;
        treeNode1.right= treeNode3;
        TreeNode treeNode4 = new TreeNode(40);
        TreeNode treeNode5 = new TreeNode(50);
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        TreeNode treeNode6 = new TreeNode(60);
        TreeNode treeNode7 = new TreeNode(70);
        treeNode3.left=treeNode6;
        treeNode3.right=treeNode7;


        //preOrderTraversal(treeNode1);
        //inOrderTraversal(treeNode1);
        //postOrderTraversal(treeNode1);

        //System.out.println(size(treeNode1));
        System.out.println(height(treeNode4));
    }


    public static void preOrderTraversal(TreeNode root){
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root){
        if (root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
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