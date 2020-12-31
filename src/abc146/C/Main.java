package abc146.C;

import java.util.*;

// �񕪒T���̗��K�B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next());
		long x = Long.parseLong(sc.next());

		// ����������� 1 ���� 1000000000 �܂ł̐����������Ă���B
		// ���� n �̒l�i�́An * a + (n�̌���) * b �ł���B
		// ���݂̏������� x �ł���B�������Ƃ��ł���ő�̐��������߂����B

		int left = 0;
		int right = 1000000001;

		// �񕪒T��
		while (right - left > 1) {

			// �^��
			int mid = (right + left) / 2;
			long nedan = mid * a + (new Integer(mid)).toString().length() * b;

			//System.out.println(left + "_" + mid + "_" + right + " " + nedan);

			// �����邩����
			if (nedan <= x) {
				left = mid;
			} else {
				right = mid;
			}

		}

		// left�́u������ő�̐����v�Aright�́u�����Ȃ��ŏ��̐����v�ɂȂ��Ă���͂�
		System.out.println(left);

	}

}
