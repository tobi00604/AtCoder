package abc171.E;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String a[];
		a = new String[n];
		int one[];
		one = new int[31];

		// ���͂��󂯂�2�i���ɕϊ��A����ɕϊ���̊e�ʂ�1�̐����������ǂ������ێ�
		for (int i = 0; i < n; i++) {
			a[i] = Long.toBinaryString(Long.parseLong(sc.next()));
			a[i] = String.format("%30s", a[i]).replace(" ", "0");
			// System.out.println(a[i]);

			for (int j = 0; j < 30; j++) {
				if (a[i].charAt(j) == '1') {
					one[j]++;
				}
			}
		}

		// System.out.println("-");
		// for (int j = 0; j < 30; j++) {
		// System.out.print(one[j]);
		// }
		// System.out.println("-");

		// one[]����̂Ƃ��낾��0/1�𔽓]�������̂�����
		StringBuilder result = new StringBuilder(" ");
		for (int i = 0; i < n; i++) {

			StringBuilder str = new StringBuilder();

			for (int j = 0; j < 30; j++) {
				if (one[j] % 2 == 0) {
					str.append(a[i].charAt(j));
				} else {
					if (a[i].charAt(j) == '0') {
						str.append("1");
					} else {
						str.append("0");
					}
				}
			}
			result.append(" ").append(Integer.parseInt(str.toString(), 2));
		}

		System.out.println(result.toString().replace("  ", ""));
	}
}
