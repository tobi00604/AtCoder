package abc148.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// �V�~�����[�V����
		int result = 0;
		int target = 1;
		for (int i = 0; i < n; i++) {
			if (a[i] == target) {
				target++;
			} else {
				result++;
			}
		}

		// ������
		System.out.println(target == 1 ? -1 : result);

	}
}
