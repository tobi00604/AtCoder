package abc162.A;

import java.util.*;

public class Main {
 
	public static void main(String[] args) {
 
		// 3Œ…‚Ì®”
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
 
		if (x % 10 == 7) {
			System.out.println("Yes");
			return;
		}
 
		x = x / 10;
 
		if (x % 10 == 7) {
			System.out.println("Yes");
			return;
		}
 
		x = x / 10;
 
		if (x == 7) {
			System.out.println("Yes");
			return;
		}
 
		System.out.println("No");
 
	}
 
}