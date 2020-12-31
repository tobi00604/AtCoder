package introHeuristics.A;

// ���v���O�����ɂ��Ĕ��l
// 26��ނ����[�e�[�V�����J�Â��邾���̒��ȒP�X�P�W���[���B�Ƃ肠�����������̂��o�����������̂ŁB
// ���Ȃ݂ɒ�o���ʂ�13639�_�B�I����̏��ʕ\�������13639�_�̐l���吨�����B��͂�݂�Ȏv�������[�e�[�V�����B

import java.util.*;

public class Main {

	public static int span; // �����Ԃ̃X�P�W���[�����O�����邩
	public static int minus[]; // 26��ނ̃R���e�X�g�̖O���₷��
	public static int plus[][]; // 26��ނ̃R���e�X�g�̖�����

	public static void main(String[] args) {

		// ����
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

		// �K���ɃX�P�W���[��������Ē�o���Ă݂�

		// 26��ނ̃R���e�X�g�����ԂɊJ��
		int input1[] = new int[span];
		for (int d = 0; d < span; d++) {
			input1[d] = (d % 26) + 1;
		}
		int output1 = calc(input1);
		// System.out.println("�����x���ʁF "output1);

		for (int d = 0; d < span; d++) {
			System.out.println(input1[d]);
		}

	}

	public static int calc(int[] input) {

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
			}

			// �J�Âɂ�閞���x�A�b�v
			result += plus[d][input[d] - 1];

			// �����o�߂ɂ�閞���x�_�E��
			for (int i = 0; i < 26; i++) {
				result -= minus[i] * last[i];
			}
		}

		return result;
	}
}
