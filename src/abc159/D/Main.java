package abc159.D;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int[] ball = new int[n]; // �e����
		for (int i = 0; i < n; i++) {
			ball[i] = Integer.parseInt(sc.next());
		}

		Map<Integer, Long> appearMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (appearMap.containsKey(ball[i])) {
				appearMap.replace(ball[i], appearMap.get(ball[i]) + 1L);
			} else {
				appearMap.put(ball[i], 1L);
			}
		}

		Map<Integer, Long> kumiMap = new HashMap<>();
		long totalKumi = 0;
		for (Map.Entry<Integer, Long> entry : appearMap.entrySet()) {
			long kumi = entry.getValue() * (entry.getValue() - 1) / 2;
			kumiMap.put(entry.getKey(), kumi);
			totalKumi += kumi;
		}

		for (int i = 0; i < n; i++) {

			// �{�[���ɏ�����Ă��鐔�l
			int b = ball[i];

			// ���̃{�[�����֎~������A���̐��l�͎c�艽���邩
			long kazu = appearMap.get(b) - 1;

			// ���̐��l�̑I�ѕ��͉��ʂ肠�邩
			long newKumi = kazu * (kazu - 1) / 2;

			// ���̐��l�̑I�ѕ��ƍ����ďo��
			System.out.println(totalKumi - kumiMap.get(b) + newKumi);
		}

	}
}
