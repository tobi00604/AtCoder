package abc170.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int animal = Integer.parseInt(sc.next());
		int leg = Integer.parseInt(sc.next());

		// �Ⴆ��animal=3, leg=8 �Ȃ�A��Q���߂P

		for (int turu = 0; turu <= animal; turu++) {

			int kame = animal - turu;

			if ((turu * 2) + (kame * 4) == leg) {
				System.out.println("Yes");
				return;
			}
		}

		System.out.println("No");
	}

}
