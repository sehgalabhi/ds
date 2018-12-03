package com.graph;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdjacencyMatrixGraph implements Graph{

    private final int numVertices;

    private int[][] adjMatrix;

    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }

    @Override
    public void addEdge(Integer w, Integer v) {
        adjMatrix[w][v] = 1;
        adjMatrix[v][w] = 1;
    }

    @Override
    public List<Integer> adj(int w) {
        int[] adjMatrix = this.adjMatrix[w];
        return Arrays.stream(adjMatrix).boxed().collect(Collectors.toList());

    }

    @Override
    public int numVertices() {
        return numVertices;
    }

    @Override
    public int numEdges() {
        return 0;
    }

}

