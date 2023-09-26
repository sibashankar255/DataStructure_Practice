package graph.anuj;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<v; i++){
            if (!visited[i]){
                dfs(i, adj, visited, ans);
            }
        }
        //dfs(0, adj, visited, ans);
        return ans;
    }

    private void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans) {
        visited[v] =true;
        ans.add(v);

        for (Integer neighbour : adj.get(v)){
            if (!visited[neighbour]){
                dfs(neighbour, adj, visited, ans);
            }
        }
    }


    //detect cycle in undirected graph
    public boolean isCycleUndirected(int v,ArrayList<ArrayList<Integer>> adj ){
        boolean visited[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (!visited[i]){
                if (dfsCycleUndirected(i,adj,visited,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfsCycleUndirected(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[v]=true;

        for (Integer neighbor : adj.get(v)){
            if (!visited[neighbor]){
                if (dfsCycleUndirected(neighbor,adj,visited,v)){
                    return true;
                }
            }else if(parent !=neighbor){
                return true;
            }
        }
        return false;
    }


    //detect cycle in directed graph
    public boolean isCycleDirected(int v,ArrayList<ArrayList<Integer>> adj ){
        boolean visited[] = new boolean[v];
        boolean recs[] = new boolean[v];
        for (int i=0; i<v; i++){
            if (!visited[i]){
                if (dfsCycleDirected(i,adj,visited,recs)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfsCycleDirected(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recs) {
        visited[v]=true;
        recs[v] =true;

        for (Integer neighbor : adj.get(v)){
            if (!visited[neighbor]){
                if (dfsCycleDirected(neighbor,adj,visited,recs)){
                    return true;
                }
            }else if(recs[neighbor]){
                return true;
            }
        }
        recs[v]=false;
        return false;
    }

    //topological Sort
    public int[] topSort(int v, ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<v; i++){
            if (!visited[i]){
                dfsTop(adj,i, stack,visited);
            }
        }

        int ans[] = new int[v];
        ArrayList<Integer> arrayList = new ArrayList<>();
        int i=0;
        while (!stack.isEmpty()){
            ans[i++]=stack.pop();


        }
        return ans;
    }

    private static void dfsTop(ArrayList<ArrayList<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited) {
        visited[v]=true;

        for (int neighbour : adj.get(v)){
            if (!visited[neighbour]){
                dfsTop(adj,neighbour,stack,visited);
            }
        }
        stack.push(v);
    }


}
