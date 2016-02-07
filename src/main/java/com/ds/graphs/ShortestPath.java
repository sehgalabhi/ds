package com.ds.graphs;

public class ShortestPath {

	public int[][] adjancencyMatrix;

	public int nVerts;

	public Vertex vertexList[];

	private final int MAX_VERTS = 20;

	private PriorityQueue priorityQueue;

	public ShortestPath() {
		vertexList = new Vertex[MAX_VERTS];
		adjancencyMatrix = new int[MAX_VERTS][MAX_VERTS];
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjancencyMatrix[i][j] = 0;
			}
		}
		priorityQueue = new PriorityQueue();
	}

	public void addVertex(String data) {
		Vertex vertex = new Vertex(data);
		vertexList[nVerts++] = vertex;

	}

	public void addEdge(int start, int end, int weight) {
		adjancencyMatrix[start][end] = weight;

	}

	public void displayVertex(int v) {
		vertexList[v].display();
	}

	Edge shortestPath = null;

	public void path() {
		// starting point A
		// find the cheapest path from A
		// store the shortest path
		// from this dest, find the adjoining vertexes
		// find the cheapest path in total from A

		int currentVertex = 0;
		int nTree = 0;
		while (nTree < nVerts - 1) {
			nTree++;
			for (int column = 0; column < nVerts; column++) {
				if (adjancencyMatrix[currentVertex][column] != 0) {
					if (shortestPath != null) {
						int effectiveDistanceFromSouce = adjancencyMatrix[currentVertex][column]
								+ shortestPath.distance;
						int sourceVertex = shortestPath.srcVert;
						putinPQ(sourceVertex, column, effectiveDistanceFromSouce);
					} else {
						putinPQ(currentVertex, column, adjancencyMatrix[currentVertex][column]);
					}

				}
			}

			shortestPath = priorityQueue.removeMin();

			System.out.println("Shortest path" + shortestPath.srcVert + "-->" + shortestPath.destVert + "-->distance"
					+ shortestPath.distance);

			currentVertex = shortestPath.destVert;
		}
	}

	// all entries should be calculated with effective destination of 0 to the
	// current vertex
	//

	// AB 50, AD 80
	// B - AD 80, AC 110, AD 140
	// D AC 110, AC 100, AE 150
	// C AE 140, AE 150
	private void putinPQ(int srcVert, int destVert, int dist) {
		int existingDest = priorityQueue.find(destVert);

		if (existingDest != -1) {
			if (priorityQueue.peekN(existingDest).distance > dist) {
				priorityQueue.removeN(existingDest);
				priorityQueue.insert(new Edge(srcVert, destVert, dist));
			}
		} else {
			priorityQueue.insert(new Edge(srcVert, destVert, dist));
		}
	}

}
