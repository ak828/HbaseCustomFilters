package com.test.program;

public class BinarySearchTree {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 8, 10 };
		int r = binarySearch(arr, 1, 6, 4);
		System.out.println("> " + r);

	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		int mid = (low + high) / 2;

		while (low <= high) {
			if (arr[mid] < key) {
				low = mid + 1;
			} else if (arr[mid] == key) {
				return mid;
			} else {
				high = mid - 1;
			}
			mid = (low + high) / 2;
		}
		if (low > high) {
			return -1;
		}
		return -1;
	}

}
