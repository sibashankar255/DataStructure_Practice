package Striver.graph;

public class Pair implements Comparable<Pair> {
    int v;
    int wt;
    Pair(int v,int wt){
        this.v=v;
        this.wt=wt;
    }

    @Override
    public int compareTo(Pair that) {
        return this.wt - that.v;
    }
}
