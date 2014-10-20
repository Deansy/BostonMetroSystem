package com.cs308.metro;

import java.util.ArrayList;
import java.util.List;

public class MultiGraph implements GraphADT {

	private List<Node> nodes;
	private List<Edge> edges;

	public MultiGraph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}

	@Override
	public Node getNode(int nodeID) {
		Node node = null;
		for (Node n : nodes) {
			if (n.getNodeID() == nodeID) {
				node = n;
			}
		}

		return node;
	}

	@Override
	public void addNode(Node n) {
		nodes.add(n);

	}

	@Override
	public ArrayList<Node> findRoute(String sourceNode, String destinationNode) {
		ArrayList<Node> route = null;
		return route;
	}

	@Override
	public void addEdge(Edge e) {
		edges.add(e);

	}

}
