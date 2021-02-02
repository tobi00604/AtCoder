package arc110.C;

import java.util.*;

// n-1�ӏ��̃X���b�v���P�񂸂g���āA����n�̔z����\�[�g������B

// ���������l�߂��Â��C�͂��邪�A�Ƃ肠�����ł����̂Œ�o�B
// O(n^2)����Ă�̂�TLE�ɂȂ�C������B�����������o�͗�͑S���ʂ�B

// ��o��̃����F
// ��͂�TLE�������B�ł����j�͍����Ă��B���Ƃ͍H�v���Čv�Z�ʂ�O(n)�ɗ��Ƃ��΂����I
// �Ȃ���Diff(1100)�ł���B���j�͕�����₷�����v���t���₷���̂ŁA�����̏d�����B
public class Main {

	static int[] p;
	static boolean[] used;
	static List<Integer> output;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		p = new int[n];
		used = new boolean[n];
		output = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
			used[i] = false;
		}

		// �傫���������珇�Ɍ��։^��ł���
		for (int target = n; target > 0; target--) {
			for (int i = 0; i < target - 1; i++) {
				// �^�[�Q�b�g����������X���b�v
				if (p[i] == target) {
					if (!swap(i, i + 1)) {
						// �g�p�ς݂̃X���b�v���܂��g�����瓚����-1
						System.out.println(-1);
						return;
					}
				}
			}
		}

		// ���ׂẴX���b�v���g���؂��ĂȂ��ꍇ��������-1
		if (output.size() != n - 1) {
			System.out.println(-1);
			return;
		}

		// ���ʏo��
		for (int z : output) {
			System.out.println(z);
		}
	}

	static boolean swap(int a, int b) {

		if (used[a]) {
			return false;
		}

		output.add(a + 1);

		int temp = p[a];
		p[a] = p[b];
		p[b] = temp;
		used[a] = true;
		return true;
	}
}
