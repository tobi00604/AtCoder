package abc192.C;

import java.util.*;

// �ǂ��H�v����΂������������B���Ԃ�TLE�����ǃi�C�[�u�ȉ�@���܂�����Ă݂�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		int k = Integer.parseInt(sc.next());

		// �Q������i��ł����ē����o��
		// �������r���Ő��񂪎��������炻��𓚂��Ƃ��Ă悢
		for (int i = 1; i <= k; i++) {
			long next = f(n);

			if (next == n) {
				System.out.println(n);
				return;
			}

			n = next;
		}

		System.out.println(n);

	}

	static long f(long num) {

		if (num == 0) {
			return 0;
		}

		String s1 = String.valueOf(num);
		int[] a = new int[s1.length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = s1.charAt(i) - 48;
		}
		Arrays.sort(a);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb1.append(a[i]);
			sb2.append(a[a.length - 1 - i]);
		}
		return Integer.parseInt(sb2.toString()) - Integer.parseInt(sb1.toString());
	}
}
