package abc176.D;

import java.util.*;

public class Main {

	static int h; // 盤面の縦サイズ
	static int w; // 盤面の横サイズ
	static boolean[][] f; // 各マスは通行可能か
	static int[][] dist; // スタート地点からの各マスへのコスト
	static List<Point> pointList1;
	static List<Point> pointList2;

	public static void main(String[] args) {

		// 入力
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

		// スタート地点に立っている
		pointList2.add(new Point(startX, startY));
		dist[startX][startY] = 0;

		for (int warpCount = 0; warpCount < h * w; warpCount++) {

			// 歩いて行けるマスをすべて探索
			pointList1 = pointList2;
			pointList2 = new ArrayList<Point>();
			for (Point p : pointList1) {
				bfs(p, warpCount);
			}

			// 確認用
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(dist[i][j]);
//				}
//				System.out.println();
//			}

			// ゴールした？
			for (Point p : pointList2) {
				if (p.x == goalX && p.y == goalY) {
					System.out.println(dist[goalX][goalY]);
					return;
				}
			}

			// ワープで行けるマスをすべて探索
			pointList1 = pointList2;
			pointList2 = new ArrayList<Point>();
			for (Point p : pointList1) {
				warp(p, warpCount);
			}

			// 確認用
//			for (int i = 0; i < h; i++) {
//				for (int j = 0; j < w; j++) {
//					System.out.print(dist[i][j]);
//				}
//				System.out.println();
//			}

			// ゴールした？
			for (Point p : pointList2) {
				if (p.x == goalX && p.y == goalY) {
					System.out.println(dist[goalX][goalY]);
					return;
				}
			}
		}

		// ゴールできなかった場合
		System.out.println("-1");
	}

	// startマスから歩いて行ける場所を探索する
	static void bfs(Point start, int warpCount) {

		// スタート地点をキューに入れる
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(start);
		dist[start.x][start.y] = warpCount;

		// キューが空になるまでループ
		while (!queue.isEmpty()) {

			// キューからひとつ取り出す
			Point v = queue.poll();

			// あとで使うのでマスを覚えておこう
			pointList2.add(v);

			// 取り出した点から上方向
			Point next;
			next = new Point(v.x - 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// 取り出した点から下方向
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// 取り出した点から左方向
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

			// 取り出した点から右方向
			next = new Point(v.x, v.y + 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = warpCount;
				queue.add(next);
			}

		}
	}

	// startマスからワープで行ける場所を探索する
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

	// １マスぶんの情報
	static class Point {
		int x;
		int y;

		// コンストラクタ
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
