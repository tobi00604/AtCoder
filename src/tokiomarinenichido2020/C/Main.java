package tokiomarinenichido2020.C;

import java.util.Scanner;

public class Main {

	// ���R���e�X�g�I����̏����@��������
	// �e���W���ǂꂭ�炢�̖��邳�Ȃ̂��A�f���ɐ����グ����@�ł�������ʁA���s���Ԑ��񒴉߂Ɂc�B
	// ���PDF����ѓ���ɂ��ƁA�d�����Ƃ炷��Ԃɒ��ڂ��A���邳�̑�����\������P�����Ƃ悢�炵���B
	// �i�Ⴆ�ΐ���P��5�Ԗڂ�-1��������A���W4�ɔ�ׂč��W5��1�i�K�Â��Ȃ����A�Ƃ������Ɓj
	// ����ƁA����P�́u�ݐϘa�v�ɂ����鐔��Q�����߂邾���ŁAQ�����̂܂܂��̖��̓����ɂȂ�̂ł���B
	// �ڂ����́u�ݐϘa�v��u�������@�v�ŃO�O�邱�ƁB�����AtCoder�Ŏg�������Ȓm�����Ǝv�����B
	// ���R���e�X�g�I����̏����@�����܂�

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �d���̌�
		int k = Integer.parseInt(sc.next()); // �����
		int x[] = new int[n + 1]; // ���̋���
		for (int i = 1; i <= n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}

		// �������Ă�����̐���z��ɂ���
		int light[] = new int[n + 1];

		// �����k����
		for (int loop = 0; loop < k; loop++) {

			// �������Ă�����̐���z��ɂ���
			for (int i = 1; i <= n; i++) {
				light[i] = 0;
			}

			// �e�X�̓d���ɂ���
			for (int i = 1; i <= n; i++) {

				// ���𓖂ĂĂ���
				int left = Math.max(i - x[i], 1);
				int right = Math.min(i + x[i], n);
				for (int j = left; j <= right; j++) {
					light[j]++;
				}
				// System.out.println("�d��" + i + "�̏Ƃ炷�͈́�" + left + "�`" +
				// right);
			}

			// ���̋������X�V
			System.arraycopy(light, 0, x, 0, x.length);

		}

		// ����
		for (int i = 1; i <= n; i++) {
			System.out.print(x[i]);
			if (i < n) {
				System.out.print(" ");
			}
		}
	}

}
