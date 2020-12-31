package abc171.C;

import java.util.*;

public class Main {

	// 感想
	// 1→a, 26→z, 27→aa, 123456789→jjddja, ...というふうに26進数に変換するだけの問題。
	// 自力でやろうとしたが結構難しくて、80分くらいかけても完成できなかった。
	// A問題とB問題を10分で終わらせてきたので、計90分、あと10分あるが、できる見込みがないので諦め。
	
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		map.put("d", "4");
		map.put("e", "5");
		map.put("f", "6");
		map.put("g", "7");
		map.put("h", "8");
		map.put("i", "9");
		map.put("j", "10");
		map.put("k", "11");
		map.put("l", "12");
		map.put("m", "13");
		map.put("n", "14");
		map.put("o", "15");
		map.put("p", "16");
		map.put("q", "17");
		map.put("r", "18");
		map.put("s", "19");
		map.put("t", "20");
		map.put("u", "21");
		map.put("v", "22");
		map.put("w", "23");
		map.put("x", "24");
		map.put("y", "25");
		map.put("z", "26");
		map.put("1", "a");
		map.put("2", "b");
		map.put("3", "c");
		map.put("4", "d");
		map.put("5", "e");
		map.put("6", "f");
		map.put("7", "g");
		map.put("8", "h");
		map.put("9", "i");
		map.put("10", "j");
		map.put("11", "k");
		map.put("12", "l");
		map.put("13", "m");
		map.put("14", "n");
		map.put("15", "o");
		map.put("16", "p");
		map.put("17", "q");
		map.put("18", "r");
		map.put("19", "s");
		map.put("20", "t");
		map.put("21", "u");
		map.put("22", "v");
		map.put("23", "w");
		map.put("24", "x");
		map.put("25", "y");
		map.put("26", "z");

		// 入力
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		// 1000000000000001/(26*26*26*26*26*26*26*26*26*26)

		String name = "";
		String c = "";

		System.out.println("1回目 " + x);
		c = map.get(String.valueOf(((x - 1) % 26) + 1));
		name = c + name;
		System.out.println(c);

		if (x <= 26) {
			System.out.println("終了 " + name);
			return;
		}

		System.out.println("2回目 " + x);
		c = map.get(String.valueOf((((x - 1) / 26) - 1) % 26) + 1);
		name = c + name;
		System.out.println(c);

		if (x <= 702) {
			System.out.println("終了 " + name);
			return;
		}

	}
}
