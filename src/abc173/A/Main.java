package abc173.A;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		
		int b = 1000 - (a % 1000);
		
		if(b==1000)
		{
			System.out.println(0);
		}
		else
		{
			System.out.println(b);
		}
	}
}
