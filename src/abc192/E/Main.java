package abc192.E;

import java.util.*;

// �����ǂ�ł������Ă݂�
// ����Ă邱�Ƃ̓_�C�N�X�g��
public class Main {

	static int n; // �_�̐�
	static int m; // �ӂ̐�
	static int startSta; // �X�^�[�g�w
	static int goalSta; // �S�[���w
	static List<List<Edge>> graph; // �O���t
	static long[] time; // �e�_�ɓ����ł��鎞��

	public static void main(String[] args) {

		// ���́i����͏d�݂Ȃ��O���t�Ƃ���j
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		m = Integer.parseInt(sc.next());
		startSta = Integer.parseInt(sc.next()) - 1;
		goalSta = Integer.parseInt(sc.next()) - 1;
		graph = new ArrayList<List<Edge>>();
		time = new long[n];
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
			time[v] = Long.MAX_VALUE;
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			long w = Long.parseLong(sc.next());
			long go = Long.parseLong(sc.next());
			graph.get(from).add(new Edge(to, w, go));
			graph.get(to).add(new Edge(from, w, go)); // �����O���t�ł���΋t����������
		}

		// �T���I
		search();
		System.out.println(time[goalSta] == Long.MAX_VALUE ? -1 : time[goalSta]);

	}

	static void search() {

		// �X�^�[�g�w���L���[�ɓ����
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> Long.compare(time[a], time[b]));
		pq.add(startSta);
		time[startSta] = 0;

		while (!pq.isEmpty()) {

			// ���̎��Œ��ׂ�w�����߂�(�ł�time���������w)
			int v = pq.poll();

			// �L�тĂ���}�̐�̉w���ꂼ��
			for (Edge e : graph.get(v)) {

				// �ő������������X�V�ł�����A���������𒲂ׂ����̂ŃL���[�ɒǉ����Ă���
				if (time[e.to] > calc(time[v], e.go, e.w)) {
					time[e.to] = calc(time[v], e.go, e.w);
					pq.add(e.to);
				}
			}

		}
	}

	// �}�ňړ�������̉w�ɓ������鎞�������߂�
	static long calc(long now, long go, long w) {
		if (now % go == 0) {
			return now + w;
		} else {
			return now + (go - (now % go)) + w;
		}
	}

	// �}���
	static class Edge {

		int to; // �s��̒��_
		long w; // ���̕ӂ��ړ�����̂ɂ����鎞��
		long go; // ���̕ӂ𑖂�d�Ԃ̏o������

		// �R���X�g���N�^
		public Edge(int to, long w, long go) {
			this.to = to;
			this.w = w;
			this.go = go;
		}
	}
}