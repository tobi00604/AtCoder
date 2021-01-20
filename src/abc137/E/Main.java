package abc137.E;

import java.util.*;

// �����ɂȂ�Ȃ��R�[�h�����A�����Ȃ�̓��B�_�Ƃ��Ē�o���Ă����B
// ���̃R�[�h���ƁA���o�͗�R�ɂ���悤�ȁu���Ӗ��ȕ��H�v���E���� -1 ���o�͂��Ă��܂��B
// �u���Ӗ��ȕ��H�v�͖������Ȃ���΂Ȃ�Ȃ��I
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		int p = Integer.parseInt(sc.next()); // 1��̈ړ��ɂ����闿��

		// �d�ݕt���L���O���t
		List<List<Edge>> graph = new ArrayList<List<Edge>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			long w = Long.parseLong(sc.next()); // �d�݁i����̓R�C���̖����j

			// ����̖���1��ړ����邲�Ƃɗ��� p ��������
			w -= p;

			// ����̖��͍Œ��H���Ȃ̂ŏd�݂𐳕����]
			w *= -1;

			graph.get(from).add(new Edge(to, w));
		}

		// �m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + v);
			for (Edge e : graph.get(v)) {
				System.out.println("�@��" + e.w + "�˓_" + e.to);
			}
		}

		// �ȉ��A�x���}���t�H�[�h�@�B�n�_����e�_�ւ̍ŒZ���������߂�B
		boolean resultNegativeCycle = false;
		long resultDist[] = new long[n];
		for (int i = 0; i < n; i++) {
			resultDist[i] = 9999999;
		}
		resultDist[0] = 0;

		// �ɘa������n�񔽕����邱�Ƃœ��������߂Ă���
		for (int iter = 0; iter < n; iter++) {

			boolean updateFlg = false;

			// �_���ꂼ��ɂ���
			for (int v = 0; v < n; v++) {

				// ���g���܂� �� �Ȃ�A��������o�Ă����ӂ͍l���O
				if (resultDist[v] == 9999999) {
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
			System.out.println(-resultDist[n - 1]);
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