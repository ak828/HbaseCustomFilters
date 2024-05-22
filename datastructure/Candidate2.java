package com.test.program;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import com.amazonaws.services.rds.model.Range;

import scala.actors.threadpool.Arrays;

public class Candidate2 {

	public static void main(String[] args) {
		int N = 5;
		int M = 3;
		String[] arr_Amount = new String("2 4 2 3 1").split(" ");
		int[] Amount = new int[N];
		for (int i_Amount = 0; i_Amount < arr_Amount.length; i_Amount++) {
			Amount[i_Amount] = Integer.parseInt(arr_Amount[i_Amount]);
		}
		long out_ = magicLand(Amount, M, N);
		PrintWriter wr = new PrintWriter(System.out);
		wr.println(out_);

	}

	static long magicLand(int[] Amount, int M, int N) {
		long res = 1L;
		int rotaleTime = 5;
		// Write your code here
		for (int i = 0; i < rotaleTime; i++) {
			int first = Amount[i];
			for (int j = 0; j < Amount.length - 1; j++) {
				Amount[i] = Amount[j + 1];
			}
			Amount[Amount.length-1] = first;
			System.out.println("> " + Arrays.toString(Amount));

		}
		System.out.println("V " + res);

		return res;

	}
}