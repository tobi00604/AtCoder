package abc107.C;

import java.util.*;

// ���_���� K+1 �ȏ㗣��Ă���낤�����͍s���Ă����Ӗ��B�R�X�g�v�Z���X�L�b�v���Ă����B
// �Ƃ��낪�O��̒�o�ł͂��̃X�L�b�v�����Ƀo�O��������WA�ɂȂ��Ă��܂����B
// �����ŉ��L�̃��W�b�N�́A���S���Ƃ��āA���Ӗ��ȃR�X�g�v�Z�������Ă�郍�W�b�N�ƂȂ��Ă���B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		long[] x = new long[n];
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(sc.next());
		}

		// �S�T��
		int left = 0;
		int right = k - 1;
		long cost;
		long minCost = -1;
		while (true) {

			right = left + k - 1;

			if (right == n) {
				break;
			}

			cost = Math.abs(x[left]) + Math.abs(x[left] - x[right]);
			if (cost < minCost || minCost == -1) {
				minCost = cost;
			}

			cost = Math.abs(x[right]) + Math.abs(x[left] - x[right]);
			if (cost < minCost) {
				minCost = cost;
			}

			left++;
		}

		System.out.println(minCost);
	}
}
