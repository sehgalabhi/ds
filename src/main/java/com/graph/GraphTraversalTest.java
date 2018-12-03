package com.graph;

import com.bellid.util.StringUtilities;

class GraphTraversalTest {

    public static void main(String[] args) {
        new GraphTraversalTest().test();
    }

    private void test() {

        Graph graph = getAdjacencyListGraph();

        GraphPaths graphPaths = new GraphPaths(graph, 0);
//        graphPaths.pathTo(0);
        graphPaths.pathTo(2);


//        System.out.println(graph);


    }

    private Graph getAdjacencyListGraph() {
        Graph graph = new AdjacencyListGraph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        return graph;
    }
}
