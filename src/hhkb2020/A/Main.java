package hhkb2020.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();

		if (a.equals("N")) {

			System.out.println(b);
		} else {
			if (b.equals("a")) {
				System.out.println("A");
			} else if (b.equals("b")) {
				System.out.println("B");
			} else {
				System.out.println("C");
			}
		}

	}
}
