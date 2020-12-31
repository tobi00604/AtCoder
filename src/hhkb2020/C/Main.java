package hhkb2020.C;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.next());

		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = Integer.valueOf(sc.next());
		}

		int player = 0;
		int[] kinsi = new int[200001];
		for (int i = 0; i < n; i++) {

			// 禁止番号がひとつ増える
			kinsi[p[i]]++;

			// 禁止されていないマスへプレイヤー移動
			while (true) {
				if (kinsi[player] != 0) {
					player++;
				} else {
					break;
				}
			}

			// 出力
			System.out.println(player);
		}

	}
}
