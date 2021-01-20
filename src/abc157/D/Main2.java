package abc157.D;

import java.util.*;

//UnionFind�ł͂Ȃ��ʏ�̃O���t�̖��Ƃ��Ă���Ă݂悤
public class Main2 {

	public static List<List<Integer>> graph;
	public static List<List<Integer>> graph2;
	static int now; // �����̔ԍ�
	static List<Integer> friends; // �����̂���O���[�v�̗F�B
	static int dislike; // �����̂���O���[�v�ŁA�����̃u���b�N�l��

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int friendNum = Integer.parseInt(sc.next());
		int blockNum = Integer.parseInt(sc.next());

		// ���́i�F�B�֌W�̖����O���t�j
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < friendNum; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(from).add(to);
			graph.get(to).add(from); // �����O���t�Ȃ̂ŋt����������
		}

		// ���́i�u���b�N�֌W�̖����O���t�j
		graph2 = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph2.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < blockNum; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			graph2.get(from).add(to);
			graph2.get(to).add(from); // �����O���t�Ȃ̂ŋt����������
		}

		// n�s�̃N�G��
		int[] result = new int[n];
		for (now = 0; now < n; now++) {

			// �T��(DFS)
			friends = new ArrayList<Integer>();
			dislike = 0;
			dfs(now);
			result[now] = friends.size();

			// ���łɗF�B�̐l�����Ђ�
			result[now] -= graph.get(now).size();

			// �u���b�N�̐l�����Ђ�
			result[now] -= dislike;

			// �������Ђ�
			result[now]--;
		}

		// ���ʏo��
		StringBuilder resultStr = new StringBuilder();
		resultStr.append(result[0]);
		for (int i = 0 + 1; i < n; i++) {
			resultStr.append(" " + result[i]);
		}
		System.out.println(resultStr);
	}

	static void dfs(int v) {
		friends.add(v);

		if (graph2.get(now).contains(v)) {
			dislike++;
		}

		for (int e : graph.get(v)) {
			if (!friends.contains(e)) {
				dfs(e);
			}
		}
	}
}