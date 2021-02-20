package abc138.D;

import java.util.*;

// Ki
// �����ǂ�ł������Ă݂�
public class Main {

	static List<List<Integer>> ki; // �O���t
	static boolean[] asi; // DFS�̑��ՋL�^�p
	static long[] counter; // �����ێ��p

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int q = Integer.parseInt(sc.next());
		ki = new ArrayList<List<Integer>>();
		asi = new boolean[n];
		counter = new long[n];
		for (int v = 0; v < n; v++) {
			ki.add(new ArrayList<Integer>());
			asi[v] = false;
			counter[v] = 0;
		}
		for (int e = 0; e < n - 1; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			ki.get(from).add(to);
			ki.get(to).add(from);
		}
		for (int i = 0; i < q; i++) {
			int p = Integer.parseInt(sc.next()) - 1; // �_�ԍ�
			long x = Integer.parseInt(sc.next()); // �J�E���^�[�����l
			counter[p] += x;
		}

		dfs(0, 0);

		System.out.println(Arrays.toString(counter).replace("[", "").replace(",", "").replace("]", ""));

	}

	static void dfs(int v, long plus) {

		// �V�������_�ɓ��������̂ŋL�^
		asi[v] = true;
		counter[v] += plus;

		// ���̒��_��
		for (int next : ki.get(v)) {

			if (asi[next] == false) {
				dfs(next, counter[v]);
			}
		}
	}
}
