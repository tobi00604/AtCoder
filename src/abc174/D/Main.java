package abc174.D;

import java.util.*;

// �yABC174�I����̊��z�z
// C�́A10���l���Ă��A�C�f�A�������΂Ȃ��̂ŃX�L�b�v�B
// E�́A30���l�������ʁA�×~�@�i�ł������ۑ��𔼕��ɐ؂�j�œ������o���������Ƃ������_�ɂ͎��������A
// ���̃T�C�Y���傫�������×~�@���Ǝ��s���ԃI�[�o�[�������Ȃ̂ŁA���������X�L�b�v�B
// ��L��C��E���l���鎞�Ԃ����������I�c��50�������Ȃ������I��}����D�ɒ���A�c�莞�Ԃ��肬��Ő����B
// ����D���Ԃɍ����ĂȂ�������A�낤��A��B��2���ŏI���Ƃ��낾�����B���Ԕz���C��t���悤�B
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String str = sc.next();

		int result = 0;

		int l = 0;
		int r = n - 1;

		while (true) {

			// �ł����ɂ��� 'W' ��T��
			while (true) {
				if (str.length() == l) {
					break;
				}
				if (str.charAt(l) == 'W') {
					break;
				}
				l++;
			}

			// �ł��E�ɂ��� 'R' ��T��
			while (true) {
				if (r == -1) {
					break;
				}
				if (str.charAt(r) == 'R') {
					break;
				}
				r--;
			}

			//System.out.println("swap! " + " " + l + " " + r);

			// ����
			if (l > r) {
				break;
			}
			result++;
			l++;
			r--;
		}

		System.out.println(result);

	}
}
