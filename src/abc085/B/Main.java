package abc085.B;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		HashSet<Integer> h = new HashSet<>();
		for (int i = 0; i < n; i++) {
			h.add(Integer.parseInt(sc.next()));
		}

		// �o��
		System.out.println(h.size());
	}
}
