package abc088.D;

import java.util.*;

// BFSの練習になりそうなのでやってみる。迷路盤面の問題は初体験！
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
		int whiteNum = 0; // ついでに白マスの数を数えておく
		for (int i = 0; i < h; i++) {
			String line = sc.next();
			for (int j = 0; j < w; j++) {
				f[i][j] = line.charAt(j) == '.' ? true : false;
				dist[i][j] = -1;
				whiteNum = f[i][j] ? whiteNum + 1 : whiteNum;
			}
		}

		// 答えを求めて出力
		bfs();
		int turn = dist[h - 1][w - 1];
		System.out.println(turn == -1 ? -1 : whiteNum - turn - 1);
	}

	static void bfs() {

		// スタート地点をキューに入れる
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(new Point(0, 0));
		dist[0][0] = 0;

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
				queue.add(next);
			}

			// 取り出した点から下方向
			next = new Point(v.x + 1, v.y);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

			// 取り出した点から左方向
			next = new Point(v.x, v.y - 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
			}

			// 取り出した点から右方向
			next = new Point(v.x, v.y + 1);
			if (0 <= next.x && next.x < h && 0 <= next.y && next.y < w
					&& dist[next.x][next.y] == -1 && f[next.x][next.y]) {
				dist[next.x][next.y] = dist[v.x][v.y] + 1;
				queue.add(next);
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
