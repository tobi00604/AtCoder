package abc188.C;

import java.util.*;

// �Ȃ��������^�C���G���[�ɂȂ�c
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int playerNum = (int) Math.pow(2, n);

		long[] rate = new long[playerNum];
		for (int i = 0; i < playerNum; i++) {
			rate[i] = Long.parseLong(sc.next());
		}
		long[] inputRate = rate;

		while (true) {

			long[] newRate = new long[playerNum / 2];

			for (int i = 0; i < playerNum; i += 2) {
				newRate[i / 2] = Math.max(rate[i], rate[i + 1]);
			}

			rate = newRate;
			playerNum /= 2;
			// System.out.println(Arrays.toString(rate));

			if (playerNum == 2) {
				break;
			}

		}

		long target = Math.min(rate[0], rate[1]);
		for (int i = 0; i < (int) Math.pow(2, n); i++) {
			if (target == inputRate[i]) {
				System.out.println(i + 1);
				return;
			}
		}

	}
}
