package abc075.C;

import java.util.*;

public class Main {

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

		// ���Ԃɋ����ǂ������肵�Ă���
		int result = 0;
		for (int i = 0; i < m; i++) {

			// ����������Ȃ��ӂ��g�킸��unionfind������Ă݂�
			UnionFindTree uf = new UnionFindTree(n);
			for (int j = 0; j < m; j++) {
				if (i != j) {
					uf.unite(a[j] - 1, b[j] - 1);
				}
			}

			// �m�F�p
			// uf.printAllNode();

			// �����unionfind���؂ł͂Ȃ��тɂȂ��Ă����狴���ƕ�����
			int treeNum = 0;
			for (int j = 0; j < n; j++) {
				if (uf.root(j) == j) {
					treeNum++;
				}
			}
			if (treeNum == 2) {
				result++;
			}

		}

		System.out.println(result);

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