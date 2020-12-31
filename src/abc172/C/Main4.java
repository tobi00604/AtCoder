package abc172.C;

import java.util.*;

// 2020/7/7�@ABC172����P�T�Ԉȏ�o�������ǍĒ���
public class Main4 {

	public static int n;
	public static int m;
	public static long k;
	public static long a_sum[];
	public static long b_sum[];

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		n = new Integer(Integer.parseInt(sc.next())); // ��A�̍���
		m = new Integer(Integer.parseInt(sc.next())); // ��B�̍���
		k = new Integer(Integer.parseInt(sc.next())); // �Ǐ�����
		long a[] = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Integer(Integer.parseInt(sc.next()));
		}
		long b[] = new long[m];
		for (int j = 0; j < m; j++) {
			b[j] = new Integer(Integer.parseInt(sc.next()));
		}

		// �ݐϘa�����Ba_sum[i]�́A��A�̖{��i���ǂ񂾂Ƃ��ɂ����鎞��
		a_sum = new long[n + 1];
		for (int i = 0; i < n + 1; i++) {
			if (i != 0) {
				a_sum[i] = a_sum[i - 1] + a[i - 1];
			} else {
				a_sum[i] = 0;
			}
			//System.out.print(a_sum[i] + ", ");
		}
		log("");
		b_sum = new long[m + 1];
		for (int j = 0; j < m + 1; j++) {
			if (j != 0) {
				b_sum[j] = b_sum[j - 1] + b[j - 1];
			} else {
				b_sum[j] = 0;
			}
			//System.out.print(b_sum[j] + ", ");
		}
		log("");

		// ��A��i���ǂ񂾂Ƃ������B�͉����ǂ߂邩�A��Si�ɂ��Ē��ׂ�
		int highscore = 0;
		for (int i = 0; i < n + 1; i++) {

			// ���łɎ��ԃI�[�o�[�̏ꍇ
			if (k < a_sum[i]) {
				continue;
			}

			int score = check(i);
			if (highscore < score) {
				highscore = score;
			}
		}

		System.out.println(highscore);

	}

	public static int check(int i) {

		// ��A�I�����_�̎c�莞��
		long zan = k - a_sum[i];

		log("����A��" + i + "���ǂ񂾁B����" + zan + "���c���Ă���B");

		// ��B��1�����ǂނ��Ƃ��ł��Ȃ��ꍇ
		if (zan < b_sum[0]) {
			log("�ˊ�B��1�����ǂނ��Ƃ��ł��Ȃ�");
			return i;
		}

		// ��B��1�������̏ꍇ
		if (m == 0) {
			log("�ˊ�B��1������");
			return i + 1;
		}

		// ��B��S���ǂ߂�ꍇ
		if (b_sum[m] <= zan) {
			log("�ˊ�B��S���ǂ߂�");
			return i + m;
		}

		// �ȉ��Ab_sum[]����T���B���ʂɒT���ƃ�(m)�����邯�Ǔ񕪒T���Ȃ热(logm)�ōςށB
		// �T���̂́uc���ǂ񂾂��ǂ���1���ǂނƃI�[�o�[����v�悤��c�B
		int l = 0;
		int r = m;
		int c;

		while (true) {

			// c�̖ڐ���t����Bl��r�̒��Ԃ�����Ƃ���B���ꂪ�񕪒T���B
			c = l + ((r - l) / 2);

			// �������ꍇ
			if (b_sum[c] <= zan && zan < b_sum[c + 1]) {
				log("�ˊ�B��" + c + "���ǂ߂�");
				return i + c;
			}

			// �܂��܂����Ԃ��]���Ă���ꍇ
			if (b_sum[c] < zan) {
				log("�@��B��" + c + "���ǂ�ł����Ԃ��܂��]���Ă���");
				l = c;
			}

			// ���łɃI�[�o�[���Ă���ꍇ
			if (zan < b_sum[c]) {
				log("�@��B��" + c + "���ǂނƃI�[�o�[���Ă��܂�");
				r = c;
			}

		}
	}

	public static void log(String str) {
		//System.out.println(str);
	}
}
