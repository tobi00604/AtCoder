package abc157.D;

import java.util.*;

// unionfind�ł���Ă݂���TLE
// ���ʂ̃O���t�̖��Ƒ����Ă���Ă݂���TLE
// �����ŗ����𕹗p���ĉ����Ă݂�A����Ƀu���b�N���X�g�̏W�v���Ō�ɂ܂Ƃ߂Ă���Ă݂�
public class Main3 {

	public static List<List<Integer>> graph;
	public static List<List<Integer>> graph2;
	static int now; // �����̔ԍ�
	static List<Integer> friends; // �����̂���O���[�v�̗F�B
	static int dislike; // �����̂���O���[�v�ŁA�����̃u���b�N�l��

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int friendNum = Integer.parseInt(sc.next());
		int blockNum = Integer.parseInt(sc.next());

		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		List<Pair> friendList = new ArrayList<Pair>();
		for (int i = 0; i < friendNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			friendList.add(new Pair(a, b));
			friendList.add(new Pair(b, a));
			graph.get(a).add(b);
			graph.get(b).add(a); // �����O���t�Ȃ̂ŋt����������
		}

		graph2 = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph2.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < blockNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			graph2.get(a).add(b);
			graph2.get(b).add(a); // �����O���t�Ȃ̂ŋt����������
		}

		// �F�B�֌W�łȂ����Ă���O���[�v
		UnionFindTree uf = new UnionFindTree(n);
		for (Pair p : friendList) {
			uf.unite(p.a, p.b);
		}

		// �m�F�p
		// uf.printAllNode();

		// n�s�̃N�G��
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {

			// �����̂���F�B�O���[�v�̐l��
			result[i] = uf.getSize(i);

			// ���łɗF�B�̐l��������
			result[i] -= graph.get(i).size();

			// ����������
			result[i]--;
		}

		// �u���b�N���Ă���l�͓����������
		for (int i = 0; i < n; i++) {
			for (int j : graph2.get(i)) {
				if (uf.isSame(i, j)) {
					result[i]--;
				}
			}
		}

		// ���ʏo��
		StringBuilder resultStr = new StringBuilder();
		resultStr.append(result[0]);
		for (int i = 0 + 1; i < n; i++) {
			resultStr.append(" " + result[i]);
		}
		System.out.println(resultStr);
	}

	static void dfs(int v) {
		friends.add(v);

		if (graph2.get(now).contains(v)) {
			dislike++;
		}

		for (int e : graph.get(v)) {
			if (!friends.contains(e)) {
				dfs(e);
			}
		}
	}

	static class Pair {

		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static class UnionFindTree {

		int[] parent;
		int[] size;

		// �R���X�g���N�^
		UnionFindTree(int n) {
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = -1;
				size[i] = 1;
			}
		}

		// x��������؂̍���Ԃ�
		int root(int x) {
			if (parent[x] == -1) {
				return x;
			}
			parent[x] = root(parent[x]); // ���łɌo�H���k
			return parent[x];
		}

		// x��y�������؂ɂ��邩�ǂ������ׂĕԂ�
		boolean isSame(int x, int y) {
			return root(x) == root(y);
		}

		// x��y�𓯂��؂ɂ���
		void unite(int x, int y) {
			if (x == y) {
				return;
			}
			int rx = root(x); // x�̍�
			int ry = root(y); // y�̍�
			if (rx == ry) {
				return;
			}
			// �؂̍�������������H�v�����Ă���
			if (size[rx] < size[ry]) {
				int tmp = rx;
				rx = ry;
				ry = tmp;
			}
			// �Ȃ�
			parent[ry] = rx;
			size[rx] += size[ry];
		}

		// x��������؂̃T�C�Y��Ԃ�
		int getSize(int x) {
			return size[root(x)];
		}

		// �m�F�p
		void printAllNode() {

			System.out.println(Arrays.toString(parent));
			System.out.println(Arrays.toString(size));

			for (int i = 0; i < parent.length; i++) {
				System.out.println(i + "�̍���" + root(i));
				System.out.println(i + "�̍�����" + getSize(i));
			}
		}
	}
}