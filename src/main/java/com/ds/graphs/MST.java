package com.ds.graphs;

public class MST {

	public int[][] adjancencyMatrix;

	public int nVerts;

	public Vertex vertexList[];

	private final int MAX_VERTS = 20;

	public MST() {
		vertexList = new Vertex[MAX_VERTS];
		adjancencyMatrix = new int[MAX_VERTS][MAX_VERTS];
		for (int i = 0; i < MAX_VERTS; i++) {
			for (int j = 0; j < MAX_VERTS; j++) {
				adjancencyMatrix[i][j] = 0;
			}
		}
	}

	public void addVertex(String data) {
		Vertex vertex = new Vertex(data);
		vertexList[nVerts++] = vertex;

	}

	public void addEdge(int start, int end) {
		adjancencyMatrix[start][end] = 1;
		adjancencyMatrix[end][start] = 1;
	}

	public void displayVertex(int v) {
		vertexList[v].display();
	}

	public void mst() {
		// start with 0, push it to qeueue
		// keep on getting the adj vertex, mark it visited
		// pop if end

		int indexStart = 0;
		int adjacentVertexInd = indexStart;
		Stack vertexStack = new Stack();
		vertexStack.push(indexStart);
		vertexList[indexStart].isVisited = true;
		
		while (vertexStack.size() > 0) {
			int currentVertexInd = vertexStack.peek();
			adjacentVertexInd = getAdjUnvisitedVertex(currentVertexInd);

			if (adjacentVertexInd != -1) {
				vertexStack.push(adjacentVertexInd);
				vertexList[adjacentVertexInd].isVisited = true;
				vertexList[currentVertexInd].display();
				vertexList[adjacentVertexInd].display();
				System.out.println(" ");
			} else {

				vertexStack.pop();

			}

		}

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isVisited = false;
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
