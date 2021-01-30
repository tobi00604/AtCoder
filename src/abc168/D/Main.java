package abc168.D;

import java.util.*;

// �����ǂ�ł������Ă݂��B
// �_0����e�_�֍ŒZ�����ňړ��������̂ŁABFS�؂����B
public class Main {

	static List<List<Integer>> graph; // �O���t
	static int[] dist; // �_0����̍ŒZ����
	static int[] pre; // �ЂƂO�̓_

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(from).add(to);
			graph.get(to).add(from); // �����O���t�ł���΋t����������
		}

		// ���ʗp�z������������Ă���A�_0���n�_�Ƃ���BFS
		dist = new int[n];
		pre = new int[n];
		for (int v = 0; v < n; v++) {
			dist[v] = -1;
			pre[v] = -1;
		}
		bfs(0);

		// No�̏ꍇ�̌��ʏo��
		for (int v = 0; v < n; v++) {
			if (dist[v] == -1) {
				System.out.println("No");
				return;
			}
		}

		// Yes�̏ꍇ�̌��ʏo��
		System.out.println("Yes");
		for (int v = 0 + 1; v < n; v++) {
			System.out.println(pre[v] + 1);
		}

	}

	static void bfs(int s) {

		// �X�^�[�g�n�_���L���[�ɓ����
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(s);
		dist[s] = 0;

		// �L���[����ɂȂ�܂Ń��[�v
		while (!queue.isEmpty()) {

			// �L���[����ЂƂ��o��
			int v = queue.poll();

			// ���̓_���ꂼ�ꏈ��
			for (int next : graph.get(v)) {

				// �ߋ��ɒ��ׂ��_�͍s���Ȃ�
				if (dist[next] != -1) {
					continue;
				}

				// �L���[�ɓ����
				pre[next] = v;
				dist[next] = dist[v] + 1;
				queue.add(next);
			}

		}
	}
}