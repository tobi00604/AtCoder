package abc150.C;

import java.util.*;

// ‡—ñ‘S’Tõ‚Ì—ûK
public class Main {

	public static int n;
	public static ArrayList<String> tour;

	public static void main(String[] args) {

		// “ü—Íi“ss‚Ì”j
		Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(sc.next());

		// “ü—Íi‚±‚Ì–â‘è“Á—L‚Ì“ü—Íj
		String p = "";
		String q = "";
		for (int i = 0; i < n; i++) {
			p += (Integer.parseInt(sc.next()) - 1) + "";
		}
		for (int i = 0; i < n; i++) {
			q += (Integer.parseInt(sc.next()) - 1) + "";
		}

		// ‡—ñ—ñ‹“i“ss0`“ssn-1‚ğ„‚éj
		tour = new ArrayList<String>();
		for (int start = 0; start < n; start++) {
			saiki(start + "");
		}

		// Šm”F—p
		// for (String walk : tour) {
		// System.out.println(walk);
		// }

		// –â‘è‚ğ‰ğ‚­
		String[] a = new String[tour.size()];
		int index = 0;
		for (String walk : tour) {
			a[index] = walk;
			index++;
		}
		Arrays.sort(a);
		int result = 0;
		for (int i = 0; i < tour.size(); i++) {
			if (a[i].equals(p)) {
				result += i + 1;
			}
			if (a[i].equals(q)) {
				result -= i + 1;
			}
		}
		System.out.println(Math.abs(result));

	}

	// ‡—ñ—ñ‹“—p‚ÌÄ‹AŠÖ”
	public static void saiki(String walk) {

		// “¹‡‚ğƒŠƒXƒg‚É“ü‚ê‚ÄÄ‹A‘Å‚¿Ø‚è
		if (walk.length() == n) {
			tour.add(walk);
			return;
		}

		// Ÿ‚Ì“ssi‚Ü‚¾’Ê‚Á‚Ä‚È‚¢“ssj‚Ö
		for (int i = 0; i < n; i++) {
			if (!walk.contains(i + "")) {
				saiki(walk + i);
			}
		}
	}
}