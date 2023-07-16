package tree;

import java.util.*;

public class TreeQues2 {
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

        //System.out.println(morrisInorder(treeNode1).toString());
//        System.out.println(nodeSum(treeNode1));

    }

    //valid Binary Search Tree
    public static boolean validBST(TreeNode root){
        return isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
    public static boolean isBst(TreeNode node, int min, int max){
        if (node==null){return true;}

        if (node.data<min || node.data>max){ return false;}

        return (isBst(node.left,min,node.data-1) && isBst(node.right,node.data+1,max));
    }

    //valid Binary Search Tree by inorder
    static TreeNode prev =null;
    public static boolean validBstInorder(TreeNode node){
        if (node!=null){
            if(!validBstInorder(node.left)){
                return false;
            }
            if(prev!=null && node.data<=prev.data){
                return false;
            }
            prev=node;
            return validBstInorder(node.right);
        }
        return true;
    }

    //Largest BST Subtree
    public static int largestBSTSubtree(TreeNode root){
        if (root==null){
            return 0;
        }
        if (validBST(root)){
            return size(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    public static int size(TreeNode root){
        if (root==null){
            return 0;
        }
        int l = size(root.left);
        int r = size(root.right);
        return l+r+1;
    }

    //Sorted Array To Balanced BST
    public TreeNode sortedArrayToBST(final int[] A) {
        return buildBST(A, 0, A.length-1);
    }
    public static TreeNode buildBST(int[] A, int start, int end){
        if (start>end){
            return null;
        }
        int mid= (start+end)/2;
        TreeNode root = new TreeNode(A[mid]);
        root.left=buildBST(A,start,mid-1);
        root.right= buildBST(A,mid+1,end);
        return root;
    }

    //Search in BST
    public static boolean searchBST(TreeNode root, int x){
        if (root==null){return false;}

        if (root.data==x){return true;}

        if (root.data>x){
            return searchBST(root.left,x);
        }
        return searchBST(root.right,x);

    }
    //insertion in BST
    public static TreeNode insertBST(TreeNode root, int x){
        if (root==null){
            return new TreeNode(x);
        }

        if (root.data>x){
            root.left= insertBST(root.left,x);
        }else if (root.data<x){
            root.right= insertBST(root.right,x);
        }

        return root;
    }

    //deletion in BST
    public static TreeNode deleteBST(TreeNode root, int key){
        if (root==null){return root;}

        if (key<root.data){
            root.left = deleteBST(root.left,key);
        }else if (key>root.data){
            root.right = deleteBST(root.right,key);
        }else {
            if (root.left==null){
                return root.right;
            }else if (root.right==null){
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteBST(root.right,root.data);
        }
        return root;
    }
    public static int minValue(TreeNode root){
        int minv = root.data;
        while (root.left!=null){
            minv= root.left.data;
            root=root.left;
        }
        return minv;
    }

    //Two sum in BST
    public static int isPairPresent(TreeNode root, int target){
        Set<Integer> set = new HashSet<>();
        boolean ans = util(root,target,set);
        return ans ? 1:0;
    }

    //16 23 9 -1 1 22 2 25 19 6 13 -1 24 14 -1 30 4 26 29 -1 -1 -1 -1 -1 3 -1 8 -1 -1 12 18 28 -1 10 -1 5 -1 17 11 21 7 -1 -1 -1 20 -1 -1 -1 -1 -1 15 -1 -1 -1 -1 -1 -1 -1 27 -1 -1
    public static boolean util(TreeNode root, int sum, Set<Integer> set){
        if (root==null){
            return false;
        }
        if (util(root.left,sum,set)==true){
            return true;
        }
        if (set.contains(sum-root.data)){
            return true;
        }
        set.add(root.data);

        return util(root.right,sum,set);
    }

    //moris inorder traversal
    public static ArrayList<Integer> morrisInorder(TreeNode root){
        ArrayList<Integer> inorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null){
            if (curr.left ==null){
                inorder.add(curr.data);
                curr=curr.right;
            }else {
                TreeNode prev = curr.left;
                while (prev.right!= null &&prev.right != curr){
                    prev = prev.right;
                }
                if (prev.right ==null){
                    prev.right=curr;
                    curr=curr.left;
                }else {
                    prev.right=null;
                    inorder.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return inorder;
    }

    //Least Common Ancestor
    public static TreeNode leastCommonAncestors(TreeNode root, int A, int B){
        if (root==null){
            return null;
        }
        if (root.data==A || root.data==B){
            return root;
        }
        TreeNode left =leastCommonAncestors(root.left,A,B);
        TreeNode right = leastCommonAncestors(root.right,A,B);

        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }
    public int lca(TreeNode A, int B, int C) {
        if (A == null) {
            return -1;
        }

        // Check if either B or C is the root node
        if (A.data == B || A.data == C) {
            return A.data;
        }

        // Recursively search for B and C in the left and right subtrees
        int leftLCA = lca(A.left, B, C);
        int rightLCA = lca(A.right, B, C);

        // If B and C are found in different subtrees, A is the LCA
        if (leftLCA != -1 && rightLCA != -1) {
            return A.data;
        }

        // If either B or C is found, return the found value
        if (leftLCA != -1) {
            return leftLCA;
        }
        if (rightLCA != -1) {
            return rightLCA;
        }

        // B and C are not found in the subtrees, return -1
        return -1;
    }

//    //Recover Binary Search Tree
//    public static ArrayList<Integer> recoverBST(TreeNode root){
//        ArrayList<Integer> inorder =inorderTraversal(root);
//
//        ArrayList<Integer> twoValues = new ArrayList<>();
//        int prev =0;
//        int first =0;
//        int last =0;
//
//        while (first<last){
//
//        }
//
//
//
//    }


    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr= root;

        while (curr!=null || !stack.isEmpty()){
            if (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode node = stack.pop();
                inorder.add(node.data);
                curr= node.right;
            }
        }
        return inorder;
    }

    // Invert the Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }

    //Equal Tree Partition
    static int sumOfNodes=0;
    static int ans=0;
    public static int equalSum(TreeNode root){
        if (root==null){
            return 0;
        }
        sumOfNodes = findNodeSum(root);

        findNodeSum(root.left);
        findNodeSum(root.right);

        return ans;
    }

//    private static void checkEqualPartition(TreeNode root, int target, int[] ans) {
//        if (root==null){
//            return;
//        }
//        int sum = root.data+nodeSum(root.left)+nodeSum(root.right);
//        if (sum==target){
//            ans[0]=1;
//        }
//
//    }
    public static int findNodeSum(TreeNode root){
        if (root==null){
            return 0;
        }
        int left = findNodeSum(root.left);
        int right= findNodeSum(root.right);

        int currentSum = left+right+root.data;
        if (currentSum==sumOfNodes/2){
            ans=1;
        }

        return currentSum;
    }

    //////////////////
    boolean hasEqualPartition = false;

    public int checkEqualTreePartition(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int totalSum = calculateSubtreeSum(A);

        // Check if the total sum is odd, which is not divisible into two equal parts
        if (totalSum % 2 != 0) {
            return 0;
        }

        // Perform post-order traversal to check for equal partition
        checkPartition(A, totalSum);

        return hasEqualPartition ? 1 : 0;
    }

    private int calculateSubtreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSubtreeSum(node.left);
        int rightSum = calculateSubtreeSum(node.right);

        return node.data + leftSum + rightSum;
    }

    private int checkPartition(TreeNode node, int totalSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = checkPartition(node.left, totalSum);
        int rightSum = checkPartition(node.right, totalSum);

        // If the current node is the root and has two non-empty subtrees with equal sums, it's a valid partition
        if (node != node && leftSum == totalSum / 2 && rightSum == totalSum / 2) {
            hasEqualPartition = true;
        }

        return leftSum + rightSum + node.data;
    }

    //kth smallest element
    public int kthsmallest(TreeNode A, int B) {
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


    //Symmetric Binary Tree

    public static int symmetric(TreeNode root){
        return (root==null || isSymmetric(root.left,root.right)) ? 1:0;
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null || right==null){
            return left==right;
        }
        if (left.data!=right.data){
            return false;
        }
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }

    //Sum binary tree or not




}
