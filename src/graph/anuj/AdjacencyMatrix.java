package graph.anuj;

public class AdjacencyMatrix {
    public static void main(String[] args) {
        int v=5;
        int e=10;

        int a[][] = new int[v+1][v+1];



    }

    static  void addEdge(int[][]a,int source, int dest){
        a[source][dest] =1;
        a[dest][source]=1;
    }

}
