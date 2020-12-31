package abc162.E;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// �v�f��n�̔z��
		int array[];
		array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = 1;

		int cnt = 0;
		while (true) {

			cnt++;

			// ���񏈗�����z��
			System.out.println(Arrays.toString(array));

			// �z��̃A�C�e�����ׂĂ̍ő����
			int gcd = getGcd(array);
			System.out.println(" " + gcd);

			// �z��̃A�C�e�����P�����A�P���₷
			int i;
			for (i = 0; i < n; i++) {
				if (array[i] < k) {
					array[i]++;
					if (i != 0) {
						for (int j = 0; j < i; j++) {
							array[j] = 1;
						}
					}

					break;
				}
			}

			// �������₷�Ƃ��낪�Ȃ��Ȃ�����v���O�����I��
			if (i == n) {
				break;
			}

		}

		System.out.println(cnt + " LOOPS!");
		return;

	}

	public static int getGcd(int array[]) {

		if (array.length == 2) {
			return getTwoGcd(array[0], array[1]);
		} else {
			int partArray[];
			partArray = new int[array.length - 1];
			for (int i = 0; i < partArray.length; i++) {
				partArray[i] = array[i];
			}
			return getTwoGcd(getGcd(partArray),array[array.length-1]);
		}
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
