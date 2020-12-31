package arc109.B;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// ����
		if (n == 2) {
			System.out.println(1);
			return;
		}

		long l, r;
		l = 1;
		r = n;

		while (r - l > 1) {
			long mid = l + (r - l) / 2;
			// System.out.println(l + " �` " + r);
			// System.out.println(" " + mid + ":" + func(n, mid));
			if (func(n, mid)) {
				r = mid;
			} else {
				l = mid;
			}
		}

		System.out.println(r);

	}

	// n�{�̊ۑ���m�~�ŒB���ł��邩�ǂ�������
	static boolean func(long n, long m) {

		long cut = n + 1; // ������؂�ۑ��̒���
		long need = n - m + 1; // �؂��č��ۑ��̖{��

		BigInteger a = BigInteger.valueOf(need);
		a = a.multiply(BigInteger.valueOf(need + 1));
		a = a.divide(BigInteger.valueOf(2));
		a = a.subtract(BigInteger.valueOf(cut));

		// �����������Ȃ�true, ����Ȃ��Ȃ�false
		return a.compareTo(BigInteger.ZERO) != 1;

		// return need * (need + 1) / 2 <= cut;

	}
}
