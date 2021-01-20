package abc137.E;

import java.util.*;

// �O��̒�o�ł́A���o�͗�R�ɂ���悤�ȁu���Ӗ��ȕ��H�v�Ɉ������������̂ŁA
// ���������ۂ� "�s�v�ȓ_" ��􂢏o���������A�x���}���t�H�[�h�@�����钼�O�ɒǉ��B
// �Q�l�ɂ����T�C�g�@https://sigma1113.hatenablog.com/entry/2019/08/12/130042
public class Main2 {

	static public List<List<Edge>> graph;
	static public List<List<Edge>> graph2;
	static int[] result; // �_0���瓞�B�\���ǂ����̔��茋��

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		int p = Integer.parseInt(sc.next()); // 1��̈ړ��ɂ����闿��
		int[] inputA = new int[m];
		int[] inputB = new int[m];
		long[] inputC = new long[m];
		for (int e = 0; e < m; e++) {
			inputA[e] = Integer.parseInt(sc.next()) - 1; // �n�_
			inputB[e] = Integer.parseInt(sc.next()) - 1; // �I�_
			inputC[e] = Long.parseLong(sc.next()); // �d�݁i����̓R�C���̖����j
		}

		// DFS���邽�߂̗L���O���t���Q��ލ��
		// graph�����ǂ���̗L���O���t
		// graph2�����Ƃ͕ӂ̌������t�ɂ����L���O���t
		graph = new ArrayList<List<Edge>>();
		graph2 = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
			graph2.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = inputA[e]; // �n�_
			int to = inputB[e]; // �I�_
			graph.get(from).add(new Edge(to, 0));
			graph2.get(to).add(new Edge(from, 0));
		}

		// graph��DFS���āA�n�_���炽�ǂ���Ȃ��_��􂢏o���A
		// graph2��DFS���āA�I�_�ւ��ǂ���Ȃ��_��􂢏o��
		result = new int[n];
		dfs(0);
		dfs2(n - 1);

		// ��L�Q���DFS�Ő􂢏o���� "�s�v�ȓ_" �͖������āA
		// ���߂ăO���t�����i�����������߂̏d�ݕt���L���O���t�j
		graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = inputA[e]; // �n�_
			int to = inputB[e]; // �I�_
			long w = inputC[e]; // �d�݁i����̓R�C���̖����j

			// "�s�v�ȓ_" ����
			if (result[from] != 11 || result[to] != 11) {
				continue;
			}

			// ����̖���1��ړ����邲�Ƃɗ��� p ��������
			w -= p;

			// ����̖��͍Œ��H���Ȃ̂ŏd�݂𐳕����]
			w *= -1;

			graph.get(from).add(new Edge(to, w));
			graph2.get(to).add(new Edge(from, w));
		}

		// �m�F�p
//		for (int v = 0; v < n; v++) {
//			System.out.println("�_" + (v + 1));
//			for (Edge e : graph.get(v)) {
//				System.out.println("�@��" + e.w + "�˓_" + (e.to + 1));
//			}
//		}

		// �ȉ��A�x���}���t�H�[�h�@�B�n�_����e�_�ւ̍ŒZ���������߂�B
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = Long.MAX_VALUE;
		}
		resultDist[0] = 0;

		// �ɘa������n�񔽕����邱�Ƃœ��������߂Ă���
		for (int iter = 0; iter < n; iter++) {

			boolean updateFlg = false;

			// �_���ꂼ��ɂ���
			for (int v = 0; v < n; v++) {

				// ���g���܂� �� �Ȃ�A��������o�Ă����ӂ͍l���O
				if (resultDist[v] == Long.MAX_VALUE) {
					continue;
				}

				// ���̓_����o�Ă����ӂ��ꂼ��ɂ���
				for (Edge e : graph.get(v)) {

					// �ɘa
					if (resultDist[v] + e.w < resultDist[e.to]) {
						resultDist[e.to] = resultDist[v] + e.w;
						updateFlg = true;
					}
				}
			}

			// ��x���ɘa���������Ȃ���������͉����Ă���
			if (!updateFlg) {
				break;
			}

			// n��ڂ̔����ł��ɘa�����������畉�H���������Ƃ�������
			if (iter == n - 1 && updateFlg) {
				resultNegativeCycle = true;
			}
		}

		// ���ʏo��
		if (resultNegativeCycle) {
			// ���H���������ꍇ�� No ���o��
			System.out.println("-1");
		} else {
			// ���H���Ȃ������ꍇ�͍ŒZ�����𐳕����]���ďo��
			System.out.println(Math.max(0, -resultDist[n - 1]));
		}

	}

	// �n�_���炽�ǂ���Ȃ��_��􂢏o�����߂�DFS
	static void dfs(int v) {
		result[v]++;
		for (Edge e : graph.get(v)) {
			int next = e.to; // ���̓_
			if (result[next] == 0) {
				dfs(next);
			}
		}
	}

	// �I�_�ւ��ǂ���Ȃ��_��􂢏o�����߂�DFS
	static void dfs2(int v) {
		result[v] += 10;
		for (Edge e : graph2.get(v)) {
			int next = e.to; // ���̓_
			if (result[next] < 10) {
				dfs2(next);
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