package Striver.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Topological {

    //Directed Acyclic graph
    public static ArrayList<Integer> topSort(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[v];

        for (int i=0; i<v ; i++){
            if (visited[i] ==false){
                visited[i]=true;
                topo(i,visited,adj,stack);
            }
        }

        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }

        return ans;
    }
    private static void topo(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        for (int x : adj.get(i)){
            if (visited[x] ==false){
                visited[x]=true;
                topo(x,visited,adj,stack);
            }
        }
        stack.push(i);
    }

    //Kahn's Algorithm:- topological sorting BFS

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int inDeg[] = new int[V];

        for (ArrayList<Integer> list : adj){
            for (Integer e :list){
                inDeg[e]++;
            }
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        bfsTopo(adj,V,0, ansList,inDeg);

        int[] ans = new int[V];
        for (int i=0; i<ansList.size();i++){
            ans[i]=ansList.get(i);
        }
        return ans;
    }

    private static void bfsTopo(ArrayList<ArrayList<Integer>> adj, int V, int i, ArrayList<Integer> ansList, int[] inDeg) {
        Queue<Integer> queue = new LinkedList<>();

        for (int j=0; j<V; j++){
            if (inDeg[j]==0){
                queue.add(j);
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



}
