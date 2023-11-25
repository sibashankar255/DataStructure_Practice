package tree;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TreeQues {
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


        ArrayList<Integer> arrayList = preorderTraversal(treeNode1);
        for (int k : arrayList){
            System.out.println(k);
        }

        //System.out.println(inorderTraversal(treeNode1).toString());
//        int[] A = {4,2,5,1,6,3,7};
//        int[] B ={1,2,4,5,3,6,7};

//        ArrayList<Integer> arrayList = topView(treeNode1);
//        for (int i=0 ; i<arrayList.size(); i++){
//            System.out.println(arrayList.get(i));
//        }
//        System.out.println(difference(treeNode1));
//        ArrayList<ArrayList<Integer>> zigzag = new ArrayList<>();
//        zigzag = zigZag(treeNode1);
//        System.out.println(zigzag.toString());
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        arrayList = boundaryTraversal(treeNode1);
//        System.out.println(arrayList.toString());

//        System.out.println(diameter(treeNode1));

    }

    //40 20 50 10 60 30 70
    public static ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr= root;

        while (curr!=null || !stack.isEmpty()){
            if (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }else {
                TreeNode node = stack.pop();
                arrayList.add(node.data);
                curr= node.right;
            }
        }
        return arrayList;
    }

    //10 20 40 50 30 60 70
    public static ArrayList<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                result.add(curr.data);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }


    //40 50 20 60 70 30 10
    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        Stack<TreeNode> st = new Stack<>();
        st.push(A);
        ArrayList<Integer> ans = new ArrayList<>();
        while(st.size()>0){
            TreeNode curr = st.pop();
            ans.add(curr.data);
            if(curr.left!=null){
                st.push(curr.left);
            }
            if(curr.right!=null){
                st.push(curr.right);
            }
        }
        // now reverse list
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i=ans.size()-1;i>=0;i--){
            ret.add(ans.get(i));
        }
        Collections.reverse(ans);
        return ret;
    }

    //Binary Tree From Inorder And Preorder
    public static TreeNode buildTreePre(int[] preOrder, int[] inorder){
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return splitTreePre(0,0,inorder.length-1,preOrder,inOrderIndexMap);
    }
    public static TreeNode splitTreePre(int preStart, int inStart, int inEnd, int[] preOrder, Map<Integer,Integer> integerIntegerMap){
        if (preStart>preOrder.length-1 || inStart>inEnd) return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int mid = integerIntegerMap.get(preOrder[preStart]);
        if (mid>inStart){
            root.left = splitTreePre(preStart+1,inStart,mid-1,preOrder,integerIntegerMap);
        }
        if (mid<inEnd){
            root.right= splitTreePre(preStart+mid-inStart+1,mid+1,inEnd,preOrder,integerIntegerMap);
        }
        return root;
    }

    //Binary Tree From Inorder And Postorder
    public static TreeNode buildTreePost(int[] postOrder, int[] inorder){
        if (postOrder==null || inorder==null || inorder.length!= postOrder.length){
            return null;
        }
        Map<Integer, Integer> postOrderIndexMap = new HashMap<>();
        for (int i=0; i<inorder.length; i++){
            postOrderIndexMap.put(postOrder[i],i);
        }
        return splitTreePost(0,inorder.length-1,0,postOrder.length-1,inorder,postOrder,postOrderIndexMap);
    }
    public static TreeNode splitTreePost(int inStart, int inEnd,int postStart,int postEnd,int[] inOrder, int[] postOrder, Map<Integer,Integer> postOrderIndexMap){
        if (postStart>postEnd || inStart>inEnd) return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int inRoot = postOrderIndexMap.get(postOrder[postEnd]);
        int numLeft = inRoot-inStart;

        root.left = splitTreePost(inStart,inRoot-1,postStart,postStart+numLeft-1,inOrder,postOrder,postOrderIndexMap);
        root.right=splitTreePost(inRoot+1, inEnd,postStart+numLeft,postEnd-1,inOrder,postOrder,postOrderIndexMap);
        return root;
    }


    // Level Order
    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A == null) {
            return result;
        }
        Stack<ArrayList<Integer>> stack = new Stack<>();
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
            stack.push(currentLevel);
            double avg =currentLevel.stream()
                    .mapToInt(Integer::intValue)
                    .average().getAsDouble();
        }
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    //Left View of Binary tree
    public static ArrayList<Integer> leftView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i==0){
                    result.add(node.data);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
    //right View of Binary tree
    public static ArrayList<Integer> rightView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i==levelSize-1){
                    result.add(node.data);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    //top view
    public static ArrayList<Integer> topView(TreeNode root){
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();

        queue.add(new Pair(0,root));

        while (!queue.isEmpty()){
            Pair curr = queue.poll();
            if (!map.containsKey(curr.hd)){
                map.put(curr.hd,curr.node.data);
            }
            if (curr.node.left!=null){
                queue.add(new Pair(curr.hd-1,curr.node.left));
            }
            if (curr.node.right!=null){
                queue.add(new Pair(curr.hd+1,curr.node.right));
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    //bottom view
    public static ArrayList<Integer> bottomView(TreeNode root){
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(0,root));
        while (!queue.isEmpty()){
            Pair curr = queue.poll();
            map.put(curr.hd,curr.node.data);
            if (curr.node.left!=null){
                queue.add(new Pair(curr.hd-1,curr.node.left));
            }
            if (curr.node.right!=null){
                queue.add(new Pair(curr.hd+1,curr.node.right));
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            arrayList.add(entry.getValue());
        }
        return arrayList;
    }

    //difference between Odd and Even Levels
    public static int difference(TreeNode A){
        if (A == null) {
            return 0;
        }
        int even=0;
        int odd=0;
        int count=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (count%2==0){
                    even=even+node.data;
                }else {
                    odd=odd+node.data;
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
        return Math.max(even,odd)-Math.min(even,odd);
    }

    //Vertical Order traversal
    public static ArrayList<Integer> verticalView(TreeNode root){
        Queue<Pair> queue = new ArrayDeque<>();
         Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

         queue.add(new Pair(0,root));
         while (!queue.isEmpty()){
             Pair curr = queue.poll();
             if (map.containsKey(curr.hd)){
                 map.get(curr.hd).add(curr.node.data);
             }else {
                 ArrayList<Integer> arrayList = new ArrayList<>();
                 arrayList.add(curr.node.data);
                 map.put(curr.hd,arrayList);
             }
             if (curr.node.left!=null){
                 queue.add(new Pair(curr.hd-1, curr.node.left));
             }
             if (curr.node.right!=null){
                 queue.add(new Pair(curr.hd+1,curr.node.right));
             }
         }

        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
         for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
             array.add(entry.getValue());
         }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ans.addAll(entry.getValue());
        }
        return ans;
    }

    //zig-zag traversal
    public static ArrayList<ArrayList<Integer>> zigZag(TreeNode root){
        ArrayList<ArrayList<Integer>> zigzag = new ArrayList<>();
        if (root==null){return zigzag;};

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int count=0;
        while (!queue.isEmpty()){
            int levelSize= queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i=0 ; i<levelSize;i++){
                TreeNode node = queue.poll();
                level.add(node.data);

                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            if (count%2==0){
                zigzag.add(level);
            }else {
                Collections.reverse(level);
                zigzag.add(level);
            }
            count++;
        }
        return zigzag;
    }


    //Boundary Traversal Of Binary Tree
    public static ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList ans = new ArrayList<>();
        if(root==null) return ans;

        ans.add(root.data);

        //print left boundary
        printleft(root.left,ans);

        //printleaf
        printleaf(root.left,ans);

        printleaf(root.right,ans);

        //printright
        printright(root.right,ans);

        return ans;
    }

    static void printright(TreeNode node,ArrayList<Integer> ans){
        if(node ==null) return;
        if(node.left==null && node.right==null){
            return;
        }
        if(node.right!=null){
            printright(node.right,ans);
        }
        else{
            printright(node.left,ans);
        }
        ans.add(node.data);
    }
    static void printleft(TreeNode node , ArrayList<Integer> ans){
        if(node==null) return;
        if(node.left==null && node.right==null)
            return ;

        ans.add(node.data);

        if(node.left!=null){
            printleft(node.left,ans);
        }
        else{
            printleft(node.right,ans);
        }
    }
    static void printleaf(TreeNode node,ArrayList<Integer> ans){
        if(node ==null) return;
        if(node.left==null && node.right==null){
            ans.add(node.data);
        }

        printleaf(node.left,ans);

        printleaf(node.right,ans);

    }


    //diameter of a binary tree
    public static int diameter(TreeNode root){
        if (root==null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH =height(root.right);

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int diameter = Math.max(leftH + rightH, Math.max(leftDiameter,rightDiameter));
        return diameter;
    }
    public static int height(TreeNode root){
        if (root==null){
            return 0;
        }
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }

    // Binary Tree Maximum Path Sum
    int max_path_sum;
    public int maxPathSum(TreeNode root){
        max_path_sum = Integer.MIN_VALUE;
        pathSum(root);
        return max_path_sum;
    }
    public int pathSum(TreeNode node){
        if (node==null){
            return 0;
        }
        int left = Math.max(0, pathSum(node.left));
        int right = Math.max(0,pathSum(node.right));

        max_path_sum = Math.max(max_path_sum,left+right+node.data);
        return Math.max(left,right)+node.data;
    }

    public static int largest(List<Integer> list){
        List<Integer> result= new ArrayList<>();
        return Collections.max(list);
    }


}