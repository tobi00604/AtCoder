package introHeuristics.A;

// ���v���O�����ɂ��Ĕ��l
// �×~�@�炵�����̂�����Ă݂��B���������x��o���Ă�0�_�B�ǂ������������̂��c�B

import java.util.*;

public class Main2 {

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

		// ��o�p�z������������Ă����i�����l�͂܂��K����26��ނ̃R���e�X�g�����[�e�[�V�����J�ÂŁj
		int teishutu[] = new int[span];
		for (int d = 0; d < span; d++) {
			teishutu[d] = (d % 26) + 1;
		}

		// �×~�@������Ă݂悤�i�������×~�@�ɂȂ��Ă��邩�͒m���j
		for (int d = 0; d < span; d++) {

			// d���ڂ͉����J�Â����疞���x�ő傩�����߂āA��o�p�z�������ɂ���
			int bestKaisai = 1;
			long bestScore = -99999;
			for (int i = 0; i < 26; i++) {

				teishutu[d] = i + 1;
				long score = calc(teishutu);
				// System.out.println(Arrays.toString(teishutu) + "\t" + score);

				if (score > bestScore) {
					bestKaisai = i + 1;
					bestScore = score;
				}
			}
			teishutu[d] = bestKaisai;

		}

		// ��o
		for (int d = 0; d < span; d++) {
			System.out.println(teishutu[d]);
		}

	}

	public static long calc(int[] input) {

		int last[] = new int[26]; // �e�R���e�X�g���ŏI�J�Ó����牽���o�߂��Ă��邩
		long result = 0; // ���[�U�����x

		for (int d = 0; d < input.length; d++) {

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
				result -= (minus[i] * last[i]);
			}
		}

		return result;
	}
}
