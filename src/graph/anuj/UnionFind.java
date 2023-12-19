package graph.anuj;

import java.util.*;

public class UnionFind {
    public static void main(String[] args) {

    }

    //detect a cycle in a directed graph
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[v];

        for (int i=0; i<v; i++){
            if (!vis[i]){
                if (dfsIsCycle(i,adj,vis,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsIsCycle(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent) {
        vis[v] =true;

        for (Integer neighbour : adj.get(v)){
            if (!vis[neighbour]){
                if (dfsIsCycle(neighbour,adj,vis,v)){
                    return true;
                }
                else if (parent != neighbour) {
                    return true;
                }
            }
        }
        return false;
    }
    //547. Number of Provinces
    /**
     * create a boolean array visited
     * traverse the row wise and check which other components it is connected with
     * isConnected[city][neighbour]==1
     * and make the particular index as visited[i] =true
     *
     * if any index is not visited then increase the province count
     *
     */
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int province=0;
        for (int i=0; i<n; i++){
            if (visited[i]){
                dfsProvince(isConnected,visited,i);
                province++;
            }
        }
        return province;
    }
    private static void dfsProvince(int[][] isConnected, boolean[] visited, int city){
        visited[city]=true;

        for (int neighbour=0; neighbour<isConnected.length; neighbour++){
            if (isConnected[city][neighbour]==1 && !visited[neighbour]){
                dfsProvince(isConnected,visited,neighbour);
            }
        }
    }

    //684. Redundant Connection
//    public int[] findRedundantConnection(int[][] edges) {
//        int[] parent = new int[1000];
//
//        for (int i=0; i<1000; i++){
//            parent[i]=i;
//        }
//
//        for (int[] edge : edges){
//            int f =edge[0];
//            int t =edge[1];
//
//            if (find(parent,f) == find(parent,t)){
//                return edge; // same disjoint set
//            }else {
//                parent[find(parent,f)] = find(parent,t);
//            }
//        }
//
//        return new int[2];
//    }
//    private int find(int[] parent, int x){
//
//        if (x != parent[x]){
//            parent[x] = find(parent, parent[x]);
//        }
//        return parent[x];
//    }

    //disjoint set
    /**
     * the use this we are making 2 operations
     * union and find
     *
     *
     */


    static int[] parent = new int[1000];
    public static int disJoint(int[][] edges){

        for (int i=1; i<=edges.length; i++){
            parent[i]=i;
        }
        return 0;
    }

    int find(int x){
        if (parent[x]==x){
            return x;
        }
        return find(parent[x]);
    }

    void union(int a, int b){
        int x= find(a);
        int y =find(b);
        if (x==y){
            return;
        }
        parent[y]=x;
    }




}
