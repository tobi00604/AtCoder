package tokiomarinenichido2020.B;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		idea2();
	}

	// ����Œ�o������s�����������c�����͕s��
	private static void idea1() {

		// ����
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long v = sc.nextInt();
		long b = sc.nextInt();
		long w = sc.nextInt();
		long t = sc.nextInt();

		// �qB�̓����鑬�����A�SA�Ɠ���������ȏゾ������A�i���ɒǂ����Ȃ�
		if (v <= w) {
			System.out.println("NO");
			return;
		}

		// �Q�l�̋����͂P�b�ɂǂꂭ�炢�k�܂邩�H
		long speed = v - w;

		// �Q�l�͍ŏ��ǂ̂��炢����Ă��邩�H
		long dis = (a < b) ? (b - a) : (a - b);

		// �ǂ����̂ɉ��b�����邩�H
		long need = dis / speed;

		// t�b�ȓ��ɒǂ�������YES
		System.out.println((need <= t) ? "YES" : "NO");

	}

	private static void idea2() {

		// ����
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long v = sc.nextInt();
		long b = sc.nextInt();
		long w = sc.nextInt();
		long t = sc.nextInt();

		// �Q�l�͍ŏ��ǂ̂��炢����Ă��邩�H
		long dis = (a < b) ? (b - a) : (a - b);

		for (int i = 1; i <= t; i++) {
			// �ӂ���̋������X�V
			dis = dis - v + w;

			// �ǂ�������YES
			if (dis <= 0) {
				System.out.println("YES");
				return;
			}

		}

		System.out.println("NO");

	}

}
