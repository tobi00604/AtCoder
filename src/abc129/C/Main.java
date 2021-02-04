package abc129.C;

import java.util.*;

// �������̒�o��TLE�ɂȂ����B���X�g�ł͂Ȃ��z��ő�p���Ă݂�B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		boolean[] ok = new boolean[n + 3];
		for (int i = 0; i < n + 3; i++) {
			ok[i] = true;
		}
		for (int i = 0; i < m; i++) {
			ok[Integer.parseInt(sc.next())] = false;
		}
		int hou = 1000000007;

		// DP����
		// dp[i]:=�K�i��i�i�ڂɍs���ړ����@�̐�
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i <= n; i++) {

			if (ok[i + 1] && i + 1 <= n) {
				dp[i + 1] += dp[i];
				dp[i + 1] %= hou;
			}
			if (ok[i + 2] && i + 2 <= n) {
				dp[i + 2] += dp[i];
				dp[i + 2] %= hou;
			}
		}

		// �m�F�p
		// System.out.println(Arrays.toString(dp));

		// ����
		System.out.println(dp[n]);
	}
}
