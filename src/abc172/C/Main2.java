package abc172.C;

import java.util.*;

// Main���s�����ɂȂ�̂ł�蒼���Ă݂�B��o���̓N���X����Main�ɂ��邱��
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = new Integer(Integer.parseInt(sc.next())); // ��A�̍���
		int m = new Integer(Integer.parseInt(sc.next())); // ��B�̍���
		long k = new Integer(Integer.parseInt(sc.next())); // �Ǐ�����

		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrayA.add(new Integer(Integer.parseInt(sc.next())));
		}

		ArrayList<Integer> arrayB = new ArrayList<Integer>();
		for (int j = 0; j < m; j++) {
			arrayB.add(new Integer(Integer.parseInt(sc.next())));
		}

		int loop = 0;
		while (true) {

			if (arrayA.size() == 0 && arrayB.size() == 0) {
				System.out.println(loop);
				return;
			} else if (arrayB.size() == 0) {
				k -= arrayA.get(0);
				arrayA.remove(0);
			} else if (arrayA.size() == 0) {
				k -= arrayB.get(0);
				arrayB.remove(0);
			} else {
				if (arrayA.get(0) < arrayB.get(0)) {
					k -= arrayA.get(0);
					arrayA.remove(0);
				} else {
					k -= arrayB.get(0);
					arrayB.remove(0);
				}
			}

			// �Ǐ����Ԃ��g���؂�����
			if (k < 0) {
				System.out.println(loop);
				return;
			}

			// ���̖{��
			loop++;
		}

	}
}
