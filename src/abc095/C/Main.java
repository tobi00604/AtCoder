package abc095.C;

import java.util.*;

// ��o��̃����F
// ���̖�����낤�Ǝv�����̂́A���L�u���O�ɂđS�T���̗��K���Ƃ��ďЉ��Ă�������B
// https://qiita.com/e869120/items/eb50fdaece12be418faa
// ���ہA���PDF�ł��S�T�����͔͉𓚂ł��邩�̂悤�ɏ����Ă���B
// �c�Ƃ��낪�v�Z�ʂn(1)�̉��L�\�[�X�R�[�h�ňꔭAC�ł��Ă��܂����B�S�T���͂܂����x����Ă݂悤�B
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());

		// A��B�𒼐ڔ�����
		long result1 = a * x + b * y;

		// AB�𔃂��Ă���A��B�ŕ₤��
		long result2;
		if (x < y) {
			result2 = c * x * 2 + b * (y - x);
		} else {
			result2 = c * y * 2 + a * (x - y);
		}

		// AB�����ōς܂����
		long result3 = Math.max(x, y) * 2 * c;

		// ��Ԉ���������������
		System.out.println(Math.min(result1, Math.min(result2, result3)));

	}
}
