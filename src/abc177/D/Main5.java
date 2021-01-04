package abc177.D;

import java.util.*;

// �o�P�b�g�ł͂Ȃ�UnionFind�ł���Ă݂�
public class Main5 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		UnionFindTree uf = new UnionFindTree(n);
		for (int i = 0; i < m; i++) {
			int left = Integer.parseInt(sc.next());
			int right = Integer.parseInt(sc.next());
			uf.unite(left - 1, right - 1);
		}

		// �R�[�i�[�P�[�X
		if (m == 0) {
			System.out.println(1);
			return;
		}

		// �m�F�p
		uf.printAllNode();

		// �ł��F�B�������l�́A�O���[�v�̐l�������߂�΁A���ꂪ����
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < uf.getSize(i)) {
				max = uf.getSize(i);
			}
		}

		System.out.println(max);

	}
}

class UnionFindTree {

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