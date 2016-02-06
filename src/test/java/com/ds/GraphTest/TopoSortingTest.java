package com.ds.GraphTest;

import com.ds.graphs.TopoSorting;

//   A B C D E
// A 0 1 1 0 0	----B----
// B 0 0 0 1 0	A--------D--E
// C 0 0 0 0 0	----C
// D 0 0 0 0 1
// E 0 0 0 0 0
public class TopoSortingTest {
	public static void main(String[] args) {
		TopoSorting graph = new TopoSorting();
		graph.addVertex("A"); // 0
		graph.addVertex("B"); // 1
		graph.addVertex("C");// 2
		graph.addVertex("D");// 3
		graph.addVertex("E");

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);

		graph.addEdge(1, 3);
		graph.addEdge(3, 4);

		graph.topo();

		
	}
}
