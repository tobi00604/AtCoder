package arc022.B;

import java.util.*;

// �ג������َq

// ���Ⴍ�Ƃ�@�������ƍ�����̂ɂ������̒�o��TLE�ɂȂ����B
// ArrayList���d���̂����H������HashSet�i�����͊o���Ȃ����d���͓���Ȃ��W���j�ő�p���Ă݂�B
// �]�k�P�FHashSet�ŏ������o�������ꍇ��LinkedHashSet���g���Ƃ����炵�����Ǐ����x���Ȃ�Ȃ����ȁB
// �]�k�Q�Fhttps://java-reference.com/java_collection_compare.html
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// ���Ⴍ�Ƃ�@
		HashSet<Integer> set = new HashSet<>();
		long result = 0;
		int l = 0;
		int r = 0;
		while (l < n) {

			// �s����Ƃ���܂ŉE���i�߂�
			// System.out.println(l + "_" + r);
			while (r < n && !set.contains(a[r])) {
				set.add(a[r]);
				r++;
				// System.out.println(Arrays.toString(set.toArray()));
			}
			// System.out.println(l + "_" + r);

			// �n�C�X�R�A�L�^
			result = Math.max(result, set.size());

			// ����𓮂���
			if (l == r) {
				// ����ƈꏏ�ɉE����������Ƃ�
				l++;
				r++;
				// System.out.println("�E����ЂƂi�߂܂���");
			} else {
				// �ӂ��ɍ��肪�ЂƂi�ނƂ�
				l++;
				set.remove(a[l - 1]);
				// System.out.println("set����" + a[l - 1] + "���폜���܂���");
			}
		}

		System.out.println(result);
	}
}
