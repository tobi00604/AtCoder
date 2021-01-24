package abc160.E;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int[] p = new int[a];
		int[] q = new int[b];
		int[] r = new int[c];
		for (int i = 0; i < a; i++) {
			p[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < b; i++) {
			q[i] = Integer.parseInt(sc.next());
		}
		for (int i = 0; i < c; i++) {
			r[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(p);
		Arrays.sort(q);
		Arrays.sort(r);

		// �H�ׂ邩������Ȃ������S���������o���ĐV�����z��ɓ����
		int[] eat = new int[x + y + c];
		int j = 0;
		for (int i = 0; i < x; i++, j++) {
			eat[j] = p[a - 1 - i];
		}
		for (int i = 0; i < y; i++, j++) {
			eat[j] = q[b - 1 - i];
		}
		for (int i = 0; i < c; i++, j++) {
			eat[j] = r[c - 1 - i];
		}

		// �ԐF�ΐF���F�̃����S�S����������܂��Ń\�[�g
		Arrays.sort(eat);

		// �m�F�p
		for (int i = 0; i < x + y + c; i++) {
			// System.out.println(eat[i]);
		}

		// ���������ق�����H�ׂ�
		long result = 0;
		for (int i = 0; i < x + y; i++) {
			result += eat[x + y + c - 1 - i];
		}

		System.out.println(result);
	}
}
