package com.test.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MrNamanMarksCode {
	/*
	 * Input 1. First-line contains N, the total number of questions in the paper 2.
	 * Second-line contains N space-separated integers (sorted) A1, A2 ... An
	 * representing the original marks assigned to every question
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] NN = br.readLine().split("\\s");

		Arrays.sort(NN);

		int count = Integer.valueOf(NN[0]);
		int old = Integer.valueOf(NN[0]);

		for (int i = 1; i < NN.length; i++) {
			if (Integer.valueOf(NN[i]) == old) {
				count = count + Integer.valueOf(NN[i]) + 1;
				old = Integer.valueOf(NN[i]);
			} else {
				count = count + Integer.valueOf(NN[i]);
				old = Integer.valueOf(NN[i]);
			}
		}
		System.out.println(count);
	}
}
