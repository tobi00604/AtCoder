package abc176.D;

import java.util.*;

public class Main {

	static int h; // �Ֆʂ̏c�T�C�Y
	static int w; // �Ֆʂ̉��T�C�Y
	static boolean[][] f; // �e�}�X�͒ʍs�\��
	static int[][] dist; // �X�^�[�g�n�_����̊e�}�X�ւ̃R�X�g
	static List<Point> pointList1;
	static List<Point> pointList2;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		h = Integer.parseInt(sc.next());
		w = Integer.parseInt(sc.next());
		int startX = Integer.parseInt(sc.next()) - 1;
		int startY = Integer.parseInt(sc.next()) - 1;
		int goalX = Integer.parseInt(sc.next()) - 1;
		int goalY = Integer.parseInt(sc.next()) - 1;
		f = new boolean[h][w];
		dist = new int[h][w];
		pointList1 = new ArrayList<Point>();
		pointList2 = new ArrayList<Point>();
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = line.charAt(j) == '.' ? true : false;
				dist[i][j] = -1;
			}
		}

		// �X�^�[�g�n�_�ɗ����Ă���
		pointList2.add(new Point(startX, startY));
		dist[startX][startY] = 0;

		for (int warpCount = 0; warpCount < h * w; warpCount++) {

			// �����čs����}�X�����ׂĒT��
			pointList1 = pointList2;
			pointList2 = new ArrayList<Point>();
			for (Point p : pointList1) {
				bfs(p, warpCount);
			}

			// �m�F�p
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(dist[i][j]);
//				}
//				System.out.println();
//			}

			// �S�[�������H
			for (Point p : pointList2) {
				if (p.x == goalX && p.y == goalY) {
					System.out.println(dist[goalX][goalY]);
					return;
				}
			}

			// ���[�v�ōs����}�X�����ׂĒT��
			pointList1 = pointList2;
			pointList2 = new ArrayList<Point>();
			for (Point p : pointList1) {
				warp(p, warpCount);
			}

			// �m�F�p
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(dist[i][j]);
//				}
//				System.out.println();
//			}

			// �S�[�������H
			for (Point p : pointList2) {
				if (p.x == goalX && p.y == goalY) {
					System.out.println(dist[goalX][goalY]);
					return;
				}
			}
		}

		// �S�[���ł��Ȃ������ꍇ
		System.out.println("-1");
	}

	// start�}�X��������čs����ꏊ��T������
	static void bfs(Point start, int warpCount) {

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(start);
		dist[start.x][start.y] = warpCount;

		// �L���[����ɂȂ�܂Ń��[�v
		while (!queue.isEmpty()) {

			// �L���[����ЂƂ��o��
			Point v = queue.poll();

			// ���ƂŎg���̂Ń}�X���o���Ă�����
			pointList2.add(v);

			// ���o�����_��������
			Point next;
			next = new Point(v.x - 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// ���o�����_���牺����
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// ���o�����_���獶����
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// ���o�����_����E����
			next = new Point(v.x, v.y + 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

		}
	}

	// start�}�X���烏�[�v�ōs����ꏊ��T������
	static void warp(Point start, int warpCount) {

		for (int i = -2; i <= 2; i++) {
			for (int j = -2; j <= 2; j++) {
				int x = start.x + i;
				int y = start.y + j;
				if (0 <= x && x < h && 0 <= y && y < w && dist[x][y] == -1
						&& f[x][y]) {
					dist[x][y] = warpCount + 1;
					pointList2.add(new Point(x, y));
				}
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
