package abc171.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		Integer n = new Integer(Integer.parseInt(sc.next())); // 品物の種類数
		Integer k = new Integer(Integer.parseInt(sc.next())); // 何個買うか
		Integer x[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			x[i] = new Integer(Integer.parseInt(sc.next()));
		}

		// ソート
		Arrays.sort(x);

		// 安いものk個を買おう
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += x[i];
		}
		System.out.println(sum);

	}
}
