package abc195.D;

import java.util.*;

// ������p���������B���l���������̂��甠�ɓ�����×~�@���Ƃ肠��������Ă݂�B
// 
// �������̒�o�ł͉��L�Q�̃~�X�����������ߏC���B
// �E�傫���������ו�����������P�[�X���l�����Ă��Ȃ�����
// �E�N�G�����������邽�тɕϐ����������ׂ��Ȃ̂�Y��Ă���
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �ו���
		int m = Integer.parseInt(sc.next()); // ����
		int q = Integer.parseInt(sc.next()); // �N�G���̐�
		Item[] item = new Item[n];
		for (int i = 0; i < n; i++) {
			int w = Integer.parseInt(sc.next());
			int v = Integer.parseInt(sc.next());
			item[i] = new Item(w, v);
		}
		Box[] box = new Box[m];
		for (int i = 0; i < m; i++) {
			int id = i + 1;
			int size = Integer.parseInt(sc.next());
			box[i] = new Box(id, size);
		}
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = Integer.parseInt(sc.next());
			r[i] = Integer.parseInt(sc.next());
		}

		// �ו��͉��l�̍������̗D��Ń\�[�g
		// ���͑傫���̏��������̗D��Ń\�[�g
		Comparator<Item> c1 = new Comparator<Item>() {
			public int compare(Item s1, Item s2) {
				if (s2.v == s1.v) {
					return s2.w - s1.w;
				}
				return s2.v - s1.v;
			}
		};
		Arrays.sort(item, c1);
		Comparator<Box> c2 = new Comparator<Box>() {
			public int compare(Box s1, Box s2) {
				return s1.size - s2.size;
			}
		};
		Arrays.sort(box, c2);

		// Q�̃N�G��
		for (int query = 0; query < q; query++) {

			// �ϐ�������
			long result = 0;
			for (int j = 0; j < m; j++) {
				box[j].ok = true;
			}

			// �e�ו��ɂ���
			for (int i = 0; i < n; i++) {
//				System.out.println("�傫��" + item[i].w + "(���l" + item[i].v + ")��");

				// �������������̂��猩�Ă����āA������锠��������������
				for (int j = 0; j < m; j++) {
					if (l[query] <= box[j].id && box[j].id <= r[query]) {
						continue;
					}
					if (item[i].w <= box[j].size && box[j].ok == true) {
//						System.out.println("��" + box[j].id + "(�傫��" + box[j].size + ")�ɓ������B");
						result += item[i].v;
						box[j].ok = false;
						break;
					}
				}
			}

			// ������
			System.out.println(result);
		}

	}

	static class Item {
		int w; // �傫��
		int v; // ���l

		Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	static class Box {
		int id; // �ԍ�
		int size; // �傫��
		boolean ok; // �g�p�\��

		Box(int id, int size) {
			this.id = id;
			this.size = size;
			this.ok = true;
		}
	}
}
