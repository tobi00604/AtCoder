package arc109.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int r = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		// �L���P��
		if (a == b || a == b + 1) {
			System.out.println(r);
			return;
		}

		// �ЂƂ̃r�����łP�t���A�㉺����ŒZ����
		int f = Math.min(r + r, k);

		// ������
		if (a < b) {
			System.out.println(f * (b - a) + r);
		} else {
			System.out.println(f * (a - b - 1) + r);
		}
	}
}
