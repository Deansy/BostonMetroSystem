package com.cs308.metro;

import java.util.Set;
import java.util.ArrayList;

public interface GraphADT {

	public Set<Node> getNodes();

	public void addNode(Node n);

	public void setNodeRelations(Node node, Set<Node> connectingNodes);

	public Set<Node> getNodeRelations(Node node);

	public ArrayList<Node> findRoute(String sourceNode, String destinationNode);

	public void addEdge(Edge e);

	public Node getNode(int nodeID);

	public Set<Edge> getEdges();

}
