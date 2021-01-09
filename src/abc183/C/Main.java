package abc183.C;

import java.util.*;

public class Main {

	// ���T�C�Y
	public static int n;

	// ���ׂĂ̓��������郊�X�g
	public static ArrayList<String> tour;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());
		long k = Integer.parseInt(sc.next());
		long t[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				t[i][j] = Integer.parseInt(sc.next());
			}
		}

		// ���肦�铹���̗񋓂𓾂�
		tour = new ArrayList<String>();
		saiki("0");

		// ���ꂼ��̓����ɂ���
		int result = 0;
		for (String str : tour) {
			long cost = 0;

			// ��ʔ�����߂�
			for (int i = 0; i < n - 1; i++) {
				int from = Integer.parseInt(str.charAt(i) + "");
				int to = Integer.parseInt(str.charAt(i + 1) + "");
				cost += t[from][to];
			}

			// �Ō�ɋA���Ă����ʔ���Y�ꂸ�ɑ���
			int from = Integer.parseInt(str.charAt(n - 1) + "");
			int to = 0;
			cost += t[from][to];

			// ���ʏo�͗p
			if (cost == k) {
				result++;
			}
		}

		System.out.println(result);

	}

	public static void saiki(String value) {

		// ���������X�g�ɓ���čċA�ł��؂�
		if (value.length() == n) {
			tour.add(value);
			return;
		}

		// ����
		for (int i = 0; i < n; i++) {

			// ���łɌ������s�s�̓X�L�b�v
			if (value.contains(i + "")) {
				continue;
			}

			saiki(value + i);
		}
	}
}
