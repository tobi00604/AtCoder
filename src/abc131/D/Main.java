package abc131.D;

import java.util.*;

// 貪欲法の練習…のはずがオブジェクト単位のソートの練習
public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Task t[] = new Task[n];
		for (int i = 0; i < n; i++) {
			int kibo = Integer.parseInt(sc.next());
			int sime = Integer.parseInt(sc.next());
			t[i] = new Task(kibo, sime);
		}

		// ソートの規則を作る
		Comparator<Task> c = new Comparator<Task>() {
			public int compare(Task task1, Task task2) {

				// 納期が等しいなら規模の降順、そうでなければ納期の昇順
				if (task1.sime == task2.sime) {
					return task2.kibo - task1.kibo;
				}
				return task1.sime - task2.sime;

			}
		};

		// ソート（オブジェクト単位のソートなので配列aと連動して配列bも変化）
		Arrays.sort(t, c);

		// 確認用
//		for (int i = 0; i < n; i++) {
//			System.out.println(t[i].kibo + " " + t[i].sime);
//		}

		// 貪欲法で答えを求める
		int now = 0;
		for (int i = 0; i < n; i++) {
			now += t[i].kibo;
			if (t[i].sime < now) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");

	}
}

class Task {

	int kibo; // タスクの規模
	int sime; // タスクの納期

	// コンストラクタ
	public Task(int kibo, int sime) {
		this.kibo = kibo;
		this.sime = sime;
	}
}
