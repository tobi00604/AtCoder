package agc016.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		int result = input.length();
		for (int i = 0; i < input.length(); i++) {

			int cost = 0;
			int maxCost = 0;
			for (int j = 0; j < input.length(); j++) {
				if (input.charAt(j) == input.charAt(i)) {
					cost = 0;
				} else {
					cost++;
					maxCost = Math.max(maxCost, cost);
				}
			}
			result = Math.min(result, maxCost);

		}

		System.out.println(result);

	}
}
