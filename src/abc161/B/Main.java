package abc161.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int point[] = new int[n];
		for (int i = 0; i < n; i++) {
			point[i] = sc.nextInt();
		}

		// �\�[�g�i�����������ɂȂ邱�Ƃɒ��Ӂj
		Arrays.sort(point);

		// �����[��
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += point[i];
		}

		// �l�C m �ʂ̃A�C�e���̕[���ɂ���ĕ���
		if (point[point.length - m] * m * 4 < sum) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}

	}

}
