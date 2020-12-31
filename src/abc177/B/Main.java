package abc177.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();

		int result = 0;
		for (int i = 0; i < s.length() - t.length() + 1; i++) {
			int score = 0;
			for (int j = 0; j < t.length(); j++) {

				//System.out.println(s.substring(i + j, i + j + 1) + " " + t.substring(j, j + 1));
				if (s.substring(i + j, i + j + 1).equals(t.substring(j, j + 1))) {
					score++;
				}
			}
			if (result < score) {
				result = score;
			}
		}

		System.out.println(t.length() - result);

	}
}
