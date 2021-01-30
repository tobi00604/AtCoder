package agc028.A;

import java.util.*;

// �������Ɏ��M���Ȃ����ǂƂ肠�������������̂Œ�o�B
// (���y�[�W�ɏ����Ă�����o�͗�1�`3�͂����������ׂĒʂ�j
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int gcd = getTwoGcd(n, m);
		int lcm = (n / gcd) * m;
		String s = sc.next();
		String t = sc.next();

		int i = 0;
		int j = 0;
		boolean[] match = new boolean[gcd];
		for (int index = 0; index < gcd; index++) {

			// �����̗��ꂪ���L���Ă��镶������v���Ă��邩��r
			match[index] = (s.charAt(i) == t.charAt(j));

			// ���͂�15��9��������Ai��3���Aj��5������
			i += n / gcd;
			j += m / gcd;
		}

		// �m�F�p
		// System.out.println(Arrays.toString(match));

		for (int level = 0; level < match.length + 1; level++) {

			// �}�b�`�z������Ă���
			boolean successFlg = true;
			for (int p = 1; p < gcd; p++) {

				// ����
				if (!match[p]) {
					successFlg = false;
					break;
				}

				// ���x���ɂ���Ă�p����C�ɔ�΂��Ă���
				p += level;
			}

			if (successFlg) {
				System.out.println(lcm * (level + 1));
				return;
			}
		}

		System.out.println(-1);
		return;
	}

	public static int getTwoGcd(int m, int n) {

		int r;
		while (n > 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
}
