package joi2008yo.E;

import java.util.*;

// ������ׂ�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int maxX = Integer.parseInt(sc.next());
		int maxY = Integer.parseInt(sc.next());
		int[][] inputArray = new int[maxX][maxY];
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				inputArray[i][j] = Integer.parseInt(sc.next());
			}
		}

		// �u2��x��v�񃋁[�v
		int maxCount = 0;
		for (int i = 0; i < (1 << maxX); i++) {

			int[][] senbei = new int[maxX][maxY];
			for (int tate = 0; tate < maxX; tate++) {
				for (int yoko = 0; yoko < maxY; yoko++) {
					senbei[tate][yoko] = inputArray[tate][yoko];
				}
			}

			// �Ђ�����Ԃ��s�͂Ђ�����Ԃ�
			for (int j = 0; j < maxX; j++) {
				if ((1 & i >> j) == 1) {
					for (int yoko = 0; yoko < maxY; yoko++) {
						senbei[j][yoko] = (senbei[j][yoko] == 0) ? 1 : 0;
					}
				}
			}

			// �m�F�p
			// printArray(senbei, maxX, maxY);

			int count = 0;
			for (int yoko = 0; yoko < maxY; yoko++) {
				// �u0�v�̐����u1�v�̐��̑����ق����R�X�g�ɉ��Z
				int temp = 0;
				for (int tate = 0; tate < maxX; tate++) {
					temp += senbei[tate][yoko];
				}
				count += Math.max(temp, maxX - temp);
				// System.out.print(Math.max(temp, maxX - temp));
			}
			// System.out.println("=" + count);
			maxCount = Math.max(maxCount, count);

		}

		System.out.println(maxCount);

	}

	static void printArray(int[][] a, int maxX, int maxY) {
		for (int i = 0; i < maxX; i++) {
			for (int j = 0; j < maxY; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
