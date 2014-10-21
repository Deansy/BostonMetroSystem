package com.cs308.metro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MultiGraph implements GraphADT {

	private List<Node> nodes;
	private List<Edge> edges;

	public MultiGraph() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}

	@Override
	public void addNode(Node n) {
		nodes.add(n);

	}

	@Override
	public ArrayList<Node> findRoute(Node sourceNode, Node destinationNode) {
		// if start = end. stop. return null
		if (sourceNode.equals(destinationNode)) {
			System.out
					.println("Error: Source station identical to destination station");
			return null;
		}

		// To store directions to show the user
		ArrayList<Node> directionOutput = new ArrayList<Node>();
		Queue<Node> unvisited = new LinkedList<Node>(); // done
		HashMap<Node, Node> route = new HashMap<Node, Node>();
		List<Node> visited = new LinkedList<Node>();

		Node currentStation = sourceNode;

		unvisited.add(currentStation);
		visited.add(currentStation);

		while (!unvisited.isEmpty()) {
			currentStation = unvisited.remove();
			if (currentStation.equals(destinationNode)) {
				break;
			} else {
				for (Node n : getAdjacentNodes(currentStation)) {
					if (!visited.contains(n)) {
						visited.add(n);
						unvisited.add(n);
						route.put(n, currentStation);
					}
				}
			}
		}

		// If there is no route
		if (currentStation.equals(destinationNode) == false) {
			System.out.println("A route was not found");
			return null;
		} else {
			for (Node n = destinationNode; n != null; n = route.get(n)) {
				directionOutput.add(n);
			}
			Collections.reverse(directionOutput);
			return directionOutput;
		}
	}

	@Override
	public void addEdge(Edge e) {
		edges.add(e);
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

	public Node getNodeFromStationName(String stationName) {
		for (Node n : nodes) {
			if (n.getNodeLabel().toLowerCase()
					.compareTo(stationName.toLowerCase()) == 0) {
				return n;
			}
		}
		System.out.println("Error: station not found");
		return null;
	}

	public Boolean isEdge(String firstNode, String secondNode) {
		for (Edge e : edges) {
			if ((e.getPreviousNodeID() == Integer.parseInt(firstNode))
					&& e.getNextNodeID() == (Integer.parseInt(secondNode))) {
				return true;
			}

		}
		return false;
	}

	public ArrayList<Node> getAdjacentNodes(Node n) {
		ArrayList<Node> ajacentNodes = new ArrayList<Node>();
		for (Node n2 : nodes) {
			if (isEdge(Integer.toString(n.getNodeID()),
					Integer.toString(n2.getNodeID()))) {
				ajacentNodes.add(n2);
			} else if (isEdge(Integer.toString(n2.getNodeID()),
					Integer.toString(n.getNodeID()))) {
				ajacentNodes.add(n2);
			}
		}
		return ajacentNodes;
	}

}
