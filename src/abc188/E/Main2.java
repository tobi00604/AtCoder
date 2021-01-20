package abc188.E;

import java.util.*;

// �R�[�f�B���O���Ŏ��Ԑ؂�B
// DFS�Ŗׂ��̍ő�l��T���̂��Ǝv�����A
// DFS�̌v�Z�ʂ�O(V+E)�A���̃X�^�[�g�n�_��O(n)�A���vO(n(V+E))
// �ƂȂ��ĊԂɍ���Ȃ��C������B
// �����ŁA���̓r���ŖK�ꂽ�_�ŋ��𔃂����ꍇ�������i�s�Œ������邱�Ƃ�
// �u�������ʂ����_����܂��������X�^�[�g�v���Ȃ��čςނ悤�ɂ���Ƃ��H
public class Main2 {

	static List<List<Integer>> graph; // �O���t
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

		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()) - 1; // �n�_
			int to = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(from).add(to);
		}

		// �m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + (v + 1));
			for (int e : graph.get(v)) {
				System.out.println("�@�˓_" + (e + 1));
			}
		}

	}

	static void dfs(int v) {
		asi[v] = true;
		for (int e : graph.get(v)) {
			if (asi[e] == false) {
				dfs(e);
			}
		}
	}
}