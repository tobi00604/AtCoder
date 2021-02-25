package abc131.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long c = Long.parseLong(sc.next());
		long d = Long.parseLong(sc.next());
		long e = lcm(c, d);

		// a�ȏ�b�ȉ��̐����ŁAc�ł�d�ł�����؂�Ȃ����̂̌������߂�

		// a�ȏ�̐����ōŏ��́A����؂�����
		long minC = (a % c == 0) ? a : (a / c) * c + c;
		long minD = (a % d == 0) ? a : (a / d) * d + d;
		long minE = (a % e == 0) ? a : (a / e) * e + e;
//		System.out.println(minC + ", " + minD + ", " + minE);

		// b�ȉ��̐����ōő�́A����؂�����
		long maxC = (b % c == 0) ? b : (b / c) * c;
		long maxD = (b % d == 0) ? b : (b / d) * d;
		long maxE = (b % e == 0) ? b : (b / e) * e;
//		System.out.println(maxC + ", " + maxD + ", " + maxE);

		// ����؂����̂̌�
		long cntC = (minC <= maxC) ? (maxC / c) - (minC / c) + 1 : 0;
		long cntD = (minD <= maxD) ? (maxD / d) - (minD / d) + 1 : 0;
		long cntE = (minE <= maxE) ? (maxE / e) - (minE / e) + 1 : 0;
//		System.out.println(cntC + ", " + cntD + ", " + cntE);

		// ����
		System.out.println(b - a + 1 - cntC - cntD + cntE);

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
