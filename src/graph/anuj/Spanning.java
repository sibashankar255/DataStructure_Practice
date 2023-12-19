package graph.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ForkJoinPool;

public class Spanning {
    /**
     * prim's algorithm
     * kruskal's algorithm
     *
     * spanning tree :-
     * computer network routing protocol
     * cluster analysis
     * network planning
     *
     * Minimum spanning tree:-
     * pathFinder in map
     * telecommunication network, water supply network and electrical grid
     *
     *
     */

    //minimum spanning tree
    // time -> O(ElogE) E -> edges
    // Space -> O(E+v)
    static int primsAlgo(int v, ArrayList<ArrayList<ArrayList<Integer>>> edges){
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(0,0));
        int ans=0;

        while (queue.size()!=0){
            Pair currPair = queue.remove();

            int currVertex = currPair.vertex;
            if (visited[currVertex]){
                continue;
            }

            ans +=currPair.weight;
            visited[currVertex]=true;

            ArrayList<ArrayList<Integer>> neighbour = edges.get(currVertex);

            for (ArrayList<Integer> list : neighbour){
                int vertex =list.get(0);
                int wt = list.get(1);

                if (visited[vertex]==false){
                    queue.add(new Pair(vertex,wt));
                }
            }
        }
        return ans;
    }

    static int[] dijkstraAlgo(int v,int source, ArrayList<ArrayList<ArrayList<Integer>>> edges){
        boolean[] visited = new boolean[v];
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(source,0));
        int ans[]= new int[v];
        Arrays.fill(ans,10000000);
        ans[source]=0;

        while (queue.size()!=0){
            Pair currPair = queue.remove();

            int currVertex = currPair.vertex;
            if (visited[currVertex]){
                continue;
            }

            visited[currVertex]=true;

            ArrayList<ArrayList<Integer>> neighbour = edges.get(currVertex);

            for (ArrayList<Integer> list : neighbour){
                int vertex =list.get(0);
                int wt = list.get(1);

                if (ans[vertex] > ans[currVertex]+wt){
                    ans[vertex] = ans[currVertex] +wt;
                    queue.add(new Pair(vertex,ans[vertex]));
                }
            }
        }
        return ans;
    }
}


