package abc186.D;

import java.util.*;

// �����Ȃ�ɂ��ǂ蒅�������W�b�N���ȉ��B�����WA�������炨��グ�B
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
		}

		// �\�[�g�i�����������ɂȂ邱�Ƃɒ��Ӂj
		Arrays.sort(a);

		// �����̐�������
		int m = n - 1;
		long[] b = new long[m];
		for (int i = 0; i < m; i++) {
			b[i] = a[i + 1] - a[i];
			//System.out.println(b[i]);
		}

		//System.out.println("!");

		// �o��񐔂̐�������
		long[] c = new long[m];
		c[0] = m;
		//System.out.println(c[0]);
		long l = m;
		for (int i = 1; i < m; i++) {
			l -= 2;
			c[i] = c[i - 1] + l;
			//System.out.println(c[i]);
		}

		// ����
		long result = 0;
		for (int i = 0; i < m; i++) {
			result += b[i] * c[i];
		}
		System.out.println(result);

	}
}
