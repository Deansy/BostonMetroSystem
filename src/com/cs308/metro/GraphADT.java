package com.cs308.metro;
import java.util.ArrayList;

public interface GraphADT {

	public void addNode(Node n);

	public ArrayList<String> findRoute(String sourceNode, String destinationNode);

	public void addEdge(Edge e);

	public Node getNode(int nodeID);


}
