package abc191.E;

import java.util.*;

// �d�݂��L���O���t�̍ŒZ�o�H���A�������u�n�_�ƏI�_�������_�v�B
// 30���قǔ�₵�āADFS�̃v���O���������������
// �Ȃ񂩂悭�킩��Ȃ��B��肩���B����o�B
public class Main {

	static int s;
	static long[] result;
	static boolean[] asi;
	static List<List<Edge>> graph;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�

		// �d�ݕt���L���O���t
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			long w = Long.parseLong(sc.next()); // �d��
			graph.get(from).add(new Edge(to, w));
		}

		// �m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + v);
			for (Edge e : graph.get(v)) {
				System.out.println("�@��" + e.w + "�˓_" + e.to);
			}
		}

		// �e�n�_�ɂ���
		for (s = 0; s < n; s++) {

			// �ϐ�������
			result = new long[n];
			asi = new boolean[n];
			for (int i = 0; i < n; i++) {
				result[i] = Long.MAX_VALUE;
				asi[i] = false;
			}
			result[s] = 0;
			asi[s] = true;

			// �T��
			dfs(s, 0);

			// ���ʏo��
			if (result[s] == 0) {
				// �A���Ă���Ȃ��Ȃ�-1
				System.out.println("-1");
			} else {
				// �n�_����n�_�ւ̍ŒZ����
				System.out.println(result[s]);
			}
		}

	}

	static void dfs(int v, long dist) {
		System.out.println(v + "_" + dist);
		asi[v] = true;
		result[v] = dist;
		for (Edge e : graph.get(v)) {
			int next = e.to; // ���̓_
			long newDist = e.w; // ���̓_�ւ̏d��
			if (next == s) {
				if (result[s] == 0) {
					result[s] = dist;
				} else {
					result[s] = Math.min(result[s], dist);
				}
			} else {
				dfs(next, dist + newDist);
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
