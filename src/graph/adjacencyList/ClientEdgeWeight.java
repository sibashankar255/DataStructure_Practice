package graph.adjacencyList;

import java.util.ArrayList;

public class ClientEdgeWeight {
    public static void main(String[] args) {
        int v=4;

        ArrayList<EdgeWeight>[] graph = new ArrayList[v];

        createGraph(graph);


        //print 2's neighbour
        for (int i=0; i<graph[2].size(); i++){
            EdgeWeight e = graph[2].get(i);
            System.out.println(e.dest+" "+e.weight);
        }


        //print 1's neighbour
        for (int i=0; i<graph[1].size(); i++){
            EdgeWeight e = graph[1].get(i);
            System.out.println(e.dest+" "+e.weight);
        }
    }

    public static void createGraph(ArrayList<EdgeWeight> graph[]){
        for (int i=0; i<graph.length;i++){
            graph[i]=new ArrayList<EdgeWeight>();
        }

        graph[0].add(new EdgeWeight(0,2,2));

        graph[1].add(new EdgeWeight(1,2,10));
        graph[1].add(new EdgeWeight(1,3,0));

        graph[2].add(new EdgeWeight(2,0,2));
        graph[2].add(new EdgeWeight(2,1,10));
        graph[2].add(new EdgeWeight(2,3,-1));

        graph[3].add(new EdgeWeight(3,1,0));
        graph[3].add(new EdgeWeight(3,2,-1));

    }
}
