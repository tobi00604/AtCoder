package abc172.C;

import java.util.*;

public class Main {

	// �y�I����̊��z�z
	// �Ȃ�ŕs�����ɂȂ�̂��܂������킩��Ȃ��ĂP���Ԃ��炢���ʂɂ������ǁA
	// A�̊���B�̊��́u��ԏ�Ɍ����Ă���{�v�������ĂȂ��������ƂɌォ��C�Â��B
	// �܂薳�ӎ��� "�×~�@" ������Ă��B���̂�������
	//	3 4 19
	//	10 10 10
	//	11 2 2 2
	// �݂����ȓ��͂̂Ƃ��ɕs�����ɂȂ��c�B
	
	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = new Integer(Integer.parseInt(sc.next())); // ��A�̍���
		int m = new Integer(Integer.parseInt(sc.next())); // ��B�̍���
		long k = new Integer(Integer.parseInt(sc.next())); // �Ǐ�����
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Integer(Integer.parseInt(sc.next()));
		}
		long b[] = new long[m];
		for (int j = 0; j < m; j++) {
			b[j] = new Integer(Integer.parseInt(sc.next()));
		}

		int i = 0;
		int j = 0;
		while (0 <= k) {

			if (i == n && j != m) {

				// A�̊�����
				k -= b[j];
				j++;
				//System.out.println("�� " + i + " " + j + " " + k);

			} else if (i != n && j == m) {

				// B�̊�����
				k -= a[i];
				i++;
				//System.out.println("�� " + i + " " + j + " " + k);

			} else if (i == n && j == m) {

				// �����{���Ȃ�
				//System.out.println("�� " + i + " " + j + " " + k);
				System.out.println(i + j);
				return;

			} else {

				if (a[i] <= b[j]) {

					// A�̊��̖{��ǂ�Ŏ̂Ă�
					k -= a[i];
					i++;
					//System.out.println("�� " + i + " " + j + " " + k);

				} else {

					// B�̊��̖{��ǂ�Ŏ̂Ă�
					k -= b[j];
					j++;
					//System.out.println("�� " + i + " " + j + " " + k);

				}

			}

		}

		System.out.println(i + j - 1);

	}
}
