package arc104.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String s = sc.next();

		long result = 0;
		for (int i = 0; i < n; i++) {
			int[] count = new int[85];
			for (int j = i + 2; j <= n; j += 2) {

				String sub = s.substring(i, j);
				// System.out.println("��" + sub);

				// ������sub�́AA, T, C, G �̏o���񐔃J�E���g
				count[(int) sub.charAt(sub.length() - 1)]++;
				count[(int) sub.charAt(sub.length() - 2)]++;

				// A��T����������C��G�������Ȃ�A���ʂ��C���N�������g
				if (count[65] == count[84] && count[67] == count[71]) {
					// System.out.println(sub);
					result++;
				}

			}
		}

		System.out.println(result);
	}
}
