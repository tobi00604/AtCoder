package abc082.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();

		// �R�[�i�[�P�[�X�@�Ђ��킯��No
		if (input1.equals(input2)) {
			System.out.println("No");
		}

		// �����₷�����邽�߂ɐ����̔z��ɂ���
		int[] a = new int[input1.length()];
		int[] b = new int[input2.length()];
		for (int i = 0; i < input1.length(); i++) {
			a[i] = input1.charAt(i) - 96;
		}
		Arrays.sort(a);
		for (int i = 0; i < input2.length(); i++) {
			b[i] = input2.charAt(i) - 96;
		}
		Arrays.sort(b);
		int[] c = new int[input2.length()];
		for (int i = 0; i < input2.length(); i++) {
			c[i] = b[input2.length() - i - 1];
		}
		b = c;

		// �m�F�p
		// System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(b));

		// ���s����
		for (int i = 0; i < Math.max(a.length, b.length); i++) {

			// a���r�؂ꂽ��b�̏����i�������͂��̋t�j
			if (i == a.length && i < b.length) {
				System.out.println("Yes");
				return;
			}
			if (i == b.length && i < a.length) {
				System.out.println("No");
				return;
			}

			// ����
			if (a[i] == b[i]) {
				continue;
			} else {
				System.out.println((a[i] < b[i]) ? "Yes" : "No");
				return;
			}

		}
	}
}
