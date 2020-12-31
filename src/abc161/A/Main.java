package abc161.A;

import java.util.*;

// A - ABC Swap
// —ûK‚Æ‚µ‚Ä‚â‚Á‚Ä‚İ‚éB2020/4/12
public class Main {

	public static void main(String[] args) {

		// ƒXƒy[ƒX‹æØ‚è‚Ì®”‚R‚Â
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// ” ‚`‚Æ” ‚a‚ğ“ü‚ê‘Ö‚¦‚é
		int tmp;
		tmp = a;
		a = b;
		b = tmp;

		// ” ‚`‚Æ” ‚b‚ğ“ü‚ê‘Ö‚¦‚é
		tmp = a;
		a = c;
		c = tmp;

		System.out.println(a + " " + b + " " + c);

	}

}
