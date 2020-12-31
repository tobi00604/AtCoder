package abc169.C;

import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long a = Long.parseLong(sc.next());
		long b = Long.parseLong(sc.next().replace(".", ""));

		BigInteger bigA = BigInteger.valueOf(a);
		BigInteger bigC = bigA.multiply(BigInteger.valueOf(b));
		BigInteger bigD = bigC.divide(BigInteger.valueOf(100));
		
		System.out.println(bigD.longValue());

	}

}