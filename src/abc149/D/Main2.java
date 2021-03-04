package abc149.D;

import java.util.*;

// �O��̒�o��WA�ɂȂ����̂�
// �×~�@��z��̂����납�瑖�点�Ă�����p��ǉ����Ă݂�
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int rScore = Integer.parseInt(sc.next());
		int sScore = Integer.parseInt(sc.next());
		int pScore = Integer.parseInt(sc.next());
		String s = sc.next(); // �����r��s��p��r
		char[] aiteHand = new char[n];
		for (int i = 0; i < n; i++) {
			aiteHand[i] = s.charAt(i);
		}

		// �×~�@�Ŏ����̏o��������߂Ă���
		int[] myScore = new int[n];
		for (int i = 0; i < n; i++) {

			if (aiteHand[i] == 'r') {
				if (i < k) {
					myScore[i] = pScore;
				} else {
					myScore[i] = myScore[i - k] == pScore ? 0 : pScore;
				}
			} else if (aiteHand[i] == 's') {
				if (i < k) {
					myScore[i] = rScore;
				} else {
					myScore[i] = myScore[i - k] == rScore ? 0 : rScore;
				}
			} else if (aiteHand[i] == 'p') {
				if (i < k) {
					myScore[i] = sScore;
				} else {
					myScore[i] = myScore[i - k] == sScore ? 0 : sScore;
				}
			}

		}
		long result1 = 0;
		for (int i = 0; i < n; i++) {
			result1 += (long) myScore[i];
		}

		// ����̏o����𔽓]
		char[] temp = new char[n];
		for (int i = 0; i < n; i++) {
			temp[i] = aiteHand[i];
		}
		for (int i = 0; i < n; i++) {
			aiteHand[i] = temp[n - 1 - i];
		}

		// ������x�×~�@
		myScore = new int[n];
		for (int i = 0; i < n; i++) {

			if (aiteHand[i] == 'r') {
				if (i < k) {
					myScore[i] = pScore;
				} else {
					myScore[i] = myScore[i - k] == pScore ? 0 : pScore;
				}
			} else if (aiteHand[i] == 's') {
				if (i < k) {
					myScore[i] = rScore;
				} else {
					myScore[i] = myScore[i - k] == rScore ? 0 : rScore;
				}
			} else if (aiteHand[i] == 'p') {
				if (i < k) {
					myScore[i] = sScore;
				} else {
					myScore[i] = myScore[i - k] == sScore ? 0 : sScore;
				}
			}

		}
		long result2 = 0;
		for (int i = 0; i < n; i++) {
			result2 += (long) myScore[i];
		}

		// �ʏ�łƔ��]�łŌ��ʂ��ǂ������ق����o��
		System.out.println(Math.max(result1, result2));

	}
}
