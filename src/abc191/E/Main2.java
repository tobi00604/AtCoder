package abc191.E;

import java.util.*;

// �R���e�X�g���͊����ł��Ȃ������̂ō�����Ē���B
// �U���̏o������\���_���O���t�ɑ��݂��Ă���_�C�N�X�g�����ĎU�����������߂���j�B
// ����������Ƃ͈Ⴄ��肩�������A���o�͗�P�`�R�͂��܂��ʂ����̂Œ�o���Ă݂�B
public class Main2 {

	static List<List<Edge>> graph;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�

		// �d�ݕt���L���O���t
		// ����������̖��͏o�����Ɠ���������ʂ������̂œ_��2�d�ɂ���
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

		// �e������_�C�N�X�g��
		for (int s = 0; s < n; s++) {

			// ���̃X�^�[�g�n�_�𑝐�
			graph.add(new ArrayList<Edge>());
			for (Edge e : graph.get(s)) {
				graph.get(n).add(new Edge(e.to, e.w));
			}

			// ���̃X�^�[�g�n�_����_�C�N�X�g��
			long[] saitan = dijkstra(n);
			System.out.println(saitan[s] == Long.MAX_VALUE ? -1 : saitan[s]);

			// ���̃X�^�[�g�n�_���폜
			graph.remove(n);
		}

	}

	// start����e�_�ւ̍ŒZ�����i�D��x�L���[���g��ver�j
	static long[] dijkstra(int start) {

		// �ϐ����������āA�X�^�[�g�w���L���[�ɓ����
		long[] result = new long[graph.size()];
		Arrays.fill(result, Long.MAX_VALUE);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Long.compare(result[a], result[b]));
		pq.add(start);
		result[start] = 0;

		while (!pq.isEmpty()) {

			// �o���_v�iresult���ł����������j����L�тĂ��铹���ꂼ��
			int v = pq.poll();
			for (Edge e : graph.get(v)) {

				// ���̒����ɘa�ł�����A�������������ׂ����̂ŃL���[�ɒǉ�
				if (result[e.to] > result[v] + e.w) {
					result[e.to] = result[v] + e.w;
					pq.add(e.to);
				}
			}

		}

		return result;
	}

	// start����e�_�ւ̍ŒZ�����i�P��ver�j
	// ��TLE�ɂȂ����̂ŃR�����g�A�E�g
//	static long[] dijkstra(int start) {
//
//		// �ϐ�������
//		long[] result = new long[graph.size()];
//		boolean[] asi = new boolean[graph.size()];
//		Arrays.fill(result, Long.MAX_VALUE);
//		Arrays.fill(asi, false);
//		result[start] = 0;
//
//		for (int loop = 0; loop < graph.size(); loop++) {
//
//			// �o���_�����߂�
//			int now = -1;
//			long min = Long.MAX_VALUE;
//			for (int v = 0; v < graph.size(); v++) {
//				if (!asi[v] && result[v] < min) {
//					now = v;
//					min = result[v];
//				}
//			}
//
//			// �o���_�����܂�Ȃ�������I�����Ă悢
//			if (now == -1) {
//				break;
//			}
//
//			// �o���_����L�тĂ��铹�̐�̓_���ɘa
//			for (Edge e : graph.get(now)) {
//				result[e.to] = Math.min(result[now] + e.w, result[e.to]);
//			}
//
//			// ����̏o���_�͍���o���_�Ɏg�����Ƃ͂Ȃ�
//			asi[now] = true;
//		}
//
//		return result;
//	}

	// ���P�̏��
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
