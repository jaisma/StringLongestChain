package com.jys.practice;

import java.util.Scanner;

import com.jys.practice.chain.StringLongestChain;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Input size:");
			int librarySize = Integer.parseInt(scanner.nextLine());
			String[] library = new String[librarySize];
			System.out.println("Library words:");
			for (int i = 0; i < librarySize; ++i) {
				// create string[] of input. assume good input
				library[i] = scanner.nextLine();
			}
			StringLongestChain stringLongestChain = new StringLongestChain();
			int longestChain = stringLongestChain.getLongestChain(library);
			System.out.println(longestChain);
		}
	}
}
