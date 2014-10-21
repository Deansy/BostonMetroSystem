package com.cs308.metro;

import java.util.Scanner;
import java.util.ArrayList;

public class BostonMetroSystem {

	private MultiGraph multiGraph;
	private ArrayList<String> route;

	public void execute() {
		String source = "";
		String destination = "";
		Node sourceNode = null;
		Node destinationNode = null;
		String filename = "bostonmetro.txt";

		try {
			MetroMapParser mmp = new MetroMapParser(filename);
			multiGraph = mmp.generateGraphFromFile();

			System.out.println("=================================");
			System.out.println("=\tBoston Metro System\t=");
			System.out.println("= G11\t\tWelcome!\t=");
			System.out.println("=================================\n\n");
			Scanner sc = new Scanner(System.in);

			do {
				// Get the first station name
				System.out.println("Please enter your departure station:\n");
				source = sc.nextLine();
				if (source.equals("quit")) {
					System.out.println("Exiting Application");
					System.exit(0);
				}

				// Get the second station name
				System.out.println("Please enter your destination station:\n");
				destination = sc.nextLine();
				if (destination.equals("quit")) {
					System.out.println("Exiting Application");
					System.exit(0);
				}

				// If both are found then continue, otherwise prompt again
				if (multiGraph.getNodeFromStationName(source) != null
						&& multiGraph.getNodeFromStationName(destination) != null) {

					System.out.println("Calculating route...");

					// Calculate the route and display it
					sourceNode = multiGraph.getNodeFromStationName(source);
					destinationNode = multiGraph
							.getNodeFromStationName(destination);

					// TestData
					// System.out.println("source" + sourceNode);
					// System.out.println("dest:" + destinationNode);

					route = multiGraph.findRoute(sourceNode, destinationNode);
					if (route != null) {
						for (int i = 0; i < route.size(); i++) {
							System.out.println(route);
						}
					} else
						System.out.println("Route is empty!");
				} else {
					System.out.println("Please enter two valid station names.");
				}
			} while (source != "quit" || destination != "quit");
			sc.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
