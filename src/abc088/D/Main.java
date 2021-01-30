package abc088.D;

import java.util.*;

// BFS�̗��K�ɂȂ肻���Ȃ̂ł���Ă݂�B���H�Ֆʂ̖��͏��̌��I
public class Main {

	static int h; // �Ֆʂ̏c�T�C�Y
	static int w; // �Ֆʂ̉��T�C�Y
	static boolean[][] f; // �e�}�X�͒ʍs�\��
	static int[][] dist; // �X�^�[�g�n�_����̊e�}�X�ւ̍ŒZ����

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		h = Integer.parseInt(sc.next());
		w = Integer.parseInt(sc.next());
		f = new boolean[h][w];
		dist = new int[h][w];
		int whiteNum = 0; // ���łɔ��}�X�̐��𐔂��Ă���
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = line.charAt(j) == '.' ? true : false;
				dist[i][j] = -1;
				whiteNum = f[i][j] ? whiteNum + 1 : whiteNum;
			}
		}

		// ���������߂ďo��
		bfs();
		int turn = dist[h - 1][w - 1];
		System.out.println(turn == -1 ? -1 : whiteNum - turn - 1);
	}

	static void bfs() {

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(0, 0));
		dist[0][0] = 0;

		// �L���[����ɂȂ�܂Ń��[�v
		while (!queue.isEmpty()) {

			// �L���[����ЂƂ��o��
			Point v = queue.poll();

			// ���o�����_��������
			Point next;
			next = new Point(v.x - 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

			// ���o�����_���牺����
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

			// ���o�����_���獶����
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

			// ���o�����_����E����
			next = new Point(v.x, v.y + 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

		}
	}

	// �P�}�X�Ԃ�̏��
	static class Point {
		int x;
		int y;

		// �R���X�g���N�^
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
