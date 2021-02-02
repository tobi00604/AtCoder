package abc150.C;

import java.util.*;

// ����S�T���̗��K
public class Main {

	public static int n;
	public static ArrayList<String> tour;

	public static void main(String[] args) {

		// ���́i�s�s�̐��j
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());

		// ���́i���̖����L�̓��́j
		String p = "";
		String q = "";
		for (int i = 0; i < n; i++) {
			p += (Integer.parseInt(sc.next()) - 1) + "";
		}
		for (int i = 0; i < n; i++) {
			q += (Integer.parseInt(sc.next()) - 1) + "";
		}

		// ����񋓁i�s�s0�`�s�sn-1������j
		tour = new ArrayList<String>();
		for (int start = 0; start < n; start++) {
			saiki(start + "");
		}

		// �m�F�p
		// for (String walk : tour) {
		// System.out.println(walk);
		// }

		// ��������
		String[] a = new String[tour.size()];
		int index = 0;
		for (String walk : tour) {
			a[index] = walk;
			index++;
		}
		Arrays.sort(a);
		int result = 0;
		for (int i = 0; i < tour.size(); i++) {
			if (a[i].equals(p)) {
				result += i + 1;
			}
			if (a[i].equals(q)) {
				result -= i + 1;
			}
		}
		System.out.println(Math.abs(result));

	}

	// ����񋓗p�̍ċA�֐�
	public static void saiki(String walk) {

		// ���������X�g�ɓ���čċA�ł��؂�
		if (walk.length() == n) {
			tour.add(walk);
			return;
		}

		// ���̓s�s�i�܂��ʂ��ĂȂ��s�s�j��
		for (int i = 0; i < n; i++) {
			if (!walk.contains(i + "")) {
				saiki(walk + i);
			}
		}
	}
}