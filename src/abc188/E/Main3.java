package abc188.E;

import java.util.*;

// �������̒�o��������Ɖ����B
// mouke[v] := �_v�ŋ���𔄂����Ƃ��ɓ�����ׂ��̍ő�l
// ����邱�Ƃɂ����B���PDF�̉�@�P�Ɣ��z�͓��������v�Z�����Ⴄ�BAC�Ȃ邩�H
public class Main3 {

	static List<List<Integer>> graph; // �O���t
	static boolean[] asi;
	static int[] kane;
	static int[] mouke;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		asi = new boolean[n];
		kane = new int[n];
		mouke = new int[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
			kane[v] = Integer.parseInt(sc.next());
			mouke[v] = Integer.MIN_VALUE;
		}
		graph = new ArrayList<List<Integer>>();
		for (int v = 0; v < n; v++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int e = 0; e < m; e++) {
			int a = Integer.parseInt(sc.next()) - 1; // �n�_
			int b = Integer.parseInt(sc.next()) - 1; // �I�_
			graph.get(a).add(b);
		}

		// DFS
		for (int v = 0; v < n; v++) {
			if (!asi[v]) {
				dfs(v, Integer.MAX_VALUE);
			}
		}

		// kane�̊m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + (v + 1) + "[" + kane[v] + "]");
			for (int e : graph.get(v)) {
				System.out.println("�@�˓_" + (e + 1) + "[" + kane[e] + "]");
			}
		}
		System.out.println();

		// low�̊m�F�p
		for (int v = 0; v < n; v++) {
			System.out.println("�_" + (v + 1) + "�F" + mouke[v]);
		}
		System.out.println();

		// ����
		int result = Integer.MIN_VALUE;
		for (int v = 0; v < n; v++) {
			result = Math.max(result, mouke[v]);
		}
		System.out.println(result);
	}

	static void dfs(int v, int f) {
		asi[v] = true;
		mouke[v] = kane[v] - f;
		for (int e : graph.get(v)) {
			if (!asi[e]) {
				dfs(e, Math.min(kane[v], f));
			}
		}
	}

}