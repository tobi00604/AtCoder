package abc177.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		// m�s�̓��͂����X�g�ɓ����A���̂Ƃ��K�v�ȏ�񂾂�������
		ArrayList<String> list;
		list = new ArrayList<String>();
		for (int i = 0; i < m; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			if (a > b) {
				int c = a;
				a = b;
				b = c;
			}
			String str = a + " " + b;
			if (!list.contains(str)) {
				list.add(str);
			}
		}

		// friends[77]�ɂ͏o�Ȕԍ�77�Ԃ̐l�̗F�B�̐�������
		int friends[];
		friends = new int[n + 1];
		for (String str : list) {
			friends[Integer.valueOf(str.split(" ")[0])]++;
			friends[Integer.valueOf(str.split(" ")[1])]++;
		}

		// �m�F�p
		for (int i = 0; i < n + 1; i++) {
			// System.out.println(i + " " + friends[i]);
		}

		// �ł��F�B�������l�́A���l�F�B�����邩�H
		int best = 0;
		for (int i = 0; i < n + 1; i++) {
			if (best < friends[i]) {
				best = friends[i];
			}
		}

		// �ł��F�B�������l�́A�F�B�̐���500�l��������A501�O���[�v�ɕ��f����
		System.out.println(best + 1);

	}
}
