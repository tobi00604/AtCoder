package introHeuristics.A;

// ���v���O�����ɂ��Ĕ��l
// 0�_�̌�����T��ׂ��A�×~�@���u1���ڂ���365���ڂ܂Łv�ł͂Ȃ��u3���ڂ����v�ɓK�p���Ă݂��B
// ��o�����Ƃ���9309�_�B0�_�ɂ͂Ȃ�Ȃ������Ƃ������Ƃ͐�قǂ�0�_�̌����͂�͂� 1�`365 �̃��[�v�H
// �Ă�����9309�_���āA�����l�i���[�e�[�V�����J�Â�13639�_�j��舫�����Ă邶���c�Ȃ����c�B
// �䂪����Ă�ł��܂����̂ł����Ƃ��낢�뒲�ׂ����������A�����͂������Ԑ؂�B
 
import java.util.*;

public class Main3 {

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

		// �R���ڂ�ς��Ė����x�ő�̂��̂�T��
		int bestKaisai = 1;
		long bestScore = -99999;
		for (int i = 0; i < 26; i++) {

			teishutu[2] = i + 1;
			long score = calc(teishutu);
			// System.out.println(Arrays.toString(teishutu) + "\t" + score);

			if (score > bestScore) {
				bestKaisai = i + 1;
				bestScore = score;
			}
		}
		teishutu[2] = bestKaisai;

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
