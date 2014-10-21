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
	public ArrayList<String> findRoute(String sourceNode, String destinationNode) {

		// if start = end. stop. return null
		if (sourceNode.equals(destinationNode)) {
			System.out
					.println("Error: Source station identical to destination station");
			return null;
		}
		// route to return
		ArrayList<String> directions = new ArrayList<String>();
		// list of visited nodes
		HashMap<Node, Boolean> visitedNodes = new HashMap<Node, Boolean>();
		HashMap<Node, Node> previous = new HashMap<Node, Node>(); // ?????????????
		// Queue for nodes to be held
		Queue<Node> queue = new LinkedList<Node>();
		// hold the start node
		Node startNode = getNodeFromStationName(sourceNode);
		// hold the end node
		Node endNode = getNodeFromStationName(destinationNode);
		// current node initialiser
		Node currentNode = startNode;
		// add current node to queue
		queue.add(currentNode);
		// add current node to the visited hashmap
		visitedNodes.put(currentNode, true);

		// while there is something in the queue
		while (queue.isEmpty() == false) {
			// currentNode = whatever is at the front of the queue
			currentNode = queue.poll();

			// if currentNode label matches endNode label then stop
			if (currentNode.getNodeLabel().equals(endNode.getNodeLabel())) {
				break;

				// otherwise
			} else {

				// arraylist to hold adjacentNodes
				ArrayList<Node> ajdNodes = getAdjacentNodes(currentNode);

				// for each of the adjacent nodes
				for (int i = 0; i < ajdNodes.size(); i++) {
					// if they do not contain keys
					if (!visitedNodes.containsKey(ajdNodes.get(i))) {
						// for each node in the List of Nodes
						for (Node n : nodes) {
							// if the node label matches the adjacent node label
							// or the node ID matches the adjacent node ID
							if ((n.getNodeLabel().equals(ajdNodes.get(i)
									.getNodeLabel()))
									|| n.getNodeID() == ajdNodes.get(i)
											.getNodeID()) {
								// add adjacent node to queue
								queue.add(ajdNodes.get(i));
								// add adjacent node and visited indicator to
								// visited map
								visitedNodes.put(ajdNodes.get(i), true);
								// add current node and adjacentNode pair to
								// previous
								previous.put(currentNode, ajdNodes.get(i));
							}
						}
					}
				}
			}

		}

		// from the start node until node is null,
		for (Node node = startNode; node != null; node = previous.get(node)) {
			// add previous node to directions
			directions.add(node.getNodeLabel());
		}
		// return directions
		return directions;

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

	public Node getNodeFromStationName(String stationName) {
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

	public Boolean isEdge(String firstNode, String secondNode) {
		for (Edge e : edges) {
			if ((e.getPreviousNodeID() == Integer.parseInt(firstNode))
					&& e.getNextNodeID() == (Integer.parseInt(secondNode))) {
				return true;
			}

		}
		return false;
	}

}
