package arc112.B;

import java.util.*;

// �c�莞��40�����������璅�肵�Ă݂�����
// �p�^�[������������Ď��Ԑ؂�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long start = Long.parseLong(sc.next());
		long money = Long.parseLong(sc.next());

		if (money == 1) {
			System.out.println(start == 0 ? 1 : 2);
			return;
		}

		if (money == 2) {
			System.out.println(3);
			return;
		}

		if (money % 2 == 1) {

			if (0 < start) {
				long small = start - (money / 2);
				long m_small = -1 * small;
				long m_big = (-1 * start) - (money / 2);
				long big = (-1 * m_big) - 1;
			}
			else {
				
			}

		}

	}
}
