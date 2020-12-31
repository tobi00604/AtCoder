package abc171.E;

import java.util.*;

//さきほどのソースコードを提出したあと、やっていることはつまり
//「すべての入力のXORを求めて、各入力とのXORを取っている」
//だと気づいた。つまり2進数変換とか一切不要。さっそく実装してみる。
public class Main2 {

	public static void main(String[] args) {

		// 入力
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long a[];
		a = new long[n];
		long XorOfAll = 0;

		// 入力を受けつつ、すべての入力どうしのXORも計算
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
			XorOfAll = XorOfAll ^ a[i];
		}

		// 各入力と XorOfAll とのXORがそのまま答え
		StringBuilder result = new StringBuilder(" ");
		for (int i = 0; i < n; i++) {
			long hoge = XorOfAll ^ a[i];
			result.append(" ").append(hoge);
		}

		System.out.println(result.toString().replace("  ", ""));
	}
}

