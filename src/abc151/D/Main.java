package abc151.D;

import java.util.*;

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
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = line.charAt(j) == '.' ? true : false;
				dist[i][j] = -1;
			}
		}

		// �X�^�[�g�n�_�̈ʒu��h*w�ʂ肠��B�S�������B
		int maxTurn = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				maxTurn = Math.max(maxTurn, bfs(i, j));
			}
		}
		System.out.println(maxTurn);

	}

	static int bfs(int startH, int startW) {

		// �R�[�i�[�P�[�X�@�X�^�[�g�n�_���ǂ�������X�L�b�v
		if (!f[startH][startW]) {
			return -1;
		}

		// �ϐ�������
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dist[i][j] = -1;
			}
		}
		int maxWalk = 0;

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(startH, startW));
		dist[startH][startW] = 0;

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
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// ���o�����_���牺����
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// ���o�����_���獶����
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// ���o�����_����E����
			next = new Point(v.x, v.y + 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

		}

		return maxWalk;
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
