package abc168.C;

import java.util.*;

// Twitterで「余弦定理」がトレンド入りして話題になった問題。
// アナログ時計で長針の先端と短針の先端の距離を求める。
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int h = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		// m分の分針の角度
		double ma = 6.0D * m;

		// h時の時針の角度
		double ha = 30.0D * h;
		ha += 0.5 * m;

		// 針と針のなす角
		double angle = Math.abs(ma - ha);
		angle = Math.min(angle, 360.0D - angle);

		// 余弦定理
		double result = a * a + b * b;
		result -= 2 * a * b * Math.cos(angle * Math.PI / 180);
		System.out.println(Math.sqrt(result));
	}

}