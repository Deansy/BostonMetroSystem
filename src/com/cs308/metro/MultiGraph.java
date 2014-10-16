package com.cs308.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MultiGraph implements GraphADT {

	private MetroMapParser metroMapParser;
	private Set<Node> nodes;
	private Set<Edge> edges;
	private HashMap<Node, Set<Node>> nodeRelations;

	MultiGraph() {
		try {
			metroMapParser = new MetroMapParser("bostonmetro.txt");
			nodeRelations = metroMapParser.generateGraphFromFile();

			nodes = metroMapParser.getStations();
			edges = metroMapParser.getTracks();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public Set<Node> getNodeRelations(Node node) {
		return nodeRelations.get(node);
	}

	@Override
	public Set<Node> getNodes() {
		return nodes;
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

		return null;
	}


	@Override
	public void addEdge(Edge e) {
		edges.add(e);

	}

	@Override
	public Set<Edge> getEdges() {
		//
		return edges;
	}

	@Override
	public void setNodeRelations(Node node, Set<Node> connectingNodes) {

		nodeRelations.put(node, connectingNodes);

	}

}
