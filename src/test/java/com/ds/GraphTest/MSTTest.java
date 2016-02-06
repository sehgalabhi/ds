package com.ds.GraphTest;

import com.ds.graphs.Graph;
import com.ds.graphs.MST;

//   A B C D E
// A 0 1 1 1 0	----B----
// B 1 0 0 1 0	A--------D--E
// C 1 0 0 0 0	----C
// D 1 1 0 0 1
// E 0 0 0 1 0
public class MSTTest {
	public static void main(String[] args) {
		MST graph = new MST();
		graph.addVertex("A");  //0
		graph.addVertex("B"); //1
		graph.addVertex("C");//2
		graph.addVertex("D");//3
		graph.addVertex("E");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 3);
		graph.addEdge(3,4);
		
		graph.mst();
		
		
	}
}
