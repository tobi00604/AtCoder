package abc170.D;

import java.util.*;

// TLE�ɂȂ郍�W�b�N���������̓��B�_�Ƃ��Ē�o
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int a[] = new int[n];
		boolean b[] = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = true;
		}
		Arrays.sort(a);

		// �A�C�e�����P�����Ȃ瓚���� 1 �̂͂�
		if (n == 1) {
			System.out.println(1);
			return;
		}

		// ���[�v
		for (int i = 0; i < n; i++) {

			// ���������ēo�ꂵ���Ƃ��̏���
			if (i != 0 && a[i - 1] == a[i]) {
				b[i - 1] = false;
			}

			if (b[i]) {
				for (int j = i + 1; j < n; j++) {
					if (b[j] && a[j] % a[i] == 0) {
						b[j] = false;
						System.out.println(a[j] + " ��" + a[i] + "�ɂ�菜�O");
					}
				}
			}
		}

		// ����
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (b[i]) {
				result++;
			}
		}
		System.out.println(result);

	}
}
