package abc116.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int h[] = new int[n];
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(sc.next());
		}

		// �z��h[]�����ׂ�0�ɂ��Ă������
		int result = 0;
		while (true) {

			// �����͈͂̍��[�����߂�
			int start = 0;
			boolean finishFlg = true;
			for (start = 0; start < n; start++) {
				if (h[start] > 0) {
					finishFlg = false;
					break;
				}
			}

			// ��ƏI������
			if (finishFlg) {
				System.out.println(result);
				return;
			}

			// �����
			int end = 0;
			for (end = start; end < n; end++) {
				if (h[end] == 0) {
					break;
				}
				h[end]--;
			}

			result++;
		}
	}
}
