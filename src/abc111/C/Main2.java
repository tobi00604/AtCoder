package abc111.C;

import java.util.*;

// /\/\/\/
// �������̒�o��WA�ɂȂ����B�ꍇ���������G�����Ă����̂�
// ���ۂɐ��������Ă݂ăR�X�g��������@�ɂ��Ă݂��B
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sc.next());
		}

		// ���i�̃��[�_�[�ƃT�u���[�_�[
		int[] count;
		count = new int[100001];
		for (int i = 0; i < n; i += 2) {
			count[a[i]]++;
		}
		int no1 = 0;
		int no1count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no1count < count[i]) {
				no1count = count[i];
				no1 = i;
			}
		}
		int no2 = 0;
		int no2count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no2count < count[i] && i != no1) {
				no2count = count[i];
				no2 = i;
			}
		}

		// ��i�̃��[�_�[�ƃT�u���[�_�[
		count = new int[100001];
		for (int i = 1; i < n; i += 2) {
			count[a[i]]++;
		}
		int no3 = 0;
		int no3count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no3count < count[i]) {
				no3count = count[i];
				no3 = i;
			}
		}
		int no4 = 0;
		int no4count = 0;
		for (int i = 1; i <= 100000; i++) {
			if (no4count < count[i] && i != no3) {
				no4count = count[i];
				no4 = i;
			}
		}

//		System.out.println(no1 + "��" + no1count + "��");
//		System.out.println(no2 + "��" + no2count + "��");
//		System.out.println(no3 + "��" + no3count + "��");
//		System.out.println(no4 + "��" + no4count + "��");

		// ���낢�����Ă݂čł�������ł����̂ł�
		int minCost = Integer.MAX_VALUE;
		minCost = Math.min(f(a, no1, no3), minCost);
		minCost = Math.min(f(a, no2, no3), minCost);
		minCost = Math.min(f(a, no1, no4), minCost);
		minCost = Math.min(f(a, no2, no4), minCost);
		minCost = Math.min(f(a, no1, 0), minCost);
		minCost = Math.min(f(a, no2, 0), minCost);
		minCost = Math.min(f(a, 0, no3), minCost);
		minCost = Math.min(f(a, 0, no4), minCost);
		System.out.println(minCost);

	}

	// ����Ă݂�
	static int f(int[] a, int x, int y) {

		if (x == y) {
			return Integer.MAX_VALUE;
		}

		int cost = 0;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				cost += (a[i] != x) ? 1 : 0;
			} else {
				cost += (a[i] != y) ? 1 : 0;
			}
		}
		return cost;

	}
}
