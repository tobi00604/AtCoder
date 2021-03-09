package abc194.E;

import java.util.*;

// �𒼂ɃV�~�����[�V�����i�N�ł��v���������ȉ�@�j�ł���Ă݂�B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		int answerMax = 0; // �����͍ő�ŉ��ɂȂ邩
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			answerMax = Math.max(answerMax, a[i] + 1);
		}

		// �o���񐔂ƌ��݂�mex
		int[] counter = new int[answerMax + 2];
		Arrays.fill(counter, 0);
		int mex = 0;
		int mexmin = Integer.MAX_VALUE;

		// �ŏ��̕�����Ƃ���mex
		for (int i = 0; i < m; i++) {
			counter[a[i]]++;
		}
		while (counter[mex] != 0) {
			mex++;
		}
		mexmin = Math.min(mex, mexmin);

		// �m�F�p
//		System.out.println(Arrays.toString(counter));
//		System.out.println(mex);
//		System.out.println(mexmin);

		// ���ȍ~
		for (int loop = 1; loop <= (n - m); loop++) {

			// �����񂪂P�k��łP�L�т�
			counter[a[loop - 1]]--;
			counter[a[loop + m - 1]]++;

			// mex�������
			if (counter[a[loop - 1]] == 0) {
				mex = a[loop - 1];
			} else {
				while (counter[mex] != 0) {
					mex++;
				}
			}

			// �Œ�L�^�X�V
			mexmin = Math.min(mex, mexmin);

			// �m�F�p
//			System.out.println(Arrays.toString(counter));
//			System.out.println(mex);
//			System.out.println(mexmin);

			// �Œ�L�^�� 0 �Ȃ炻�ꂪ�����Ŋm��
			if (mexmin == 0) {
				System.out.println(0);
				return;
			}

		}

		// ���ʏo��
		System.out.println(mexmin);

	}
}
