package arc112.D;

import java.util.*;

public class Main {

	static int h;
	static int w;
	static boolean[][] ice;
	static boolean[][] reach;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		h = Integer.parseInt(sc.next());
		w = Integer.parseInt(sc.next());
		ice = new boolean[h][w];
		reach = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			String str = sc.next();
			for (int j = 0; j < w; j++) {
				ice[i][j] = (str.charAt(j) == '.') ? true : false;
				reach[i][j] = false;
			}
		}

		bfs();

		// �ʉ߂ł��Ȃ��s�Ɨ��􂢏o��
		boolean[] hh = new boolean[h];
		boolean[] ww = new boolean[w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!reach[i][j]) {
					hh[i] = true;
					ww[j] = true;
				}
			}
		}

		// Math.min(�ʉ߂ł��Ȃ��s��, �ʉ߂ł��Ȃ���) �����Ԃ񓚂��ł́H
		int result1 = 0;
		int result2 = 0;
		for (int i = 0; i < h; i++) {
			if (hh[i]) {
				result1++;
			}
		}
		for (int j = 0; j < w; j++) {
			if (ww[j]) {
				result2++;
			}
		}
		System.out.println(Math.min(result1, result2));

		// �m�F�p
//		System.out.println();
//		for (int i = 0; i < h; i++) {
//			for (int j = 0; j < w; j++) {
//				System.out.print(reach[i][j] ? 1 : 0);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println(Arrays.toString(hh));
//		System.out.println(Arrays.toString(ww));

	}

	static void bfs() {

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Point> queue = new ArrayDeque<Point>();
		reach[0][0] = true;
		queue.add(new Point(0, 0));

		// �L���[����ɂȂ�܂Ń��[�v
		while (!queue.isEmpty()) {

			// �L���[����ЂƂ��o��
			Point v = queue.poll();
			int inow;
			int jnow;

			// ���o�����_��������
			inow = v.i;
			jnow = v.j;
			while (true) {
				reach[inow][jnow] = true;
				inow = Math.max(0, inow - 1);
				if (inow == 0 || !ice[inow][jnow]) {
					if (!reach[inow][jnow]) {
						queue.add(new Point(inow, jnow));
					}
					break;
				}
			}

			// ���o�����_���牺����
			inow = v.i;
			jnow = v.j;
			while (true) {
				reach[inow][jnow] = true;
				inow = Math.min(h - 1, inow + 1);
				if (inow == h - 1 || !ice[inow][jnow]) {
					if (!reach[inow][jnow]) {
						queue.add(new Point(inow, jnow));
					}
					break;
				}
			}

			// ���o�����_���獶����
			inow = v.i;
			jnow = v.j;
			while (true) {
				reach[inow][jnow] = true;
				jnow = Math.max(0, jnow - 1);
				if (jnow == 0 || !ice[inow][jnow]) {
					if (!reach[inow][jnow]) {
						queue.add(new Point(inow, jnow));
					}
					break;
				}
			}

			// ���o�����_����E����
			inow = v.i;
			jnow = v.j;
			while (true) {
				reach[inow][jnow] = true;
				jnow = Math.min(w - 1, jnow + 1);
				if (jnow == w - 1 || !ice[inow][jnow]) {
					if (!reach[inow][jnow]) {
						queue.add(new Point(inow, jnow));
					}
					break;
				}
			}

		}
	}

	// �P�}�X�Ԃ�̏��
	static class Point {
		int i;
		int j;

		// �R���X�g���N�^
		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
