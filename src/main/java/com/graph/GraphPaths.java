package com.graph;


import java.util.Stack;
import java.util.stream.Collectors;

public class GraphPaths {

    private final Graph graph;
    private final int source;
    private final boolean[] marked;
    private int[] edgeTo;


    public GraphPaths(Graph graph, int source) {
        this.graph = graph;
        this.source = source;
        marked = new boolean[graph.numVertices()];
        edgeTo = new int[graph.numVertices()];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public void depthFirstSearch() {

        dfs(source);


    }

    private void dfs(int source) {

        Stack<Integer> integers = new Stack<>();
        integers.addAll(integers);
        for (Integer s :
                integers) {
            if (!marked[s]) {
                marked[s] = true;
                edgeTo[s] = source;
                dfs(s);
            }
        }

    }

    Iterable<Integer> pathTo(int target) {
        if (!hasPathTo(target)) {
            return null;
        }

        Stack<Integer> tempPath = new Stack<>();

        for (int i = target; i != source; i = edgeTo[i]) {
            tempPath.push(i);
        }
        System.out.println(tempPath.stream().map(t -> String.valueOf(t)).collect(Collectors.joining("--")));


        return null;
    }


}



