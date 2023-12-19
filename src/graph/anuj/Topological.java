package graph.anuj;

import java.util.*;

public class Topological {

    static int[] topologicalSort(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<v; i++){
            if (!visited[i]){
                dsfTopo(adj,i, stack,visited);
            }
        }

        int[] ans = new int[v];
        int i=0;
        while (!stack.isEmpty()){
            ans[i++]=stack.pop();
        }

        return ans;
    }

    private static void dsfTopo(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited) {
        visited[v]=true;

        for (int neighbour : adj.get(v)){
            if (!visited[neighbour]){
                dsfTopo(adj,neighbour,stack,visited);
            }
        }
        stack.push(v);
    }

    static ArrayList<Integer> kahnAlgorithm(int v, ArrayList<ArrayList<Integer>> adj){
        int[] inDeg = new int[v];
        for (ArrayList<Integer> list : adj){
            for (Integer e : list){
                inDeg[e]++;
            }
        }

        boolean[] visited = new boolean[v];
        ArrayList<Integer> ansList = new ArrayList<>();
        bfsKahn(adj, v, 0, visited, ansList, inDeg);



        return ansList;
    }

    private static void bfsKahn(ArrayList<ArrayList<Integer>> adj, int noOfVertex, int v, boolean[] visited, ArrayList<Integer> ansList, int[] inDeg) {
        Queue<Integer> queue =new LinkedList<>();

        for (int i=0; i<noOfVertex; i++){
            if (inDeg[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int curr = queue.poll();
            ansList.add(curr);
            for (int neighbour : adj.get(curr)){
                if (--inDeg[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
    }


    //207. Course Schedule
    //here we have to make the matrix to an adjacency list (directed graph)
    // then check if there is any graph or not.
    // if cycle exist and course schedule cannot complete
    //for that we can use graph coloring algorithm
    //0-> not processed
    //1-> processed
    //2-> processing
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Make adjacency list (Directed graph)
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] visited = new int[numCourses]; //create a visited graph
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) { //if any node is not visited then go to the node and check if any cycle exist
                if (isCyclic(adj, visited, i)) { //if cycle exist then return false
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List<List<Integer>> adj, int[] visited, int curr) {
        if (visited[curr] == 2) { //if the node is in processing state and again visited then cycle exist
            return true;
        }

        visited[curr] = 2; // make the node to processing
        for (int neighbor : adj.get(curr)) { //check every adjacency element of the current
            if (visited[neighbor] != 1) { // if its processed then skip it
                if (isCyclic(adj, visited, neighbor)) { // then check the element is having cycle or what
                    return true;
                }
            }
        }
        visited[curr] = 1; // make the current element to visited
        return false;// return false if cycle is not there
    }



    //210. Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);

        //It initializes an adjacency list (adj) to represent the directed graph of prerequisites.
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Make adjacency list (Directed graph)
        //This loop populates the adjacency list based on the prerequisites array.
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        //It initializes an array visited to keep track of visited nodes and a
        // list order to store the order of courses.
        int[] visited = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        //This loop iterates over all courses. If a course is not visited,
        // it checks if there is a cycle using the isCyclic method.
        // If a cycle is detected, it returns an empty array.
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adj, visited, order, i)) {
                    return new int[]{};
                }
            }
        }

        // Convert List to array
        int[] result = order.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }

    //This method isCyclic is a helper method that checks if there
    // is a cycle in the graph starting from the current course.
    // If a cycle is detected, it returns true, otherwise false.
    // It also updates the visited array and order list accordingly.
    private boolean isCyclic(List<List<Integer>> adj, int[] visited, List<Integer> order, int curr) {
        if (visited[curr] == 2) {
            return true;
        }

        visited[curr] = 2;
        for (int neighbor : adj.get(curr)) {
            if (visited[neighbor] != 1) {
                if (isCyclic(adj, visited, order, neighbor)) {
                    return true;
                }
            }
        }

        visited[curr] = 1;
        order.add(curr);
        return false;
    }





}
