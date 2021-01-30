package abc190.E;

import java.util.*;

public class Main {

	static List<List<Integer>> graph; // �O���t
	static boolean[] asi; // dfs�̑���

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(sc.next());
			b[i] = Integer.parseInt(sc.next());
		}
		int k = Integer.parseInt(sc.next());
		int[] c = new int[k];
		for (int i = 0; i < k; i++) {
			c[i] = Integer.parseInt(sc.next());
		}

		// �Ƃ肠����������-1���ǂ����𔻒�
		UnionFindTree uf = new UnionFindTree(n + 1);
		for (int i = 0; i < m; i++) {
			uf.unite(a[i], b[i]);
		}
		for (int i = 0 + 1; i < k; i++) {
			if (!uf.isSame(c[i - 1], c[i])) {
				System.out.println(-1);
				return;
			}
		}
		
		// �����O���t�����
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()); // �n�_
			int to = Integer.parseInt(sc.next()); // �I�_
			graph.get(from).add(to);
			graph.get(to).add(from); // �����O���t�ŋt����������
		}
		
		// BFS�ŐΗ�̒��������߂�B
		// �����ׂẴX�^�[�g�n�_�ik�ʂ�j���K�v������
		// �����ׂĂ̖ړI�n���ЂƂƂ��蓥�񂾂�BFS�𒆒f���Ă���
		// ���s�������ƋA�肪���̗����ɃR�X�g�������邱�Ƃɒ���
		for(int start = 1; start <= k; start++){
			// �����Ŏ��Ԑ؂�
		}

	}

	static void dfs(int v) {
		asi[v] = true;
		for (int e : graph.get(v)) {
			int next = e; // ���̓_
			if (asi[next] == false) {
				dfs(next);
			}
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
