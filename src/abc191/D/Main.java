package abc191.D;

import java.util.*;

// �C�ӂ̉~�̓����Ɋ܂܂��i�q�_�𐔂�����B
// ���������炱��ȃy�[�W�i���LURL�j���������̂Ŋۃp�N�������B
// https://qiita.com/Tukaene/items/63b86d918e4924c12d36
// �Ƃ��낪���y�[�W�̓��o�͗�R�����Ă݂�ƁA
// �o�͂͐��������Ǐo�͂����܂�1���ȏォ����̂�TLE�m��B����o�B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		double x = Double.parseDouble(sc.next());
		double y = Double.parseDouble(sc.next());
		double r = Double.parseDouble(sc.next());

		int start = (int) Math.ceil(x - r);
		int end = (int) Math.floor(x + r);

		long result = 0;
		double p = 0;
		for (int i = start; i <= end; i++) {
			p = Math.sqrt(Math.pow(r, 2) - Math.pow((x - (double) i), 2));

			int bottom = (int) Math.ceil(y - p);
			int top = (int) Math.floor(y + p);

			for (int j = bottom; j <= top; j++) {
				result++;
			}
		}

		System.out.println(result);

	}
}
