package com.cs308.metro;

import java.util.Scanner;

public class BostonMetroSystem {

	private MultiGraph multiGraph;

	public MultiGraph getMultiGraph() {
		// not initialised anywhere
		return this.multiGraph;
	}

	public static void main(String[] args) {
		String source = "";
		String destination = "";
		BostonMetroSystem bms = null;

		try {
			bms = new BostonMetroSystem();
			bms.getMultiGraph();

		} catch (Exception e) {
			e.printStackTrace();
		}

        bms.multiGraph = new MultiGraph();

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
		bms.getMultiGraph().findRoute(source, destination);
		System.out.println("Route Calculated!");

		sc.close();

	}
}
