package abc171.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		Integer n = new Integer(Integer.parseInt(sc.next())); // �i���̎�ސ�
		Integer k = new Integer(Integer.parseInt(sc.next())); // ��������
		Integer x[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			x[i] = new Integer(Integer.parseInt(sc.next()));
		}

		// �\�[�g
		Arrays.sort(x);

		// ��������k�𔃂���
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += x[i];
		}
		System.out.println(sum);

	}
}
