package com.test.program;

import java.io.*;
import java.util.*;

public class CandidateCode {
	public static void main(String args[]) throws Exception {
		 System.out.println("Enter N");
//		Scanner N = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		String nextLine = s.nextLine();
		char[] charArray = nextLine.toCharArray();
		
//		String res = callMathod(N.nextInt(), s.nextLine());
		System.out.println(nextLine);
		
	}

	public static String callMathod(int N, String s) {
	
		if (N == 0 || s.isEmpty() || N < 1 || N > 100) {
			N = 7;
			s = "1 2 3 3 4 6 4";
		}
		
		StringBuffer sbtotal = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			StringBuffer append = sbtotal.append(i);
		}

		String[] split = s.split(" ");
		StringBuffer sbpresnt = new StringBuffer();
		for (int i = 0; i <= split.length - 1; i++) {
			sbpresnt.append(split[i]);

		}
		StringBuffer proxy = new StringBuffer();
		for (int i = 1; i <= N; i++) {
			if (sbpresnt.toString().contains(String.valueOf(i))) {

			} else {
				proxy.append(String.valueOf(i) + " ");
			}

		}
		return proxy.toString();
	}

}