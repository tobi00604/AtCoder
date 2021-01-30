package abc079.D;

import java.util.*;

// �d�݂��L���O���t������ē_1����e�_�֍s���ŒZ�R�X�g�����߂�Γ������o����̂ł́H
// �Ǝv�����̂ł���Ă݂�B�ł��_�C�N�X�g���@��������ƂȂ�����x���}���t�H�[�h�@�ŁB
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int n = 10; // �_�̐�
		int m = 90; // �ӂ̐�
		int s = 1; // �n�_
		List<List<Edge>> graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				long cost = Integer.parseInt(sc.next());
				if (i != j) {
					graph.get(j).add(new Edge(i, cost));
				}
			}
		}
		int[] target = new int[h * w];
		for (int i = 0; i < h * w; i++) {
			target[i] = Integer.parseInt(sc.next());
		}

		// �m�F�p
		// for (int v = 0; v < n; v++) {
		// System.out.println("�_" + v);
		// for (Edge e : graph.get(v)) {
		// System.out.println("�@��" + e.w + "�˓_" + e.to);
		// }
		// }

		// ��������x���}���t�H�[�h�@
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = Long.MAX_VALUE;
		}
		resultDist[s] = 0;

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

		// �����܂Ńx���}���t�H�[�h�@
		// resultDist[]�ɁA�_1����e�_�ւ̍ŒZ�R�X�g��������

		// ���������߂ďo��
		long totalCost = 0;
		for (int i = 0; i < h * w; i++) {
			if (target[i] == -1) {
				continue;
			}
			totalCost += resultDist[target[i]];
		}
		System.out.println(totalCost);
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
