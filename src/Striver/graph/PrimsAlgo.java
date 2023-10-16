package Striver.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {
    //Minimum spanning algorithm
    public static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        boolean[] vis = new boolean[v];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,0));
        int ans=0;

        while (queue.size() !=0){
            Pair curr= queue.remove();

            int u = curr.v;
            if (vis[u]){
                continue;
            }
            ans += curr.wt;
            vis[u]=true;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(u);

            for (ArrayList<Integer> list : neighbours){
                int vertex = list.get(0);
                int wt = list.get(1);
                if (vis[vertex] ==false){
                    queue.add(new Pair(vertex,wt));
                }
            }
        }

        return ans;

    }

}
