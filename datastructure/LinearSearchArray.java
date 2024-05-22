package com.test.program.ds;

/* IMPORTANT: Multiple classes and nested static classes are supported */
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

public class LinearSearchArray {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NN = br.readLine().split("\\s");
		int N = Integer.parseInt(NN[0]);
		int M = Integer.parseInt(NN[1]);
		String[] Ai = br.readLine().split("\\s");
		int last = -1;

		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(Ai[i]) == M) {
				last = i;
			}
		}
		System.out.println( last);
	}
}
