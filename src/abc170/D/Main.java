package abc170.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �A�C�e����
		int x[] = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}
		Arrays.sort(x);

		// ���₷�����邽�߂Ƀ��X�g�ɂ���
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if (!list.contains(x[i])) {
				list.add(x[i]);
			}
		}

		// �A�C�e�����P�����Ȃ瓚���� 0 �̂͂��c�H
		if (list.size() <= 1) {
			System.out.println(0);
			return;
		}

		// ���[�v
		int i = 0;
		while (i < list.size()) {

			int base = list.get(i);

			// �{������菜���Ă���
			int j = i + 1;
			while (j < list.size()) {

				int val = list.get(j);

				//System.out.println(list.toString());
				
				if (val % base == 0) {
					// ��菜���ꍇ
					//System.out.println(base + "��" + val + "���{���Ȃ̂ŏ���");
					list.remove(j);
				} else {
					// ��菜���Ȃ��ꍇ
					//System.out.println(base + "��" + val + "���{���łȂ��̂Ŏ�");
					j++;
				}

			}

			// ����
			i++;

		}

		// ����
		System.out.println(list.size());

	}
}
