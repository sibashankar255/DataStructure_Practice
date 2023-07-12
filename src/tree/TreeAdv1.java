package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeAdv1 {
    public static void main(String[] args) {

    }
    //preorder -> node left right
    //inorder -> left node right
    //postorder -> left right node
    //level order ->

    //Iterative post order
    //T.C -> O(n)
    //S.C -> O(n)
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            if (curr !=null){
                stack.push(curr);
                curr= curr.left;
            }else {
                TreeNode x = stack.peek();
                result.add(x.data);
                stack.pop();
                curr=x.right;
            }
        }
        return result;
    }

    //construct a binary tree from given inorder and postorder
    //inorder ->   4 2 7 5 1 3 6
    //postorder -> 4 7 5 2 6 3 1
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTreeRecursive(inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode buildTreeRecursive(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null; // Empty subtree
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root value in the inorder traversal
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the sizes of the left and right subtrees
        int leftSubtreeSize = rootIndex - inStart;
        int rightSubtreeSize = inEnd - rootIndex;

        // Recursively build the left and right subtrees
        root.left = buildTreeRecursive(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeRecursive(inorder, postorder, rootIndex + 1, inEnd, postEnd - rightSubtreeSize, postEnd - 1);

        return root;
    }

    public static ArrayList<Integer> serialize(TreeNode root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node==null){
                arrayList.add(-1);
                continue;
            }
            arrayList.add(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
        return arrayList;
    }

    public static TreeNode deserialize(ArrayList<Integer> arrayList){
        if (arrayList.isEmpty()){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arrayList.get(0));
        queue.add(root);

        for (int i=1; i<arrayList.size(); i++){
            TreeNode parent = queue.poll();
            if (!arrayList.get(i).equals(-1)){
                TreeNode left = new TreeNode(arrayList.get(i));
                parent.left=left;
                queue.add(left);
            }
            if (!arrayList.get(++i).equals(-1)){
                TreeNode right = new TreeNode(arrayList.get(i));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

}
