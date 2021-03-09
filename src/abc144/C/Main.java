package abc144.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long m = Long.parseLong(sc.next());

		// ���肦��}�X��S�T��
		long minCost = Long.MAX_VALUE;
		ArrayList<Long> list = getDivisorList(m);
		for (long i : list) {

			// ���W�ƈړ��R�X�g
			long x = i;
			long y = m / i;
			long cost = x + y - 2;
			minCost = Math.min(cost, minCost);

		}

		System.out.println(minCost);

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
