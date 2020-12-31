package sumitrust2019.D;

import java.util.*;

// ��������o�����̂�TLE�ɂȂ����̂ŁA
// �������K��1000�����ɂȂ邱�Ƃ𗘗p���Ĕz��Ō��ʊǗ�����悤�C��
// �ł����ǂn(n^3)���������ς�_�������H
public class Main3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String s = sc.next();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.valueOf(s.substring(i, i + 1));
		}

		int[] dic = new int[1000];
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					dic[a[i] * 100 + a[j] * 10 + a[k]] = 1;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum += dic[i];
		}
		System.out.println(sum);

	}
}
