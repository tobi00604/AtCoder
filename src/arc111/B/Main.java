package arc111.B;

import java.util.*;

// ����ǂ񂾂�A�S��؂ƌ��Ȃ��ĉ������j�̓o�b�`�������Ă����I
// ������o����WA�������ꍇ�A�������킩���B����e�X�g�P�[�X�����悤�B
public class Main {

	// UnionFind�����Ƃ��ɕs�v�Ȏ}���̂Ă����Ƃ̂���؂�
	// ���̔ԍ���ێ����郊�X�g�B�O���t���؂��ǂ����̔���Ɏg���B
	public static Set<Integer> waste;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		waste = new HashSet<Integer>();
		int n = Integer.parseInt(sc.next());
		UnionFindTree uf = new UnionFindTree(400001);
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(sc.next());
			int b = Integer.parseInt(sc.next());
			uf.unite(a, b);
		}

		int result = 0;
		for (int i = 0; i < 400001; i++) {

			// ���̓_�����ł͂Ȃ��Ȃ�X�L�b�v
			if (uf.parent[i] != -1) {
				continue;
			}

			// �m�F�p
			// System.out.println("�_" + i + "�����̖؂̃T�C�Y��" + uf.getSize(i));

			// ���̖؂̃T�C�Y-1 �����̖؂̃X�R�A�B�؂̎}�̖{���́u�T�C�Y-1�v������B
			result += uf.getSize(i) - 1;

			// ���̖؂����Ƃ��Ɏ̂Ă��}���������Ȃ�A�X�R�A�������1������
			if (waste.contains(i)) {
				result++;
			}
		}

		System.out.println(result);
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
				waste.add(root(x));
				return;
			}
			int rx = root(x); // x�̍�
			int ry = root(y); // y�̍�
			if (rx == ry) {
				waste.add(rx);
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
