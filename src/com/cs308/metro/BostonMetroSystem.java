package com.cs308.metro;

import java.util.Scanner;
import java.util.ArrayList;

public class BostonMetroSystem {

	private MultiGraph multiGraph;
	private ArrayList<String> route;

	public void execute() {
		String source = "";
		String destination = "";
		String filename = "bostonmetro.txt";

		try {
			MetroMapParser mmp = new MetroMapParser(filename);
			multiGraph = mmp.generateGraphFromFile();

			System.out.println("=================================");
			System.out.println("=\tBoston Metro System\t=");
			System.out.println("= G11\t\tWelcome!\t=");
			System.out.println("=================================\n\n");

			do {
				// Get the first station name
				System.out.println("Please enter your departure station:\n");
				Scanner sc = new Scanner(System.in);
				source = sc.nextLine();
				if (source.charAt(0) == 'q') {
					System.out.println("Exiting Application");
					System.exit(0);
				}

				// Get the second station name
				System.out.println("Please enter your destination station:\n");
				destination = sc.nextLine();
				if (destination.charAt(0) == 'q') {
					System.out.println("Exiting Application");
					System.exit(0);
				}

				// If both are found then continue, otherwise prompt again
				if (multiGraph.getNodeFromStationName(source) != null
						&& multiGraph.getNodeFromStationName(destination) != null) {

					System.out.println("Calculating route...");
					sc.close();

					// Calculate the route and display it
					route = multiGraph.findRoute(source, destination);
					if (route != null) {
						for (int i = 0; i < route.size(); i++) {
							System.out.println(route);
						}
					} else
						System.out.println("Route is empty!");
				}
			} while (source.charAt(0) != 'q');
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
