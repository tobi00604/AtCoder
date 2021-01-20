package arc111.B;

import java.util.*;

// �O��̒�o�ł�unionfind�Ŗ����������Ƃ��ĂȂ����o�O�����̂�
// �ʏ�̖����O���t�ŉ����Ă݂�B
public class Main2 {

	static List<List<Integer>> graph; // �O���t
	static int[] asi; // DFS�̑��ՋL�^�p
	static Set<Integer> nonTree; // �؂ł͂Ȃ��ƕ��������O���t�̎n�_�ԍ�
	static Map<Integer, Integer> map; // �A�������̃T�C�Y

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = 400001; // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v <= n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int from = Integer.parseInt(sc.next()); // �n�_
			int to = Integer.parseInt(sc.next()); // �I�_
			graph.get(from).add(to);
			graph.get(to).add(from); // �����O���t�Ȃ̂ŋt����������
		}

		// �ϐ�������
		asi = new int[n + 1];
		nonTree = new HashSet<Integer>();
		map = new TreeMap<Integer, Integer>();

		// DFS���J��Ԃ�
		for (int v = 0; v < n; v++) {

			// �������ׂ��_�̓X�L�b�v
			if (asi[v] == 1) {
				continue;
			}

			// �}����؂Ȃ��_�i�܂���ɓo�ꂵ�Ȃ��F�j�̓X�L�b�v
			if (graph.get(v).size() == 0) {
				continue;
			}

			// ���̓_����DFS�J�n
			map.put(v, 0);
			dfs(v, -1, v);
		}

		// �������o��
		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (asi[entry.getKey()] == 1) {
				result += entry.getValue();
				if (!nonTree.contains(entry.getKey())) {
					result--;
				}
			}
		}
		System.out.println(result);

	}

	static void dfs(int v, int from, int root) {

		// �V�������_�ɓ��������̂ŋL�^
		asi[v]++;
		map.replace(root, map.get(root) + 1);

		// ���̒��_��
		for (int next : graph.get(v)) {

			// �ЂƂO�̓_�ɖ߂�悤�ȓ����͋֎~
			// �������O���t�Ȃ̂œ_�Ɠ_�̊Ԃɉ��H�ƕ��H�̂Q�{�̎}������
			// ���H���g���Ɩ؂Ȃ̂ɕH���Ɣ��f���Ă��܂�����
			if (next == from) {
				continue;
			}

			if (asi[next] == 0) {
				dfs(next, v, root);
			} else {
				// ��x���񂾓_�֍s�����Ƃ��Ă����炱��͖؂ł͂Ȃ�
				nonTree.add(root);
			}
		}
	}
}
