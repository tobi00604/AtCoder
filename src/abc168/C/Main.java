package abc168.C;

import java.util.*;

// Twitter�Łu�]���藝�v���g�����h���肵�Ęb��ɂȂ������B
// �A�i���O���v�Œ��j�̐�[�ƒZ�j�̐�[�̋��������߂�B
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int h = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		// m���̕��j�̊p�x
		double ma = 6.0D * m;

		// h���̎��j�̊p�x
		double ha = 30.0D * h;
		ha += 0.5 * m;

		// �j�Ɛj�̂Ȃ��p
		double angle = Math.abs(ma - ha);
		angle = Math.min(angle, 360.0D - angle);

		// �]���藝
		double result = a * a + b * b;
		result -= 2 * a * b * Math.cos(angle * Math.PI / 180);
		System.out.println(Math.sqrt(result));
	}

}