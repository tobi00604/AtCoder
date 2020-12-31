package abc182.D;

import java.math.BigInteger;
import java.util.*;

// ������������@���̂Q
// long���Ƒ���Ȃ��H�������̂�BigInteger�ŏ��������Ă݂悤
// �c�莞�Ԃ��킸���������̉�@�����Ɏv�����Ȃ��̂�
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}

		// �ݐϘa b
		long[] b = new long[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				b[i] = a[i];
			} else {
				b[i] = b[i - 1] + a[i];
			}
		}

		// �ݐϘa�̗ݐϘa c
		BigInteger[] c = new BigInteger[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				c[i] = BigInteger.valueOf(a[i]);
			} else {
				c[i] = c[i - 1].add(BigInteger.valueOf(b[i]));
			}
		}

		// b�̍ő�l
		long maxB = 0;
		for (int i = 0; i < n; i++) {
			if (maxB < b[i]) {
				maxB = b[i];
			}
		}

		// c�i�����������ȊO�j�̍ő�l
		BigInteger maxC = BigInteger.ZERO;
		for (int i = 0; i < n - 1; i++) {
			if (maxC.compareTo(c[i]) == -1) {
				maxC = c[i];
			}
		}

		// �o��
		System.out.println(maxC.longValue() + maxB);

		// �ȉ��f�o�b�O�p�Ȃ̂ŃR�����g�A�E�g
		// for (int i = 0; i < n; i++) {
		// System.out.println(c[i] + "_" + b[i] + "_" + a[i]);
		// }
		// System.out.println(maxC + " " + maxB);

	}
}
