package abc185.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		int m = Integer.parseInt(sc.next());

		// m��0�̏ꍇ��1������
		if (m == 0) {
			System.out.println(1);
			return;
		}

		long[] blue = new long[m];
		for (int i = 0; i < m; i++) {
			blue[i] = Long.parseLong(sc.next());
		}

		// �\�[�g�i�����������ɂȂ邱�Ƃɒ��Ӂj
		Arrays.sort(blue);

		// �ł��������Ԃ̃T�C�Y��T���i���ꂪ k �ɂȂ�j
		long k = n;
		boolean sukimaExistFlg = false;
		for (int i = 0; i <= m; i++) {
			long l = (i == 0) ? 0 : blue[i - 1];
			long r = (i == m) ? (n + 1) : blue[i];
			long sukima = r - l - 1;
			if (sukima != 0) {
				sukimaExistFlg = true;
				if (sukima < k) {
					k = sukima;
				}
			}
		}

		// ���Ԃ��ЂƂ��Ȃ�������n���R�s�v
		if (!sukimaExistFlg) {
			System.out.println(0);
			return;
		}

		//System.out.println("���n���R�̃T�C�Y k �� " + k);

		// ���������߂�
		long result = 0;
		for (int i = 0; i <= m; i++) {
			long l = (i == 0) ? 0 : blue[i - 1];
			long r = (i == m) ? (n + 1) : blue[i];
			long sukima = r - l - 1;
			if (sukima != 0) {
				long result_sub = sukima / k;
				if (sukima % k != 0) {
					result_sub++;
				}
				//System.out.println(sukima + "��h�邽��" + result_sub + "�񉟂��܂���");
				result += result_sub;
			}
		}

		// �o��
		System.out.println(result);
	}
}
