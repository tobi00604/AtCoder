package abc194.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		// �܂肱�̖��A�N�[�|���R���N�^�[���̓�������1���������ʂ�
		// �o�͂���΂����̂ł́H
		double d = 0.0;
		for (int i = 1; i <= n; i++) {
			d += 1.0D / (double) i;
		}
		System.out.println(d * (double) n - 1.0D);

	}
}
