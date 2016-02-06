package com.ds.graphs;

public class Edge {
	public int srcVert;

	public int destVert;

	public int distance;
	
	public Edge(int srcVert, int destVert , int dist) {
		this.srcVert = srcVert;
		this.destVert = destVert;
		this.distance = dist;
	}
}
