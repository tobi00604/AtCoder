package abc186.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		int result = 0;
		for (int index = 1; index <= n; index++) {
			
			int i = index;
			
			// nに7が含まれているならスキップ
			if( (i + "_").contains("7") ){
//				System.out.println(i + "には7がいる");
				continue;
			}
			
			// nを8進数で表したものに7が含まれているならスキップ
			int sho = 0;

			sho = i/32768;
			i = i%32768;
			if( sho == 7 ){
				continue;
			}

			sho = i/4096;
			i = i%4096;
			if( sho == 7 ){
				continue;
			}

			sho = i/512;
			i = i%512;
			if( sho == 7 ){
				continue;
			}

			sho = i/64;
			i = i%64;
			if( sho == 7 ){
				continue;
			}

			sho = i/8;
			i = i%8;
			if( sho == 7 ){
				continue;
			}

			sho = i/1;
			i = i%1;
			if( sho == 7 ){
				continue;
			}
			
			result++;
		}

		System.out.println(result);
	}
}
