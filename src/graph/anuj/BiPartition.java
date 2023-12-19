package graph.anuj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

public class BiPartition {
    /**
     * {[1,3],[1,4],[2,4]}
     * [x,y] -> x dislikes y
     * {1,2} , {3,4}
     *
     * goal:-
     * find if it is possible to partition/segregate people into 2 sets such that
     * no 2 person in a set hates each other.
     *
     * how to solve this?
     * 1.use 2 maps/sets
     * [1,3],[1,4],[2,4]
     * check 1 if it is present in any set then put it in u, check if 1 is in u put it in v
     * check 1 is in which set,if it's u then put 4 in v
     * check 4 is in which set, if it's v then put it in u
     *
     * u -> 1,2
     * v -> 3,4
     *
     * 2.using bipartite graph
     * {[1,2],[2,3],[2,4],[3,5],[4,5]}
     *
     *
     */

    /**
     * from the dislikes matrix create an adjacency list(list of list)
     * and add the elements like
     * put the first element in second index element's position
     * put the second element in the first index element's position
     *
     * create a color array of size n+1
     *
     * the iterate over color array from 1 to n
     * if any color index is having 0 then create a queue
     * add the first element into the queue and color the element to 1
     *
     * traverse the queue until the queue get empty
     * pop the element
     * then traverse the adjacent elements to that popped element
     * if the adjacency element's color equal to the popped element's color then return false
     * if not then make the adjacency element's color opposite to popped element
     * then add the elements to the queue.
     *
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n+1];
//        Arrays.fill(color, -1);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i=0;i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes){
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }


        for (int i=1; i<=n; i++){
            if (color[i]==0){
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i]=1;

                while (!queue.isEmpty()){
                    int top = queue.poll();
                    for (int neighbour : graph.get(top)){
                        if (color[neighbour] == color[top]){
                            return false;
                        }
                        if (color[neighbour]==0){
                            color[neighbour] = -color[top];
                            queue.add(neighbour);
                        }
                    }
                }
            }
        }
        return true;
    }


    //785. Is Graph Bipartite?
    /**
     *
     */
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] color = new int[length];

        for (int i=0; i<length; i++){
            if (color[i]==1 || color[i]==-1){
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i]=1;

            while (!queue.isEmpty()){
                int curr = queue.poll();
                for (int next : graph[curr]){
                    if (color[next]==color[curr]){
                        return false;
                    }
                    if (color[next]==0){
                        color[next] = -color[curr];
                        queue.add(next);
                    }
                }
            }
        }
        return true;
    }


}
