package abc188.E;

import java.util.*;

// ���܂ł��낢���o���Ă������M�u�A�b�v�B���PDF�̒ʂ��DP���Ă݂�B
public class Main4 {

	static List<List<Integer>> graph; // �O���t
	static int[] kane;
	static int[] dp;
	static boolean[] available;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		kane = new int[n];
		dp = new int[n];
		available = new boolean[n];
		for (int v = 0; v < n; v++) {
			kane[v] = Integer.parseInt(sc.next());
			dp[v] = Integer.MAX_VALUE;
			available[v] = false;
		}
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int a = Integer.parseInt(sc.next()) - 1; // �n�_
			int b = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(a).add(b);
		}

		// dp[v] := �_v�ɓ��B�\�ȋ���̂����ł��������i
		dp[0] = kane[0];
		for (int v = 0; v < n; v++) {
			for (int e : graph.get(v)) {
				available[e] = true;
				dp[e] = Math.min(dp[v], Math.min(kane[v], dp[e]));
			}
		}

		// ����
		int result = Integer.MIN_VALUE;
		for (int v = 0; v < n; v++) {
			if (available[v]) {
				result = Math.max(result, kane[v] - dp[v]);
			}
		}
		System.out.println(result);
	}

}