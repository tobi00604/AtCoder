package abc161.D;

import java.util.*;

// DFS(�[���D��T��)�̗��K�B
public class Main {

	// ���ׂẴ��������������郊�X�g
	public static ArrayList<Long> lunlun;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());

		lunlun = new ArrayList<Long>();
		saiki(1);
		saiki(2);
		saiki(3);
		saiki(4);
		saiki(5);
		saiki(6);
		saiki(7);
		saiki(8);
		saiki(9);

		// �ł������������X�g�̒��g�\�[�g
		Collections.sort(lunlun);

		// ���X�g�̒��g��S��
		for (long p : lunlun) {
			//System.out.println(p);
		}

		// k�Ԗڂɏ��������������������߂�
		System.out.println(lunlun.get(k - 1));
	}

	// �����ŗ^����ꂽ���������������X�g�ɓ���āA���̒T���֐i�ފ֐�
	public static void saiki(long value) {

		// ���X�g�Ɋi�[
		lunlun.add(value);

		// ���̐����A�����������̌�����11�������Ȃ̂ŁA11���ɂȂ肻���ȏꍇ�͑ł��؂�
		if (1000000000 <= value) {
			return;
		}

		// ����
		if (value % 10 == 0) {
			saiki(value * 10);
			saiki(value * 10 + 1);
		} else if (value % 10 == 9) {
			saiki(value * 10 + 8);
			saiki(value * 10 + 9);
		} else {
			saiki(value * 10 + value % 10 - 1);
			saiki(value * 10 + value % 10);
			saiki(value * 10 + value % 10 + 1);
		}
	}

}
