package com.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {

    private final int numVeritces;

    private List<Integer>[] adjacenyList;

    public AdjacencyListGraph(int numVeritces) {
        this.numVeritces = numVeritces;
        adjacenyList = new List[numVeritces];
        for (int i = 0; i < numVeritces; i++) {
            adjacenyList[i] = new ArrayList<Integer>();
        }
    }

    @Override
    public void addEdge(Integer v, Integer w) {
        adjacenyList[v].add(w);
        adjacenyList[w].add(v);
    }

    @Override
    public List<Integer> adj(int v) {
        return adjacenyList[v];
    }

    public int numVertices() {
        return numVeritces;
    }

    public int numEdges() {
        return 0;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AdjacencyListGraph{} --> \n");

        for (int i = 0; i < adjacenyList.length; i++) {
            stringBuffer.append(String.format("Vertex %s --> %s \n", i, adjacenyList[i]));

        }

        return stringBuffer.toString();
    }
}
