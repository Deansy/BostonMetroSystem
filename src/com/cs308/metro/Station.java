package com.cs308.metro;

public class Station implements Node{

	
	public Station(int stationID, String stationName) {
		nodeID = stationID;
		nodeLabel = stationName;
	}
	
	private int nodeID;
	private String nodeLabel;
   
   
	public void setNodeID(int id) {
		nodeID = id;
	}

	
	public int getNodeID() {
		return nodeID;
	}


	public void setNodeLabel(String label) {
		nodeLabel = label;
		
	}


	public String getNodeLabel() {
		return nodeLabel;
	}

//	public Boolean isEqual(Node n){
//		return ((nodeID == n.getNodeID()) && (nodeLabel.equals(n.getNodeLabel())));
//	}

}
