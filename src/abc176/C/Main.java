package abc176.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long array[];
		array = new long[n];
		for (int i = 0; i < n; i++) {
			array[i] = Long.parseLong(sc.next());
		}

		long sum = 0;

		for (int i = 1; i < n; i++) {
			if (array[i - 1] > array[i]) {
				sum += array[i - 1] - array[i];
				array[i] = array[i - 1];
			}
		}

		System.out.println(sum);

	}
}
