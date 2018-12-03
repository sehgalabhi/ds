package com.graph;

import java.util.List;

public interface Graph{

    void addEdge(Integer v, Integer w);

    List<Integer> adj(int v);

    int numVertices();

    int numEdges();

    /*int degree(Graph<T> g, int v);

    int maxDegree(Graph<T> g);

    double averageDegree(Graph<T> g);

    int numberOfSelfLoops(Graph<T> g);*/
}
