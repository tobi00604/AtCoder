package abc151.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		// �����ς݂̖��ԍ�
		ArrayList<Integer> list;
		list = new ArrayList<Integer>();

		long result1 = 0;
		long result2 = 0;

		for (int i = 0; i < m; i++) {

			int p = Integer.parseInt(sc.next());
			String s = sc.next();

			// �����ς݂̖��ɑ΂����o�͖���
			if (list.contains(p)) {
				continue;
			}

			if (s.equals("AC")) {
				result1++;
				list.add(p);
			} else {
				result2++;
			}

		}

		System.out.println(result1 + " " + result2);
	}
}
