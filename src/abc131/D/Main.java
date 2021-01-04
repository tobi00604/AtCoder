package abc131.D;

import java.util.*;

// �×~�@�̗��K�c�̂͂����I�u�W�F�N�g�P�ʂ̃\�[�g�̗��K
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		Task t[] = new Task[n];
		for (int i = 0; i < n; i++) {
			int kibo = Integer.parseInt(sc.next());
			int sime = Integer.parseInt(sc.next());
			t[i] = new Task(kibo, sime);
		}

		// �\�[�g�̋K�������
		Comparator<Task> c = new Comparator<Task>() {
			public int compare(Task task1, Task task2) {

				// �[�����������Ȃ�K�͂̍~���A�����łȂ���Δ[���̏���
				if (task1.sime == task2.sime) {
					return task2.kibo - task1.kibo;
				}
				return task1.sime - task2.sime;

			}
		};

		// �\�[�g�i�I�u�W�F�N�g�P�ʂ̃\�[�g�Ȃ̂Ŕz��a�ƘA�����Ĕz��b���ω��j
		Arrays.sort(t, c);

		// �m�F�p
//		for (int i = 0; i < n; i++) {
//			System.out.println(t[i].kibo + " " + t[i].sime);
//		}

		// �×~�@�œ��������߂�
		int now = 0;
		for (int i = 0; i < n; i++) {
			now += t[i].kibo;
			if (t[i].sime < now) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");

	}
}

class Task {

	int kibo; // �^�X�N�̋K��
	int sime; // �^�X�N�̔[��

	// �R���X�g���N�^
	public Task(int kibo, int sime) {
		this.kibo = kibo;
		this.sime = sime;
	}
}
