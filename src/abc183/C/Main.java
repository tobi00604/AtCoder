package abc183.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		int t[][] = new int[8][8];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				t[i][j] = Integer.parseInt(sc.next());
			}
		}

		// �m�F�p
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(t[i][j] + " ");
			}
			System.out.println("");
		}

		// ���̃T�C�Y�I�ɑS�T���i�܂�n(n!)�̃A���S���Y���j�ł悳����������
		// ����̗񋓁i4����������1234, 1243, 1324, 1342, �c�� 4! �ʂ�j��
		// ���܂������ł��Ȃ��Ď��Ԑ؂�B
		// ���������i���o�[���ۂ��ċA�֐����H

	}
}
