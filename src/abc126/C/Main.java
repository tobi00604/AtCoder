package abc126.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next()); // �T�C�R���̖ʐ�
		long goal = Long.parseLong(sc.next()); // �ڕW�_��

		double result = 0;
		for (int i = 1; i <= n; i++) {

			// i�́A���x�u2�{�v�����goal�ɓ͂����H
			int kaisuu = 0;
			int score = i;
			while (score < goal) {
				kaisuu++;
				score *= 2;
			}

			// i�_����S�[���ł���m����result�ɑ���
			result += 1.0 / Math.pow(2, kaisuu);

		}

		System.out.println(result / (n + 0.0));

	}
}
