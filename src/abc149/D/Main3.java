package abc149.D;

import java.util.*;

// ���j�͐������C������̂ł��ꂢ�ɍ�蒼���Ă݂�
// �����WA��������e�X�g�P�[�X�i���LURL�j�𒲂ׂ邵���Ȃ�����
// https://www.dropbox.com/sh/nx3tnilzqz7df8a/AADwtm6WkrFhaJuz4HJObHGPa/ABC149/D?dl=0&subfolder_nav_tracking=1
public class Main3 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int rScore = Integer.parseInt(sc.next());
		int sScore = Integer.parseInt(sc.next());
		int pScore = Integer.parseInt(sc.next());
		String s = sc.next(); // �����r��s��p��r
		char[] yourHand = new char[n];
		char[] myHand = new char[n];
		for (int i = 0; i < n; i++) {
			yourHand[i] = s.charAt(i);
		}

		// �×~�@�Ŏ����̏o��������߂Ă���
		for (int i = 0; i < n; i++) {

			if (i < k) {
				// �ŏ���K��͕K�����Ă�
				if (yourHand[i] == 'r') {
					myHand[i] = 'p';
				} else if (yourHand[i] == 's') {
					myHand[i] = 'r';
				} else if (yourHand[i] == 'p') {
					myHand[i] = 's';
				}
			} else {
				// �O��ɒ���
				if (yourHand[i] == 'r') {
					myHand[i] = myHand[i - k] == 'p' ? 'x' : 'p';
				} else if (yourHand[i] == 's') {
					myHand[i] = myHand[i - k] == 'r' ? 'x' : 'r';
				} else if (yourHand[i] == 'p') {
					myHand[i] = myHand[i - k] == 's' ? 'x' : 's';
				}
			}
		}

		// �m�F�p
//		System.out.println(Arrays.toString(myHand));

		// ����
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (myHand[i] == 'r') {
				result += rScore;
			} else if (myHand[i] == 's') {
				result += sScore;
			} else if (myHand[i] == 'p') {
				result += pScore;
			}
		}
		System.out.println(result);

	}
}
