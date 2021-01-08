package abc162.D;

import java.util.*;

// �O��̒�o�̓i�C�[�u�ȉ�@��TLE�������̂�
// �����ǂ�ł������Ă݂�
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String str = sc.next();

		// �R�[�i�[�P�[�X
		if (n < 3) {
			System.out.println(0);
			return;
		}

		// �����P�𖞂����������Q�𖞂����Ȃ����̂��J�E���g
		long result1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				// i��j�̒l����k�͎��R�Ɍ��܂�
				int k = j + j - i;
				if (n <= k) {
					continue;
				}

				// �J�E���g
				char ci = str.charAt(i);
				char cj = str.charAt(j);
				char ck = str.charAt(k);
				if (ci != cj && cj != ck && ck != ci) {
					result1++;
				}
			}
		}

		// �����P�𖞂������̂��J�E���g
		long result2 = 0;
		long i1 = 0;
		long i2 = 0;
		long i3 = 0;
		for (int i = 0; i < n; i++) {
			char c = str.charAt(i);
			if (c == 'R') {
				i1++;
			}
			if (c == 'G') {
				i2++;
			}
			if (c == 'B') {
				i3++;
			}
		}
		result2 = i1 * i2 * i3;

		// �����P�𖞂����ď����Q�����������̂��o��
		System.out.println(result2 - result1);

	}

}
