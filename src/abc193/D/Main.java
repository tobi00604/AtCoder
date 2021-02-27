package abc193.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		String s = sc.next();
		String t = sc.next();

		// �������Ă���S���̃J�[�h
		int[] a = new int[5];
		int[] b = new int[5];
		for (int i = 0; i < 4; i++) {
			a[i] = Integer.parseInt(s.charAt(i) + "");
			b[i] = Integer.parseInt(t.charAt(i) + "");
		}

		// �R
		long[] zan = new long[10];
		for (int i = 0; i < 10; i++) {
			zan[i] = k;
		}
		for (int i = 0; i < 4; i++) {
			zan[a[i]]--;
			zan[b[i]]--;
		}

		// �T���ڂ̃J�[�h���߂����ď��s�𒲂ׂ�i81�ʂ�j
		long bunsi = 0;
		long bunbo = 0;
		long winA = 0;
		long winB = 0;
		for (int ca = 1; ca <= 9; ca++) {

			if (zan[ca] == 0) {
				continue;
			}

			for (int cb = 1; cb <= 9; cb++) {

				if (zan[cb] == 0) {
					continue;
				}

				if (zan[ca] == 1 && ca == cb) {
					continue;
				}

				// �����ɓ���ꍇ��
				long pat = 0;
				if (ca != cb) {
					pat = zan[ca] * zan[cb];
				} else {
					pat = zan[ca] * (zan[ca] - 1);
				}

				// ���s����
				a[4] = ca;
				b[4] = cb;
				long scoreA = getScore(a);
				long scoreB = getScore(b);
//				System.out.println(ca + " " + cb + " " + scoreA + " VS " + scoreB);
				winA += (scoreA > scoreB) ? pat : 0;
				winB += (scoreA > scoreB) ? 0 : pat;
			}

		}

		// ����
		System.out.println((double) winA / ((double) (winA + winB)));

	}

	// ��D�̓_�����Z�o����
	static long getScore(int[] a) {
		long[] s = new long[10];
		for (int i = 0; i < 10; i++) {
			s[i] = i;
		}
		s[a[0]] *= 10;
		s[a[1]] *= 10;
		s[a[2]] *= 10;
		s[a[3]] *= 10;
		s[a[4]] *= 10;
		long retVal = 0;
		for (int i = 0; i < 10; i++) {
			retVal += s[i];
		}
		return retVal;
	}
}
