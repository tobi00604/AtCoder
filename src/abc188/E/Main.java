package abc188.E;

import java.util.*;

// �R�[�f�B���O���Ŏ��Ԑ؂�B
// DFS�Ŗׂ��̍ő�l��T���̂��Ǝv�����A
// DFS�̌v�Z�ʂ�O(V+E)�A���̃X�^�[�g�n�_��O(n)�A���vO(n(V+E))
// �ƂȂ��ĊԂɍ���Ȃ��C������B
// �����ŁA���̓r���ŖK�ꂽ�_�ŋ��𔃂����ꍇ�������i�s�Œ������邱�Ƃ�
// �u�������ʂ����_����܂��������X�^�[�g�v���Ȃ��čςނ悤�ɂ���Ƃ��H
public class Main {

	static List<List<Edge>> graph; // �O���t
	static long mouke = -1;
	static boolean[] asi;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�

		long[] kane = new long[n]; // ���̉��l
		for (int v = 0; v < n; v++) {
			kane[v] = Long.parseLong(sc.next());
		}

		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			long w = 0; // �d��
			graph.get(from).add(new Edge(to, w));
		}

		// �m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + v);
			for (Edge e : graph.get(v)) {
				System.out.println("�@��" + e.w + "�˓_" + e.to);
			}
		}

		// �ȉ���肩��
		asi = new boolean[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
		}
		dfs(0);
		System.out.println(Arrays.toString(asi));

	}

	static void dfs(int v) {
		asi[v] = true;
		for (Edge e : graph.get(v)) {
			int next = e.to; // ���̓_
			if (asi[next] == false) {
				dfs(next);
			}
		}
	}
}

class Edge {

	int to; // �s��̒��_
	long w; // ���̕ӂ̏d��

	// �R���X�g���N�^
	public Edge(int to, long w) {
		this.to = to;
		this.w = w;
	}
}