package abc148.E;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());

		// �R�[�i�[�P�[�X�Bn������Ɠ�����0�Ŋm��
		if (n % 2 == 1) {
			System.out.println(0);
			return;
		}

		// f(n)�̖�����0���������邩���߂���
		// ��
		// f(n)������5�Ŋ���؂�邩���߂�
		// ��
		// f(n)��5�Ŋ���؂��񐔂�
		// f(n)��5^2�Ŋ���؂��񐔂�
		// �c
		// f(n)��5^30�Ŋ���؂��񐔂̘a
		// ��
		// n�ȉ��̋�����5^1�Ŋ���؂����̂̌���
		// n�ȉ��̋�����5^2�Ŋ���؂����̂̌���
		// �c
		// n�ȉ��̋�����5^30�Ŋ���؂����̂̌��̘a
		// ��
		// n�ȉ��̐�����10(=2*5^1)�̔{���̌���
		// n�ȉ��̐�����50(=2*5^2)�̔{���̌���
		// �c
		// n�ȉ��̐�����??(=2*5^30)�̔{���̌��̘a

		long result = 0;
		long warukazu = 2 * 5;
		for (int i = 1; i <= 30; i++) {

			// n�ȉ��̐����� 2*5^i �̔{���̌�
			long ans = n / warukazu;

			if (ans == 0) {
				break; // ���f����
			} else {
				result += ans;
				warukazu *= 5;
			}

		}
		System.out.println(result);

	}

}
