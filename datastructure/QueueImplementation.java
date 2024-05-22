package com.test.program;

import org.apache.commons.lang.ArrayUtils;

public class QueueImplementation {
	int max = 5;
	static int ar[] = new int[5];
	int head = -1;

	public static void main(String[] args) {
		queueFlow();

	}

	private static void queueFlow() {

		QueueImplementation s = new QueueImplementation();
		s.add(1);
		s.add(2);
		s.add(3);
		s.poll();
		s.add(4);
		s.poll();
		s.poll();
		// s.add(5);
		s.add(9);

		s.poll();
		s.poll();
		s.poll();
		s.poll();
		s.poll();
		s.poll();
		s.poll();
	}

	private void add(int i) {
		// System.out.println("added " + ar.length);
		if (head < max - 1) {
			ar[++head] = i;
			System.out.println("added " + i);
		} else {
			System.out.println("Queue is full");
		}
	}

	private int poll() {
		// System.out.println("Top is" + ar[0]);

		int pop = ar[0];
		int[] remove = new int[5];
		remove = ArrayUtils.remove(ar, 0);
		ar = remove;
		
		System.out.println(head);
		return pop;

	}
}
