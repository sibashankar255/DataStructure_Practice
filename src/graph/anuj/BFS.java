package graph.anuj;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    //find the minimum distance from source to destination
    //find the number of connected components

    public static void main(String[] args) {


    }
    public static int[][] emptyArray() {

        return new int[0][];
    }

    public static boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, int dest, int v, int pred[], int dist[]){

        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[v];
        for (int i=0; i<v; i++){
            visited[i]=false;
            dist[i]=Integer.MAX_VALUE;
            pred[i]=-1;
        }

        visited[src]=true;
        dist[src]=0;
        queue.add(src);

        while (!queue.isEmpty()){
            int curr = queue.remove();
            for (int i=0; i<adj.get(curr).size(); i++){
                int neighbour = adj.get(curr).get(i);
                if (visited[neighbour]==false){
                    visited[neighbour]=true;
                    dist[neighbour]=dist[curr]+1;
                    pred[neighbour]=curr;
                    queue.add(neighbour);

                    if (neighbour==dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //kahn's algorithm -> topological sort


}
