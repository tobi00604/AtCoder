package abc176.E;

import java.util.*;

// �u�ł����j�Ώۂ������s��T���Ă��ׂĔR�₵�A���ɍł����j�Ώۂ��������T���Ă��ׂĔR�₷�v
// �Ƃ������W�b�N����������A�e�X�g�P�[�X130�̂���5��WA�A�R���e�X�g���ԓ���AC�ł��Ȃ������B
// �u�ł����������s�܂��͗�v�������q�b�g�����Ƃ��ǂ����邩���l�����Ă��Ȃ������̂ŁA�Ē���B
public class Main2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int h = Integer.parseInt(sc.next());
		int w = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		Box[] box = new Box[m];
		for (int i = 0; i < m; i++) {
			int h_ = Integer.parseInt(sc.next());
			int w_ = Integer.parseInt(sc.next());
			box[i] = new Box(h_, w_);
		}

		// �e�s�i�܂��͗�j�ɔ��j�Ώۂ͂������邩
		int[] hCount = new int[h + 1];
		int[] wCount = new int[w + 1];
		for (int i = 0; i < m; i++) {
			hCount[box[i].h]++;
			wCount[box[i].w]++;
		}

		// �ł���������s�i�܂��͗�j�ԍ��ƁA���j�Ώی����܂Ƃ߂�Map��
		HashSet<Integer> hKouho = new HashSet<>();
		int hMax = -1;
		for (int i = 1; i < h + 1; i++) {
			hMax = Math.max(hMax, hCount[i]);
		}
		for (int i = 1; i < h + 1; i++) {
			if (hMax == hCount[i]) {
				hKouho.add(i);
			}
		}
		HashSet<Integer> wKouho = new HashSet<>();
		int wMax = -1;
		for (int i = 1; i < w + 1; i++) {
			wMax = Math.max(wMax, wCount[i]);
		}
		for (int i = 1; i < w + 1; i++) {
			if (wMax == wCount[i]) {
				wKouho.add(i);
			}
		}

		// ���e��u�������}�X�� hKouho.size() * wKouho.size() ��������
		// ��30����30���̊|���Z��int�͈̔͂𒴂���̂Ō^�ϊ����K�v
		long hKouhoNum = Long.parseLong(hKouho.size() + "");
		long wKouhoNum = Long.parseLong(wKouho.size() + "");
		long wannaPlace = hKouhoNum * wKouhoNum;

		// ���j�Ώۂ��Ȃ��}�X�ɔ��e��u�����Ƃ��ł���ƁA�������P������
		for (int i = 0; i < m; i++) {
			if (hKouho.contains(box[i].h) && wKouho.contains(box[i].w)) {
				wannaPlace--;
			}
		}
		if (0 < wannaPlace) {
			System.out.println(hMax + wMax);
		} else {
			System.out.println(hMax + wMax - 1);
		}
	}

	// m�̔��j�Ώ�
	static class Box {
		int h;
		int w;

		Box(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}
}
