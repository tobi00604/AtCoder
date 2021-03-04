package abc126.D;

import java.util.*;

// DFS�𑖂点�āA������̎}��ʂ邽�тɐF�𔽓]���Ȃ���_�ɒ��F���Ă����A
// �Ƃ������j���v�������̂ł���Ă݂�
public class Main {

	static List<List<Edge>> graph; // �O���t
	static boolean[] result; // �_0���瓞�B�\���ǂ����̔��茋��
	static boolean[] white;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = n - 1; // �ӂ̐�
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			long w = Long.parseLong(sc.next()); // �d��
			graph.get(from).add(new Edge(to, w));
			graph.get(to).add(new Edge(from, w));
		}

		// �m�F�p
		// for (int v = 0; v < n; v++) {
		// System.out.println("�_" + v);
		// for (Edge e : graph.get(v)) {
		// System.out.println("�@��" + e.w + "�˓_" + e.to);
		// }
		// }

		// �T��
		result = new boolean[n];
		white = new boolean[n];
		Arrays.fill(result, false);
		Arrays.fill(white, false);
		dfs(0, true);

		// ����
		for (int v = 0; v < n; v++) {
			System.out.println(white[v] ? 1 : 0);
		}

	}

	static void dfs(int v, boolean color) {
		result[v] = true;
		white[v] = color;
		for (Edge e : graph.get(v)) {
			if (result[e.to] == false) {
				dfs(e.to, (e.w % 2 == 0) ? white[v] : !white[v]);
			}
		}
	}

	static class Edge {

		int to; // �s��̒��_
		long w; // ���̕ӂ̏d��

		// �R���X�g���N�^
		public Edge(int to, long w) {
			this.to = to;
			this.w = w;
		}
	}
}
