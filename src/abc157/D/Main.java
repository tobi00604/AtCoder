package abc157.D;

import java.util.*;

// �����ǂ�ł������Ă݂����ATLE�ɂȂ����B�㔼��2�d���[�v�����Ԃ�_���B
// UnionFind�Łu�_i���܂ރO���[�v�̓_�񋓁v���ł���Α������B
// �܂�UnionFind�̖؂ɑ΂���DFS����K�v��������Ă��ƁH
// �A�����X�g�̎���������DFS�L�c�����A�ϒ��z��̔z��Ɏ��������K�v���肻���B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int friendNum = Integer.parseInt(sc.next());
		int blockNum = Integer.parseInt(sc.next());
		List<Pair> friendList = new ArrayList<Pair>();
		for (int i = 0; i < friendNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			friendList.add(new Pair(a, b));
			friendList.add(new Pair(b, a));
		}
		List<Pair> blockList = new ArrayList<Pair>();
		for (int i = 0; i < blockNum; i++) {
			int a = Integer.parseInt(sc.next()) - 1;
			int b = Integer.parseInt(sc.next()) - 1;
			blockList.add(new Pair(a, b));
			blockList.add(new Pair(b, a));
		}

		// �F�B�֌W�łȂ����Ă���O���[�v
		UnionFindTree uf = new UnionFindTree(n);
		for (Pair p : friendList) {
			uf.unite(p.a, p.b);
		}

		// �m�F�p
		uf.printAllNode();

		// n�s�̃N�G��
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {

			// �����̂���F�B�O���[�v�̐l��
			int temp = uf.getSize(i);
			// System.out.println(i + "�F" + temp);

			// ���łɗF�B�̐l�����Ђ�
			for (Pair p : friendList) {
				if (i == p.a && uf.isSame(i, p.b)) {
					// System.out.println(" F" + i + p.b);
					temp--;
				}
			}

			// �u���b�N�̐l�����Ђ�
			for (Pair p : blockList) {
				if (i == p.a && uf.isSame(i, p.b)) {
					// System.out.println(" B" + i + p.b);
					temp--;
				}
			}

			// �������Ђ�
			temp--;

			// �c�������ʂ��F�B���
			result[i] = temp;
		}

		// ���ʏo��
		String resultStr = "" + result[0];
		for (int i = 0 + 1; i < n; i++) {
			resultStr += " " + result[i];
		}
		System.out.println(resultStr);
	}
}

class Pair {

	int a;
	int b;

	Pair(int a, int b) {
		this.a = a;
		this.b = b;
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