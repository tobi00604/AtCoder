package abc172.C;

import java.util.*;

// Main2�����ς�炸�s�����A������TLE�ɂȂ�BMain��舫�����Ă�B��蒼���Ă݂�B��o���̓N���X����Main�ɂ��邱��
public class Main3 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = new Integer(Integer.parseInt(sc.next())); // ��A�̍���
		int m = new Integer(Integer.parseInt(sc.next())); // ��B�̍���
		long k = new Integer(Integer.parseInt(sc.next())); // �Ǐ�����

		ArrayList<Integer> arrayA = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrayA.add(new Integer(Integer.parseInt(sc.next())));
		}

		ArrayList<Integer> arrayB = new ArrayList<Integer>();
		for (int j = 0; j < m; j++) {
			arrayB.add(new Integer(Integer.parseInt(sc.next())));
		}

		// ���X�g�̐擪���폜����̂͒x���炵���̂Ń��o�[�X���Ė�������폜����悤�ɂ��悤
		// (TLE�΍�B�s�����Ȃ̂��ς��Ȃ��Ǝv����)
		Collections.reverse(arrayA);
		Collections.reverse(arrayB);

		int loop = 0;
		while (true) {

			if (arrayA.size() == 0 && arrayB.size() == 0) {
				System.out.println(loop);
				return;
			} else if (arrayB.size() == 0) {
				k -= arrayA.get(arrayA.size() - 1);
				arrayA.remove(arrayA.size() - 1);
			} else if (arrayA.size() == 0) {
				k -= arrayB.get(arrayB.size() - 1);
				arrayB.remove(arrayB.size() - 1);
			} else {
				if (arrayA.get(arrayA.size() - 1) < arrayB.get(arrayB.size() - 1)) {
					k -= arrayA.get(arrayA.size() - 1);
					arrayA.remove(arrayA.size() - 1);
				} else {
					k -= arrayB.get(arrayB.size() - 1);
					arrayB.remove(arrayB.size() - 1);
				}
			}

			// �Ǐ����Ԃ��g���؂�����
			if (k < 0) {
				System.out.println(loop);
				return;
			}

			// ���̖{��
			loop++;
		}

	}
}
