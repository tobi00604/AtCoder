package abc175.C;

import java.math.BigInteger;
import java.util.*;

// �I����̊��z
// now �� dist * k �̑傫����r�ŋ�킵�����ǁA���PDF��������
// now / dist �� k �̑傫����r���Ă�c�B���̂��ƂɂȂ��C�Â��Ȃ������̂��c�B
public class Main {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		long now = Long.parseLong(sc.next());
		long k = Long.parseLong(sc.next());
		long dist = Long.parseLong(sc.next());

		// ���ݒn�����Ȃ�A���ɂ��čl���Ă���������
		if (now < 0) {
			now = -1 * now;
		}

		// �Ȃ�ׂ�0�ɋ߂Â��̂��ړI�Ȃ̂ŁA0��ʂ�߂�����܂�Ԃ��Ȃ���΂Ȃ�Ȃ��B
		// �����ł܂��́u0��ʂ�߂���v���������邩�ǂ����𔻒肷��B
		// �������Ak�i�ړ��񐔁j��dist�i�P��̈ړ������j���傫�����邽�߁A
		// k * dist �̌v�Z��BigInteger���g���B�iBigInteger�͍������߂Ēm�����j
		BigInteger bigK = BigInteger.ONE.multiply(BigInteger.valueOf(k));
		BigInteger bigSeki = bigK.multiply(BigInteger.valueOf(dist));
		BigInteger bigNow = BigInteger.ONE.multiply(BigInteger.valueOf(now));
		BigInteger bigHoge = bigNow.subtract(bigSeki);
		int hikaku = bigHoge.compareTo(BigInteger.ZERO);

		// �ړ��񐔂��g���؂��Ă�0�܂œ��B���Ȃ��p�^�[��
		if (hikaku == 1) {
			System.out.println(now - (k * dist));
			return;
		}

		// �ړ����g���؂����Ƃ��ɂ҂�����0�ɃS�[������p�^�[��
		if (hikaku == 0) {
			System.out.println(0);
			return;
		}

		// �ȉ��A0��ʂ�߂���p�^�[��

		// �܂�0�̒��O�܂ŕ���
		k -= now / dist;
		now = now % dist;

		// �c��񐔂������Ȃ�A���ݒn���S�[��
		if (k % 2 == 0) {
			System.out.println(now);
			return;
		}

		// �c��񐔂���Ȃ�A0����x�����ʂ�߂��Ē������Ƃ��낪�S�[��
		System.out.println(dist - now);

	}
}
