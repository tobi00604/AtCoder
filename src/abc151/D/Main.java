package abc151.D;

import java.util.*;

public class Main {

	static int h; // 盤面の縦サイズ
	static int w; // 盤面の横サイズ
	static boolean[][] f; // 各マスは通行可能か
	static int[][] dist; // スタート地点からの各マスへの最短歩数

	public static void main(String[] args) {

		// 入力
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

		// スタート地点の位置がh*w通りある。全部試す。
		int maxTurn = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				maxTurn = Math.max(maxTurn, bfs(i, j));
			}
		}
		System.out.println(maxTurn);

	}

	static int bfs(int startH, int startW) {

		// コーナーケース　スタート地点が壁だったらスキップ
		if (!f[startH][startW]) {
			return -1;
		}

		// 変数初期化
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				dist[i][j] = -1;
			}
		}
		int maxWalk = 0;

		// スタート地点をキューに入れる
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(startH, startW));
		dist[startH][startW] = 0;

		// キューが空になるまでループ
		while (!queue.isEmpty()) {

			// キューからひとつ取り出す
			Point v = queue.poll();

			// 取り出した点から上方向
			Point next;
			next = new Point(v.x - 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// 取り出した点から下方向
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// 取り出した点から左方向
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				maxWalk = Math.max(maxWalk, dist[next.x][next.y]);
				queue.add(next);
			}

			// 取り出した点から右方向
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
