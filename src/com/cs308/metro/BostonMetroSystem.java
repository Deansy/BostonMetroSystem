package com.cs308.metro;

import java.util.Scanner;
import java.util.ArrayList;

public class BostonMetroSystem {

	private  MultiGraph multiGraph;
	private  ArrayList<Node> route;

	public void execute() {
		String source = "";
		String destination = "";
		String filename = "bostonmetro.txt";

		try {
			MetroMapParser mmp = new MetroMapParser(filename);
			multiGraph = mmp.generateGraphFromFile();
			System.out.println("===================================");
			System.out.println("=      Boston Metro System        =");
			System.out.println("=           Welcome!              =");
			System.out.println("===================================\n\n");

			System.out.println("Please enter your departure station:\n");
			Scanner sc = new Scanner(System.in);
			source = sc.nextLine(); // validation

			System.out.println("Please enter your destination station:\n");
			destination = sc.nextLine(); // validation

			System.out.println("Calculating route...");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		route = multiGraph.findRoute(source, destination);
		if (route != null) {
			for (int i = 0; i < route.size(); i++) {
				System.out.println(route);
			}
		} else
			System.out.println("Route is empty!");

	}
}
