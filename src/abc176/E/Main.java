package abc176.E;

import java.util.*;

// ���I����̊��z��
// �c���ɉ����L�т锚�e���P�u���āA�Ȃ�ׂ���������̔���R�₷���B��������}�X�ɂ����e��u����B
// �����Łu�ł����������s��T���Ă��ׂĔR�₵�A���ɍł������������T���Ă��ׂĔR�₷�v�Ƃ���
// ���W�b�N����������A�e�X�g�P�[�X130�̂���5���s�����A���ǎ��ԓ��ɐ����ł����B
// �R���e�X�g�I����ɋC�t�������A�u�ł����������s�v�������q�b�g�����Ƃ��ǂ����邩���l�����Ă��Ȃ������B
// �Ⴆ�Έȉ��̓��͂̂Ƃ��A������������3�����A���̃��W�b�N����2���o�͂���Ă��܂��B
// 3 2 3
// 2 2
// 1 1
// 3 1
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h_input = Integer.parseInt(sc.next());
		int w_input = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		int hCount[];
		hCount = new int[300001];
		int wCount[];
		wCount = new int[300001];
		int hInput[];
		hInput = new int[300001];
		int wInput[];
		wInput = new int[300001];

		// ���ʒu���
		for (int i = 0; i < m; i++) {
			hInput[i] = Integer.parseInt(sc.next());
			wInput[i] = Integer.parseInt(sc.next());
		}

		// �s���Ƃɔ��𐔂���
		for (int i = 0; i < m; i++) {
			hCount[hInput[i]]++;
		}

		// �ǂ̍s�ɔ��e��u���������߂悤
		int h_max_index = 1;
		int h_max = 0;
		for (int i = 1; i < 300001; i++) {
			if (h_max < hCount[i]) {
				h_max = hCount[i];
				h_max_index = i;
			}
		}
		// System.out.println("�ł����������s�@" + h_max_index);
		// System.out.println("���̍s�̔��̐��@" + h_max);

		// �񂲂Ƃɔ��𐔂���
		// �i���������������e��u�����Ƃɂ����s�ɂ��锠�̓X���[�j
		for (int i = 0; i < m; i++) {
			if (hInput[i] != h_max_index) {
				wCount[wInput[i]]++;
			}
		}

		// �ǂ̗�ɔ��e��u���������߂悤
		int w_max_index = 1;
		int w_max = 0;
		for (int i = 1; i < 300001; i++) {
			if (w_max < wCount[i]) {
				w_max = wCount[i];
				w_max_index = i;
			}
		}
		// System.out.println("�ł�����������@" + w_max_index);
		// System.out.println("���̗�̔��̐��@" + w_max);

		// ���ʏo��
		System.out.println(h_max + w_max);
	}
}
