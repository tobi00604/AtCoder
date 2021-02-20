package abc188.E;

import java.util.*;

// ���o�͗Ⴗ��AC�ɂȂ�Ȃ����A�����Ȃ�̓��B�_�Ƃ��Ē�o�B

// kane[v] := �_v�ŋ���𔄂����Ƃ��̒l�i
// from[v] := �_v�ɓ��B�\�ȋ���̂����A�ł���������̏o�g�n
// �����΁Akane[v]-kane[from[v]] �̍ő�l�������ɂȂ�̂ł́H
// �c�Ǝv���Ĉȉ������������A����𔃂������ł������邱�Ƃ��ł��Ă��܂�WA�ɂȂ�B

public class Main2 {

	static List<List<Integer>> graph; // �O���t
	static boolean[] asi;
	static int[] kane;
	static int[] from;

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next()); // �_�̐�
		int m = Integer.parseInt(sc.next()); // �ӂ̐�
		asi = new boolean[n];
		kane = new int[n];
		from = new int[n];
		for (int v = 0; v < n; v++) {
			asi[v] = false;
			kane[v] = Integer.parseInt(sc.next());
			from[v] = -1;
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
				dfs(v, v);
			}
		}

//		// kane�̊m�F�p
//		for (int v = 0; v < n; v++) {
//			System.out.println("�_" + (v + 1) + "[" + kane[v] + "]");
//			for (int e : graph.get(v)) {
//				System.out.println("�@�˓_" + (e + 1) + "[" + kane[e] + "]");
//			}
//		}
//		System.out.println();
//
//		// low�̊m�F�p
//		for (int v = 0; v < n; v++) {
//			System.out.println("�_" + (v + 1) + "�F" + (from[v] + 1));
//		}
//		System.out.println();

		// ����
		int result = 0;
		for (int v = 0; v < n; v++) {
			result = Math.max(result, kane[v] - kane[from[v]]);
		}
		System.out.println(result);
	}

	static void dfs(int v, int f) {
		asi[v] = true;
		from[v] = (kane[f] < kane[v]) ? f : v;
		for (int e : graph.get(v)) {
			if (!asi[e]) {
				dfs(e, from[v]);
			}
		}
	}

}