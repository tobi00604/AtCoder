package abc149.D;

import java.util.*;

// ���܂���p���v�����Ȃ������̂łƂ肠�����×~�@���������
// ���o�͗Ⴊ���ׂĒʂ����̂Œ�o���Ă݂�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int rScore = Integer.parseInt(sc.next());
		int sScore = Integer.parseInt(sc.next());
		int pScore = Integer.parseInt(sc.next());
		String aiteStr = sc.next(); // �����r��s��p��r

		// �×~�@�Ŏ����̏o��������߂Ă���
		int[] myScore = new int[n];
		for (int i = 0; i < n; i++) {

			if (aiteStr.charAt(i) == 'r') {
				if (i < k) {
					myScore[i] = pScore;
				} else {
					myScore[i] = myScore[i - k] == pScore ? 0 : pScore;
				}
			} else if (aiteStr.charAt(i) == 's') {
				if (i < k) {
					myScore[i] = rScore;
				} else {
					myScore[i] = myScore[i - k] == rScore ? 0 : rScore;
				}
			} else if (aiteStr.charAt(i) == 'p') {
				if (i < k) {
					myScore[i] = sScore;
				} else {
					myScore[i] = myScore[i - k] == sScore ? 0 : sScore;
				}
			}

		}

		// ����
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += (long) myScore[i];
		}
		System.out.println(result);

	}
}
