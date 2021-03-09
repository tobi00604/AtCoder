package abc190.D;

import java.util.*;

// ����̈ꕔ������������Ɠǂ�ł������Ă݂�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// �� 2n=(a+b)(b-a+1) �����藧�B
		// (a+b)��(b-a+1)��2n�̖񐔂Ƃ�����B
		// ������2n�̖񐔂��
		ArrayList<Long> yakusuList = getDivisorList(2 * n);

		// �T��
		int result = 0;
		for (long i : yakusuList) {
			long j = 2 * n / i;

			// �A�������� a+b=i, b-a+1=j ������
			long a = (i - j + 1) / 2;
			long b = (i + j - 1) / 2;

			// �m�F�p
//			System.out.println(i + "_" + j + " " + a + "�`" + b);

			// ��ӂ𖞂������m�F���ăJ�E���g
			if (2 * n == (a + b) * (b - a + 1)) {
				result++;
			}

		}

		// ����
		System.out.println(result);

	}

	// �����ŗ^����ꂽ�����̖񐔃��X�g���쐬���ĕԂ�
	public static ArrayList<Long> getDivisorList(long a) {

		ArrayList<Long> list = new ArrayList<Long>();
		for (long i = 1; i * i <= a; i++) {
			if (a % i == 0) {
				list.add(i);
				if (!list.contains(a / i)) {
					list.add(a / i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}
}
