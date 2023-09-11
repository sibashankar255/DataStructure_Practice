package graph.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ClientEdge {
    public static void main(String[] args) {
        int v=7;

        ArrayList<Edge>[] graph = new ArrayList[v];

        createGraph(graph);

//        bfs(graph,v);


        boolean vis[] =new boolean[v];

//        dfs(graph,0,vis);

//        for (int i=0; i<v; i++){
//            if (vis[i]==false){
//                dfs(graph,0,vis);
//            }
//        }
//        System.out.println();

//        int src=0,tar=5;
//        printAllPath(graph,new boolean[v],src,"0",tar);


        System.out.println(isCycleDirected(graph,new boolean[v],0,new boolean[v]));




    }



    //
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
        System.out.println(curr+" ");
        vis[curr]=true;

        for (int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if (vis[e.dest]==false){
                dfs(graph,e.dest,vis);
            }
        }
    }
    //path from source to target:- O(v^v)
    public static void printAllPath(ArrayList<Edge> graph[],boolean vis[], int curr, String path, int target){
        if (curr==target){
            System.out.println(path);
            return;
        }
        for (int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if (!vis[e.dest]){
                vis[curr]=true;
                printAllPath(graph,vis,e.dest,path+e.dest,target);
                vis[curr]=false;
            }
        }
    }

    //cycle in directed graph
    public static boolean isCycleDirected(ArrayList<Edge> graph[],boolean vis[], int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;

        for (int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);

            if (rec[e.dest]){
                return true;
            }else if(!vis[e.dest]){
                isCycleDirected(graph,vis,e.dest,rec);
            }
        }
        rec[curr]=false;
        return false;
    }


    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i=0; i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));


    }
}
