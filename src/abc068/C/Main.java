package abc068.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}

		// �ŏ��̑D�ōs���铇
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < m; i++) {
			if (a[i] == 1) {
				hs.add(b[i]);
			}
		}

		// ���̑D�œ�n�ɍs���邩
		for (int i = 0; i < m; i++) {
			if (hs.contains(a[i]) && b[i] == n) {
				System.out.println("POSSIBLE");
				return;
			}
		}
		System.out.println("IMPOSSIBLE");

	}
}
