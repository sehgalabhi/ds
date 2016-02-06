package com.ds.graphs;

public class MSTW {

	public int[][] adjancencyMatrix;

	public int nVerts;

	public Vertex vertexList[];

	private final int MAX_VERTS = 20;

	private PriorityQueue priorityQueue;

	public MSTW() {
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
		adjancencyMatrix[end][start] = weight;
	}

	public void displayVertex(int v) {
		vertexList[v].display();
	}

	public void mstw() {
		// get all the adjacent Vertex
		// find the shortest vertexes put them in PQ
		int currentVertex = 0;
		int nTree = 0;

		while (nTree < nVerts - 1) {
			vertexList[currentVertex].isVisited = true;
			for (int column = 0; column < nVerts; column++) {
				if (!vertexList[column].isVisited && currentVertex != column
						&& adjancencyMatrix[currentVertex][column] != 0) {
					putinPQ(currentVertex, column, adjancencyMatrix[currentVertex][column]);
				}
			}
			nTree++;
			vertexList[priorityQueue.peekMin().srcVert].display();
			vertexList[priorityQueue.peekMin().destVert].display();
			System.out.println(" ");

			currentVertex = priorityQueue.peekMin().destVert;

			priorityQueue.removeMin();
		}

	}

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

	// A B C D E
	// A 0 1 1 1 0 ----B----
	// B 1 0 0 1 0 A--------D--E
	// C 1 0 0 0 0 ----C
	// D 1 1 0 0 1
	// E 0 0 0 1 0
	public int getAdjUnvisitedVertex(int n) {
		int adjacentVertexIndex = -1;
		for (int i = 0; i < nVerts; i++) {
			if (adjancencyMatrix[n][i] == 1 && !vertexList[i].isVisited) {
				adjacentVertexIndex = i;
				break;
			}
		}
		return adjacentVertexIndex;

	}

}
