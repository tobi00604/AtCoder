package abc151.C;

import java.util.*;

// �O�X��̒�o����育�Ƃ̕s���𐔂�ێ����Ă��Ȃ��o�O����
// �O��̒�o���o�O�͒���������TLE�ɂȂ�B���X�g���_�����H
// ���񁨃��X�g�ł͂Ȃ��z��ɂ����BAC�Ȃ邩�H
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] p = new int[m];
		int[] s = new int[m];
		for (int i = 0; i < m; i++) {
			p[i] = Integer.parseInt(sc.next());
			s[i] = (sc.next().equals("AC") ? 1 : 0);
		}

		// ��育�Ƃ�AC��
		int[] ac = new int[100001];
		// ��育�Ƃ�WA��
		int[] miss = new int[100001];

		long result1 = 0;
		long result2 = 0;

		for (int i = 0; i < m; i++) {

			// �����ς݂̖��ɑ΂����o�͖���
			if (ac[p[i]] == 1) {
				continue;
			}

			if (s[i] == 1) {
				result1++;
				result2 += miss[p[i]];
				ac[p[i]]++;
			} else {
				miss[p[i]]++;
			}

		}

		System.out.println(result1 + " " + result2);
	}
}
