package abc148.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		System.out.println(lcm(a, b));

	}

	// 2�̐��̍ő���񐔂�Ԃ�
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	// 2�̐��̍ŏ����{����Ԃ�
	static long lcm(long a, long b) {
		return (a / gcd(a, b)) * b;
	}
}
