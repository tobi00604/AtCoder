package abc159.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] ball = new int[n]; // 各整数
		for (int i = 0; i < n; i++) {
			ball[i] = Integer.parseInt(sc.next());
		}

		Map<Integer, Long> appearMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (appearMap.containsKey(ball[i])) {
				appearMap.replace(ball[i], appearMap.get(ball[i]) + 1L);
			} else {
				appearMap.put(ball[i], 1L);
			}
		}

		Map<Integer, Long> kumiMap = new HashMap<>();
		long totalKumi = 0;
		for (Map.Entry<Integer, Long> entry : appearMap.entrySet()) {
			long kumi = entry.getValue() * (entry.getValue() - 1) / 2;
			kumiMap.put(entry.getKey(), kumi);
			totalKumi += kumi;
		}

		for (int i = 0; i < n; i++) {

			// ボールに書かれている数値
			int b = ball[i];

			// このボールを禁止したら、この数値は残り何個あるか
			long kazu = appearMap.get(b) - 1;

			// この数値の選び方は何通りあるか
			long newKumi = kazu * (kazu - 1) / 2;

			// 他の数値の選び方と混ぜて出力
			System.out.println(totalKumi - kumiMap.get(b) + newKumi);
		}

	}
}
