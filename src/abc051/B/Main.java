package abc051.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int s = Integer.parseInt(sc.next());

		// x, y, z�𑫂���s�����͉̂��ʂ肩�B������x, y, z�͂������k�ȉ�
		int result = 0;
		for (int x = 0; x <= k; x++) {
			for (int y = 0; y <= k; y++) {
				int z = s - x - y;

				if (0 <= z && x <= k && y <= k && z <= k && x + y + z == s) {
					//System.out.println(x + "_" + y + "_" + z);
					result++;
				}
			}
		}

		System.out.println(result);

	}
}
