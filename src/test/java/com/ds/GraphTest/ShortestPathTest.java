package com.ds.GraphTest;

import com.ds.graphs.ShortestPath;

//   A B C D E F
// A 0 1 0 1 0 	----B----
// B 1 0 1 1 0	A--------D--E
// C 0 0 0 0 0	----C
// D 1 1 0 0 1
// E 0 0 0 1 0
// F
public class ShortestPathTest {
	public static void main(String[] args) {

		ShortestPath graph = new ShortestPath();
		graph.addVertex("A"); // 0
		graph.addVertex("B"); // 1
		graph.addVertex("C");// 2
		graph.addVertex("D");// 3
		graph.addVertex("E"); // 4

		graph.addEdge(0, 1, 50); // AB50
		graph.addEdge(0, 3, 80); // AD80
		graph.addEdge(1, 2, 60); // BC60
		graph.addEdge(1, 3, 90); // BD90
		graph.addEdge(2, 4, 40); // CE40
		graph.addEdge(3, 2, 20); // DC20
		graph.addEdge(3, 4, 70); // DE70
		graph.addEdge(4, 1, 50); // EB50

		graph.path();

	}
}
