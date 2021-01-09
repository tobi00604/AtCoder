package abc180.C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// �����ЂƂW������
		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());

		// �񐔃��X�g�쐬
		ArrayList<Long> list = getDivisorList(a);

		// ����
		for (long b : list) {
			System.out.println(b);
		}

	}

	// �����ŗ^����ꂽ�����̖񐔃��X�g���쐬���ĕԂ�
	public static ArrayList<Long> getDivisorList(long a) {

		ArrayList<Long> list = new ArrayList<Long>();

		for (long i = 1; i * i <= a; i++) {
			if (a % i == 0) {
				list.add(i);
				if (!list.contains(a / i)) {
					list.add(a / i);
				}
			}
		}
		Collections.sort(list);
		return list;
	}

}
