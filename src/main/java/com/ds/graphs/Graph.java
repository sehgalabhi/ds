package com.ds.graphs;

public class Graph {

	public int[][] adjancencyMatrix;

	public int nVerts;

	public Vertex vertexList[];

	private final int MAX_VERTS = 20;

	public Graph() {
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

	public void dfs() {
		// start with 0, push it to qeueue
		// keep on getting the adj vertex, mark it visited
		// pop if end

		int indexStart = 0;
		int adjacentVertexInd = indexStart;
		Stack vertexStack = new Stack();
		vertexStack.push(indexStart);
		vertexList[indexStart].isVisited = true;
		vertexList[indexStart].display();
		while (vertexStack.size() > 0) {

			adjacentVertexInd = getAdjUnvisitedVertex(vertexStack.peek());

			if (adjacentVertexInd != -1) {
				vertexStack.push(adjacentVertexInd);
				vertexList[adjacentVertexInd].isVisited = true;
				vertexList[adjacentVertexInd].display();
			} else {

				vertexStack.pop();

			}

		}

		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isVisited = false;
		}
	}

//  A B C D E
//A 0 1 1 1 0	----B----
//B 1 0 0 1 0	A--------D--E
//C 1 0 0 0 0	----C
//D 1 1 0 0 1
//E 0 0 0 1 0
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

	public void bfs() {
		// go to all adjacent vertex and print them and then go to their
		// adjacents
		int indexStart = 0;

		Queue vertexQueue = new Queue();
		vertexQueue.add(indexStart);;
		vertexList[indexStart].isVisited = true;
		vertexList[indexStart].display();
		
		while(!vertexQueue.isEmpty()){
			int adjacentVertex = getAdjUnvisitedVertex(vertexQueue.peek());
			
			if(adjacentVertex != -1){
				vertexQueue.add(adjacentVertex);
				vertexList[adjacentVertex].isVisited = true;
				vertexList[adjacentVertex].display();
			} else{
				adjacentVertex = vertexQueue.remove();
			}
			
			
		}
		for (int i = 0; i < nVerts; i++) {
			vertexList[i].isVisited = false;
		}
		

	}

}
