package com.test.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MrNamanMarks {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // reads String like 10<enter>
		int a = Integer.parseInt(str);
		
		String valueOf = String.valueOf(br.readLine());
		String[] split = br.readLine().split("\\s");

		// int N = 3;
		// String[] NN = { "3", "4", "3" };

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Scanner scan2 = new Scanner(System.in);
		String[] NN = null;
		if (scan2.hasNextInt()) {
			String nextLine = scan2.nextLine();
			NN = scan2.nextLine().trim().split(" ");
		}
		System.out.println("REs" + Arrays.toString(NN));

		Arrays.sort(NN);
		int count = Integer.valueOf(NN[0]);
		int old = Integer.valueOf(NN[0]);

		for (int i = 1; i < NN.length; i++) {
			if (Integer.valueOf(NN[i]) == old) {
				count = count + Integer.valueOf(NN[i]) + 1;
				old = Integer.valueOf(NN[i]);
				// System.out.println("B " + NN[i] + count);
			} else {
				count = count + Integer.valueOf(NN[i]);
				old = Integer.valueOf(NN[i]);
				// System.out.println("A" + count);
			}
		}
		System.out.println("REs" + count);

	}
}
