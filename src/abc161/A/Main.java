package abc161.A;

import java.util.*;

// A - ABC Swap
// ���K�Ƃ��Ă���Ă݂�B2020/4/12
public class Main {

	public static void main(String[] args) {

		// �X�y�[�X��؂�̐����R��
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// ���`�Ɣ��a�����ւ���
		int tmp;
		tmp = a;
		a = b;
		b = tmp;

		// ���`�Ɣ��b�����ւ���
		tmp = a;
		a = c;
		c = tmp;

		System.out.println(a + " " + b + " " + c);

	}

}
