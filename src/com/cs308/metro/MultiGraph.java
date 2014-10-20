package com.cs308.metro;

import java.util.ArrayList;
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
	/*
	 * public ArrayList<Node> findRoute(String sourceNode, String
	 * destinationNode) { ArrayList<Node> route = null;
	 * 
	 * // code here //
	 * =========================================================================
	 * if (sourceNode.equals(destinationNode)) { System.out
	 * .println("Error: Source station identical to destination station");
	 * return null; } //LinkedList<String> directions = new
	 * LinkedList<String>(); HashMap<Node, Boolean> visitedNodes = new
	 * HashMap<Node, Boolean>(); HashMap<Node, Node> previous = new
	 * HashMap<Node, Node>(); Queue<Node> queue = new LinkedList<Node>(); Node
	 * startNode = getNodeFromStationName(sourceNode); Node endNode =
	 * getNodeFromStationName(destinationNode); Node currentNode = startNode;
	 * queue.add(currentNode); visitedNodes.put(currentNode, true);
	 * 
	 * while (queue.isEmpty() == false) { currentNode = queue.poll(); if
	 * (currentNode.getNodeLabel().equals(endNode.getNodeLabel())) { break; }
	 * else { ArrayList<Node> ajdNodes = getAdjacentNode(currentNode); for (int
	 * i = 0; i < ajdNodes.size(); i++) { if
	 * (!visitedNodes.containsKey(ajdNodes.get(i))) { for (Node n : nodes) { if
	 * ((n.getNodeLabel().equals(ajdNodes.get(i) .getNodeLabel())) ||
	 * n.getNodeID() == ajdNodes.get(i) .getNodeID()) {
	 * queue.add(ajdNodes.get(i)); visitedNodes.put(ajdNodes.get(i), true);
	 * previous.put(currentNode, ajdNodes.get(i)); } } } } } // end here //
	 * =========================================================================
	 * } return route; }
	 */
	public ArrayList<String> findRoute(String sourceNode, String destinationNode) {
		if (sourceNode.equals(destinationNode)) {
			System.out
					.println("Error: Source station identical to destination station");
			return null;
		}
		ArrayList<String> directions = new ArrayList<String>();
		HashMap<Node, Boolean> visitedNodes = new HashMap<Node, Boolean>();
		HashMap<Node, Node> previous = new HashMap<Node, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		Node startNode = getNodeFromStationName(sourceNode);
		Node endNode = getNodeFromStationName(destinationNode);
		Node currentNode = startNode;
		queue.add(currentNode);
		visitedNodes.put(currentNode, true);

		while (queue.isEmpty() == false) {
			currentNode = queue.poll();
			if (currentNode.getNodeLabel().equals(endNode.getNodeLabel())
					&& currentNode.getNodeID() == endNode.getNodeID()) {
				break;
			} else {
				ArrayList<Node> ajdNodes = getAdjacentNode(currentNode);
				for (int i = 0; i < ajdNodes.size(); i++) {
					if (!visitedNodes.containsKey(ajdNodes.get(i))) {
						for (Node n : nodes) {
							if ((n.getNodeLabel().equals(ajdNodes.get(i)
									.getNodeLabel()))) {
								queue.add(n);
								visitedNodes.put(ajdNodes.get(i), true);
								previous.put(currentNode, ajdNodes.get(i));
							}
						}
					}
				}
			}

		}
		for (Node node = startNode; node != null; node = previous.get(node)) {
			directions.add(node.toString());
		}
		return directions;
	}

	private ArrayList<Node> getAdjacentNode(Node currentNode) {
		ArrayList<Node> ajacentNodes = new ArrayList<Node>();
		for (Node n2 : nodes) {
			if (isEdge(Integer.toString(currentNode.getNodeID()),
					Integer.toString(n2.getNodeID()))) {
				ajacentNodes.add(n2);
			}
		}
		return ajacentNodes;
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

	private Node getNodeFromStationName(String stationName) {
		for (Node n : nodes) {
			if (n.getNodeLabel().equals(stationName)) {
				return n;
			}
		}
		System.out.println("Error: station not found");
		return null;
	}

	@Override
	public void addEdge(Edge e) {
		edges.add(e);

	}

}
