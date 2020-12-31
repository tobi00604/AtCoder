package introHeuristics.B;

// 2020.6.28
// https://atcoder.jp/contests/intro-heuristics
import java.util.*;

public class Main {

	public static int span; // �����Ԃ̃X�P�W���[�����O�����邩
	public static int minus[]; // 26��ނ̃R���e�X�g�̖O���₷��
	public static int plus[][]; // 26��ނ̃R���e�X�g�̖�����

	public static void main(String[] args) {

		// ----------
		// ����
		// ----------
		Scanner sc = new Scanner(System.in);
		span = Integer.parseInt(sc.next()); // �����Ԃ̃X�P�W���[�����O�����邩
		minus = new int[26]; // 26��ނ̃R���e�X�g�̖O���₷��
		for (int i = 0; i < 26; i++) {
			minus[i] = Integer.parseInt(sc.next());
		}
		plus = new int[span][26]; // 26��ނ̃R���e�X�g�̖�����
		for (int d = 0; d < span; d++) {
			for (int i = 0; i < 26; i++) {
				plus[d][i] = Integer.parseInt(sc.next());
			}
		}

		// ----------
		// ����(�e�X�g�P�[�X)
		// ----------
		int input[] = new int[span]; // �J�Â����R���e�X�g
		for (int d = 0; d < span; d++) {
			input[d] = Integer.parseInt(sc.next());
		}

		// ----------
		// �v�Z�Əo��
		// ----------
		calc(input);

	}

	public static void calc(int[] input) {

		int last[] = new int[26]; // �e�R���e�X�g���ŏI�J�Ó����牽���o�߂��Ă��邩
		int result = 0; // ���[�U�����x

		for (int d = 0; d < span; d++) {

			// last�̍X�V
			for (int i = 0; i < 26; i++) {
				if (i == input[d] - 1) {
					last[i] = 0;
				} else {
					last[i]++;
				}
				// System.out.println("last[" + i + "] = " + last[i]);
			}

			// �J�Âɂ�閞���x�A�b�v
			result += plus[d][input[d] - 1];

			// �����o�߂ɂ�閞���x�_�E��
			for (int i = 0; i < 26; i++) {
				result -= minus[i] * last[i];
				// System.out.println(minus[i] * last[i]);
			}
			System.out.println(result);
		}
	}
}
