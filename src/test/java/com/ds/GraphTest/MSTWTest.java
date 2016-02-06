package com.ds.GraphTest;

import com.ds.graphs.MSTW;

//   A B C D E F
// A 0 1 0 1 0 	----B----
// B 1 0 1 1 0	A--------D--E
// C 0 0 0 0 0	----C
// D 1 1 0 0 1
// E 0 0 0 1 0
// F
public class MSTWTest {
	public static void main(String[] args) {

		MSTW graph = new MSTW();
		graph.addVertex("A"); // 0
		graph.addVertex("B"); // 1
		graph.addVertex("C");// 2
		graph.addVertex("D");// 3
		graph.addVertex("E"); // 4
		graph.addVertex("F"); // 5

		graph.addEdge(0, 1, 6); // AB6
		graph.addEdge(0, 3, 4); // AD4
		graph.addEdge(1, 2, 10); // BC10
		graph.addEdge(1, 3, 7); // BD7
		graph.addEdge(1, 4, 7); // BE7
		graph.addEdge(2, 3, 8); // CD8
		graph.addEdge(2, 4, 5); // CE5
		graph.addEdge(2, 5, 6); // CF6
		graph.addEdge(3, 4, 12); // DE12
		graph.addEdge(4, 5, 7); // EF7

		graph.mstw();

	}
}
