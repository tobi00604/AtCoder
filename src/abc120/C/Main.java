package abc120.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();

		// �ԂƐ�����Ă��Ă������������A�ƍl���Ă����̂ł́H
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += s.charAt(i) - 48;
		}
		result = Math.min(n - result, result);
		System.out.println(result * 2);
	}
}
