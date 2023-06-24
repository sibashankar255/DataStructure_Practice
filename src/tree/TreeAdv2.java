package tree;

import java.util.*;


public class TreeAdv2 {
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

        //levelOrder(treeNode1);

        //Queue<TreeNode> queue = new LinkedList<>();
        //queue.add(treeNode2);
        //int levelSize = queue.size();
        //System.out.println(levelSize);

//        ArrayList<Integer> arrayList = leftView(treeNode1);
//        System.out.println(arrayList.toString());
//
//        ArrayList<Integer> arrayList2 = rightView(treeNode1);
//        System.out.println(arrayList2.toString());

        System.out.println(oddEvenLevels(treeNode1));
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null){
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            System.out.println(node.data);

            if (node.left !=null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderArraylist(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.data);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    //left view of a Binary Tree
    public static ArrayList<Integer> leftView(TreeNode root){
        ArrayList<Integer> leftViewList = new ArrayList<>();
        if (root==null){
            return leftViewList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i =0; i<levelSize; i++){
                TreeNode node = queue.remove();
                if (i==0){
                    leftViewList.add(node.data);
                }

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return leftViewList;
    }

    //right view of a Binary Tree
    public static ArrayList<Integer> rightView(TreeNode root){
        ArrayList<Integer> rightViewList = new ArrayList<>();
        if (root==null){
            return rightViewList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();

            for (int i =0; i<levelSize; i++){
                TreeNode node = queue.remove();
                if (i==levelSize-1){
                    rightViewList.add(node.data);
                }

                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return rightViewList;
    }


    //Odd and Even Levels
    public static int oddEvenLevels(TreeNode A) {

        if (A == null) {
            return 0;
        }
        int odd = 0;
        int even=0;
        int count=1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (count%2==0){
                    odd=odd+node.data;
                }else {
                    even = even+node.data;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return Math.max(odd,even)-Math.min(odd,even);
    }

    //vertical view of Binary tree

    // top view of Binary tree

    //bottom view of Binary tree

    //Types of Binary Tree
    //1.Proper binary tree -> every node, either 0 or 2 children
    //2.Complete binary tree -> every level is completely filled, except may be the last level
    //in the last level, all the nodes must be as left as possible
    //3.perfect binary tree -> every level is completely filled


    //given a perfect binary tree with n nodes. find the height of the tree
    //h= log(n+1)-1

    //balanced Binary tree -> if every node
    // |height of left child - height of right child| <=1
    //check if the given binary tree is balanced
    //T.C-> O(n)
    //S.C-> O(h)
    static boolean isBalanced;
    boolean checkBalanced(TreeNode root){
        isBalanced =true;
        int h = height(root);
        return isBalanced;

    }
    public static int height(TreeNode root){
        if (root ==null){
            return -1;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);
        if (Math.abs(leftH-rightH)>1){
            isBalanced = false;
        }
        return  Math.max(leftH, rightH)+1;
    }

    //find the diameter of a Binary Tree(distance between farthest nodes/ no. of edges)
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height1(root.left);
        int rightHeight = height1(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        int diameter = Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));

        return diameter;
    }
    private int height1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
