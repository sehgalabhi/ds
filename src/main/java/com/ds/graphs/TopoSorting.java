package com.ds.graphs;

public class TopoSorting {

	public int[][] adjancencyMatrix;

	public int nVerts;

	public Vertex vertexList[];

	private final int MAX_VERTS = 20;

	public TopoSorting() {
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

	}

	public void displayVertex(int v) {
		vertexList[v].display();
	}

	public void topo() {

		int nVertex = vertexList.length;
		String sortedArray[] = new String[nVerts];

		while (nVerts > 0) {

			int noSuccessorIndex = noSuccessor();

			if (noSuccessorIndex == -1) {
				System.out.println("Graph has a cycle");
				break;
			}
			sortedArray[nVerts - 1] = vertexList[noSuccessorIndex].data;
			deleteVertex(noSuccessorIndex);
			

		}

		System.out.println("Topological Order");
		for (int i = 0; i < sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
	}

	private void deleteVertex(int noSuccessorIndex) {
		if (noSuccessorIndex != nVerts - 1) {
			// delete from vertex
			for (int i = noSuccessorIndex; i < nVerts - 1; i++) {
				vertexList[i] = vertexList[i + 1];
			}

			// remove row
			for (int row = noSuccessorIndex; row < nVerts - 1; row++) {
				moveUp(row, nVerts);
			}

			// remove column

			for (int column = noSuccessorIndex; column < nVerts - 1; column++) {
				moveLeft(column, nVerts - 1);
			}
		}

		nVerts--;
	}

	private void moveUp(int row, int nVerts) {
		for (int i = 0; i < nVerts; i++) {
			adjancencyMatrix[row][i] = adjancencyMatrix[row + 1][i];
		}
	}

	private void moveLeft(int column, int nVerts) {
		for (int i = 0; i < nVerts; i++) {
			adjancencyMatrix[i][column] = adjancencyMatrix[i][column + 1];
		}
	}

	// A B C D E
	// A 0 1 1 1 0 ----B----
	// B 1 0 0 1 0 A--------D--E
	// C 1 0 0 0 0 ----C
	// D 1 1 0 0 1
	// E 0 0 0 1 0
	public int noSuccessor() {
		int noSuccessorIndex = -1;
		for (int row = 0; row < nVerts; row++) {
			boolean isEdge = false;

			for (int column = 0; column < nVerts; column++) {
				if (row != column && adjancencyMatrix[row][column] == 1) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge) {
				noSuccessorIndex = row;
			}
		}
		return noSuccessorIndex;

	}

}
