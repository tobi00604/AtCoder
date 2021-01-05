package abc121.C;

import java.util.*;

//�o�T: AtCoder Beginner Contest 121 C - Energy Drink Collector
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		Shop s[] = new Shop[n];
		for (int i = 0; i < n; i++) {
			int price = Integer.parseInt(sc.next());
			int zaiko = Integer.parseInt(sc.next());
			s[i] = new Shop(price, zaiko);
		}

		// �\�[�g�̋K�������
		Comparator<Shop> c = new Comparator<Shop>() {
			public int compare(Shop s1, Shop s2) {

				// ���i�̈�����
				return s1.price - s2.price;

			}
		};

		// �\�[�g�i�I�u�W�F�N�g�P�ʂ̃\�[�g�Ȃ̂Ŕz��a�ƘA�����Ĕz��b���ω��j
		Arrays.sort(s, c);

		// �m�F�p
		// for (int i = 0; i < n; i++) {
		// System.out.println(s[i].price + " " + s[i].zaiko);
		// }

		// ���������߂�
		long cost = 0;
		for (int i = 0; i < n; i++) {

			if (s[i].zaiko < m) {
				// ���̓X�̃h�����N�𔃂����
				m -= s[i].zaiko;
				cost += (long) s[i].zaiko * (long) s[i].price;
			} else {
				cost += (long) m * (long) s[i].price;
				System.out.println(cost);
				return;
			}
		}

	}
}

class Shop {

	int price; // �h�����N�̒l�i
	int zaiko; // �h�����N�̍݌�

	// �R���X�g���N�^
	public Shop(int price, int zaiko) {
		this.price = price;
		this.zaiko = zaiko;
	}
}
