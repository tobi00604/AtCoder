package abc098.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String inputStr = sc.next();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = inputStr.charAt(i) == 'E' ? 1 : -1;
		}

		// �Ⴆ�΍ł����̐l�����[�_�[�ɂ����ꍇ
		int cost = 0;
		for (int i = 0 + 1; i < n; i++) {
			cost += a[i] == 1 ? 1 : 0;
		}
		int minCost = cost;

		// �S�T��
		for (int i = 0 + 1; i < n; i++) {

			// ���[�_�[�͐U��Ԃ�Ȃ��Ă���
			if (a[i] == 1) {
				cost--;
			}

			// �O�񃊁[�_�[�������l���U��Ԃ邩������Ȃ�
			if (a[i - 1] == -1) {
				cost++;
			}

			// �R�X�g�̍ŏ��l�i�����j�͊o���Ă���
			if (cost < minCost) {
				minCost = cost;
			}

		}

		System.out.println(minCost);

	}
}
