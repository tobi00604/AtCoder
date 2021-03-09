package abc148.E;

import java.util.*;

// ���o�͗�3�����܂������Ȃ��̂�WA�ɂȂ邯�ǂ��������o
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// �Q�l
		for (int i = 1; i <= 32; i++) {
			System.out.println(i + "_" + f(i) + "_" + countZero(f(i)));
		}

		// n������� 0 �Ŋm��
		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}

		// �y�����P�z
		// n��10�����̋�������0
		// n��20�����̋�������1
		// n��30�����̋�������2
		// �c
		// n��100�����̋�������9
		// n��110�����̋�������11
		//
		// 10���Ƃ�1�����āA100���Ƃ�1�����āA�c���Ċ����H

		// �y�����Q�z
		// str.substring(3, 8)
		// �ŏ���8���������o�����A���̍ŏ���3�����͍���A5�����ɂȂ�C���[�W
		// "123456789" �� "45678"

		String str = n + "";
		long result = 0;
		for (int i = 1; i <= str.length() - 1; i++) {
			result += Long.parseLong((str.substring(0, i)));
		}
		System.out.println(result);

	}

	// �y�Q�l�p�z��蕶�ǂ����f
	static long f(long n) {
		return (n < 2) ? 1 : n * f(n - 2);
	}

	// �y�Q�l�p�zx�̖�����0�͂������邩
	static long countZero(long x) {
		String s = x + "";
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(n - 1 - i) != '0') {
				return i;
			}
		}
		return -1;
	}
}
