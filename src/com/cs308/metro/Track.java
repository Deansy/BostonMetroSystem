package com.cs308.metro;

public class Track implements Edge{

	
	private String label;
	private int nextNodeID;
	private int previousNodeID;
	
	public Track(int previousID, int nextID, String label) {
		previousNodeID = previousID;
		nextNodeID = nextID;
		this.label = label;
	}

	@Override
	public void setNextNodeID(int value) {
		nextNodeID = value;
		
	}

	@Override
	public int getNextNodeID() {
		return nextNodeID;
	}

	@Override
	public void setPreviousNodeID(int value) {

		previousNodeID = value;
		
	}

	@Override
	public int getPreviousNodeID() {
		return previousNodeID;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

}
