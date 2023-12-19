package graph.anuj;

public class Pair implements Comparable<Pair>{
    int vertex;
    int weight;

    Pair(int v, int wt){
        this.vertex=v;
        this.weight=wt;
    }

    @Override
    public int compareTo(Pair that) {
        return this.weight-that.weight;
    }
}
