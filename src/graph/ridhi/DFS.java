package graph.ridhi;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {

    }

    static void dfs(int n,int source, int[][] adj){
        boolean visited[] = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()){
            int curr_node = stack.pop();
            for (int next_Node=0; next_Node<n; next_Node++){
                if (adj[curr_node][next_Node]==1 && !visited[next_Node]){
                    visited[next_Node]=true;
                    stack.push(next_Node);
                }
            }
        }

    }
}
