package com.sri.algo.recursion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SuperDigit {
	
	private final static Path SUPER_DIGIT_INPUT = Paths.get(System.getProperty("user.dir"),"/testfiles/superdigitinput.txt");

	public int computeSuperDigit(String n, long k) {
		long p = (long)superDigit(n);	
		p = p * k;	
		return superDigit(String.valueOf(p));
	}

	private int superDigit(String p) {
		if (p.length() == 1) {
			return Integer.valueOf(p);
		}

		Long sd = new Long(0);
		for (char c : p.toCharArray()) {
			sd = sd + Character.getNumericValue(c);
		}

		return superDigit(sd.toString());
	}

	public static void main(String[] args) throws IOException {
		SuperDigit sd = new SuperDigit();
		try (Scanner scanner = new Scanner(Files.newBufferedReader(SUPER_DIGIT_INPUT))) {
			StringBuilder input = new StringBuilder("");
			
			while(scanner.hasNextLine())
			{
				input = input.append(scanner.nextLine());
			}
			System.out.println(sd.computeSuperDigit(input.toString().split(" ")[0], Long.valueOf(input.toString().split(" ")[1])));
		}
		
	}

}
