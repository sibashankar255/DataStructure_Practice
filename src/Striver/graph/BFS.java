package Striver.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList < Integer > bfs = new ArrayList < > ();
        boolean vis[] = new boolean[V];
        Queue < Integer > q = new LinkedList < > ();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer it: adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
    /*
The provided code is an implementation of the Breadth-First Search (BFS) algorithm for traversing a graph
 represented using an adjacency list. This BFS algorithm starts from a given source node (in this case, node 0)
 and explores all the reachable nodes in a breadth-first manner. Here's an explanation of the code:

Input Parameters:
int V: The number of vertices in the graph.
ArrayList<ArrayList<Integer>> adj: An adjacency list representing the graph. Each element of the outer
 ArrayList corresponds to a vertex, and its inner ArrayList contains the indices of adjacent vertices.


Initialization:
ArrayList<Integer> bfs: This list will store the vertices visited during the BFS traversal in the
order they are visited.
boolean vis[]: An array to keep track of visited vertices. It is initialized with false for all vertices.
Queue<Integer> q: A queue (implemented using LinkedList) to store vertices for BFS traversal.


Starting BFS from Node 0:
Node 0 is added to the queue, marked as visited, and added to the bfs list as the starting point of the traversal.


BFS Loop:
The while (!q.isEmpty()) loop continues until the queue is empty.
Inside the loop, the algorithm dequeues a vertex (retrieves it from the front of the queue) and stores it
in the node variable.
The node is added to the bfs list since it's being visited.
The code then iterates through all the adjacent vertices of the current node, obtained from the adjacency
list (adj.get(node)).
For each adjacent vertex it, the code checks if it has not been visited (vis[it] == false).
If the adjacent vertex it has not been visited, it is marked as visited (vis[it] = true) and added to the
 queue for further exploration.


Completing the BFS:
Once the BFS traversal is complete, the bfs list will contain the vertices visited in the order they were visited.


Return:
The bfs list is returned as the result of the BFS traversal.


This code performs a basic BFS traversal starting from node 0 and returns a list of vertices visited during
 the traversal. You can call this function with the number of vertices V and the adjacency list adj representing
  your specific graph to perform a BFS traversal on it.
     */
}
