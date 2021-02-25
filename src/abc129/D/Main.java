package abc129.D;

import java.util.*;

// �����ǂ�ł������Ă݂�
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		boolean[][] f = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = (str.charAt(j) == '.') ? true : false;
			}
		}

		// ���֐L�т���̏Ƃ炷�}�X��
		int[][] l = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!f[i][j]) {
					l[i][j] = 0; // ��
				} else if (j == 0) {
					l[i][j] = 1; // �[
				} else {
					l[i][j] = l[i][j - 1] + 1;
				}
			}
		}

		// �E�֐L�т���̏Ƃ炷�}�X��
		int[][] r = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = w - 1; j >= 0; j--) {
				if (!f[i][j]) {
					r[i][j] = 0; // ��
				} else if (j == w - 1) {
					r[i][j] = 1; // �[
				} else {
					r[i][j] = r[i][j + 1] + 1;
				}
			}
		}

		// ��֐L�т���̏Ƃ炷�}�X��
		int[][] u = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!f[i][j]) {
					u[i][j] = 0; // ��
				} else if (i == 0) {
					u[i][j] = 1; // �[
				} else {
					u[i][j] = u[i - 1][j] + 1;
				}
			}
		}

		// ���֐L�т���̏Ƃ炷�}�X��
		int[][] d = new int[h][w];
		for (int i = h - 1; i >= 0; i--) {
			for (int j = 0; j < w; j++) {
				if (!f[i][j]) {
					d[i][j] = 0; // ��
				} else if (i == h - 1) {
					d[i][j] = 1; // �[
				} else {
					d[i][j] = d[i + 1][j] + 1;
				}
			}
		}

		// ����
		int result = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int temp = l[i][j] + r[i][j] + u[i][j] + d[i][j] - 3;
				result = Math.max(result, temp);
			}
		}
		System.out.println(result);

	}
}
