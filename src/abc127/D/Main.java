package abc127.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}
		int addition = 0;
		int[] b = new int[m];
		int[] c = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = Integer.parseInt(sc.next());
			c[i] = Integer.parseInt(sc.next());
			addition += b[i];
		}

		// ���������O�Ə���������̑S�J�[�h���ЂƂ̔z��ɂ���
		int index = 0;
		int[] card = new int[n + addition];
		for (int i = 0; i < n; i++) {
			card[index] = a[i];
			index++;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < b[i]; j++) {
				card[index] = c[i];
				index++;
			}
		}

		// �m�F�p
//		System.out.println(Arrays.toString(card));

		// �\�[�g���đ傫���ق�����n���Ɠ����ɂȂ�̂ł�
		Arrays.sort(card);
		long result = 0;
		for (int i = 0; i < n; i++) {
			result += card[card.length - 1 - i];
		}
		System.out.println(result);

	}

}
