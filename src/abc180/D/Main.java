package abc180.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long x = Long.parseLong(sc.next());
		long y = Long.parseLong(sc.next());
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());

		// �R�[�i�[�P�[�X
		if (y < x * a && y < x + b) {
			System.out.println(0);
			return;
		}

		// a���g����b���g�����̋��E��
		long line = b / (a - 1);

		// �ڕW�̋�����line�ȉ��̏ꍇ��a�{�������g��
		if (y <= line) {
			long result = 0;
			while (x < y) {
				x *= a;
				result++;
			}
			System.out.println(result - 1);
			return;
		}

		// �����̋�����line���傫���ꍇ��b���Z�������g��
		if (line < x) {
			long result = 0;
			result = (y - x) / b;
			if ((y - x) % b == 0) {
				result--;
			}
			System.out.println(result);
			return;
		}

		// ������line�ȉ��̂Ƃ���a���g���Ab���g����line�𒴂��A���̂܂ܖڕW���O�܂ōs��
		long result = 0;
		if (x == line) {
			x = Math.min(x * a, x + b);
			result++;
		}
		while (x < line) {
			x *= a;
			result++;
		}
		x /= a;
		result--;
		result += ((y - x) / b);
		if ((y - x) % b == 0) {
			result--;
		}
		System.out.println(result);
	}
}
