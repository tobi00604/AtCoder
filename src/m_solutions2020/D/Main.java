package m_solutions2020.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int p[];
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(sc.next());
		}

		// �������Ə�����
		int money = 1000;
		int kabu = 0;

		// 10�������Ă邯�ǔ���̂͂�����7���ɂ��Ď茳��3���c���Ă����Ƃ��A
		// 3000�~�����Ă邯�ǔ����̂͂�����500�~���ɂ��Ď茳��2500�~�c���Ă����Ƃ��A
		// �����������Ƃ͍l�����A�����Ƃ��͑S�w���A����Ƃ��͑S���p�Ƃ���B
		// ���̂�肩���ŕs������������l���������B

		for (int i = 0; i < n; i++) {

			int saiyasu = 9999;
			for (int j = i; j < n; j++) {

				//System.out.println("j " + j);

				if (p[j] < saiyasu) {
					saiyasu = p[j];
					//System.out.println("��" + saiyasu);
				}

				// �������O�����オ�����Ƃ�
				if (j != 0 && p[j - 1] < p[j]) {
					kabu = money / saiyasu;
					money -= kabu * saiyasu;
					money += kabu * p[j];
					//System.out.println("��� " + j + " " + kabu + " " + money);
					i = j;
					break;
				}
			}
		}
		System.out.println(money);

	}

}
