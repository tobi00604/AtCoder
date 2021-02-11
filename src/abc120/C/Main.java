package abc120.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();

		// 赤と青が離れていてもいずれ消せる、と考えていいのでは？
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += s.charAt(i) - 48;
		}
		result = Math.min(n - result, result);
		System.out.println(result * 2);
	}
}
