package abc173.C;

import java.util.*;

// �y�I����̃����z
// �S�p�^�[���𑍓�����Œ��ׂ�Ή�����T�C�Y�̖�肾�Ɣ��f���Ď����������ʁA�ꔭ�����ł����B
// ���PDF��ǂ�ł݂�ƁA�S�p�^�[����������Ƃ������j���������������A
// �h��/�h��Ȃ� �� 0/1 �ɒu�������ē�i�����ۂ��l����Ƃ������z�������������悤���B
// �����A�����ɂP���Ԃ�������A�������_�Ŏc��15���A���̖����������Ԃ��Ȃ������B
// �P�D��i���̊e�� 0/1 ��boolean�l true/false �ƌ��Ȃ��Ĕz��ŊǗ����������ŁA�\�[�X�������Ȃ���
//     �i�V�t�g���Z�q�i���悭�������ĂȂ��j���g���Ƃ����ƃX�}�[�g�ɂł����̂�������Ȃ��j
// �Q�DAtCoder�ł悭��������A�Ֆʂ� "." �� "#" �ŕ\�����͂Ɋ���Ă��Ȃ�����
//     �i�����������񎟌��Ֆʖ���ABC����E����F���ł悭���������ۂ����A�܂���C���ɏo��Ƃ́j
// �����Q�_������̔s�����Ǝv���B���̐����҂̃\�[�X�R�[�h������Ȃǂ��ĕ׋����悤�Ǝv�����B
public class Main {

	public static int i_max;
	public static int j_max;
	public static int field[][];
	public static boolean nurui[];
	public static boolean nuruj[];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		i_max = Integer.parseInt(sc.next());
		j_max = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());

		field = new int[i_max][j_max];
		for (int i = 0; i < i_max; i++) {
			String s = sc.next();
			for (int j = 0; j < j_max; j++) {
				field[i][j] = (s.charAt(j) == '.') ? 0 : 1;
			}
		}

		nurui = new boolean[i_max];
		nuruj = new boolean[j_max];
		int answer = 0;

		for (int i = 0; i < (int) Math.pow(2, i_max); i++) {
			for (int j = 0; j < (int) Math.pow(2, j_max); j++) {

				// �h��p�^�[�������
				String bin_i = String.format("%0" + i_max + "d",
						Integer.valueOf(Integer.toBinaryString(i)));
				String bin_j = String.format("%0" + j_max + "d",
						Integer.valueOf(Integer.toBinaryString(j)));
				for (int p = 0; p < i_max; p++) {
					nurui[p] = (bin_i.charAt(p) == '0') ? false : true;
				}
				for (int p = 0; p < j_max; p++) {
					nuruj[p] = (bin_j.charAt(p) == '0') ? false : true;
				}

				// ���̃p�^�[���œh�����Ƃ��̍��}�X���́A�ڕW k �ƈ�v���邩�H
				if (countBlack() == k) {
					answer++;
//					System.out.println(Arrays.toString(nurui));
//					System.out.println(Arrays.toString(nuruj));
//					System.out.println("");
				}

			}
		}

		// �o��
		System.out.println(answer);
		
	}

	// ���݂�nurui, nuruj�œh�����Ƃ��̍��}�X��
	private static int countBlack() {

		int result = 0;

		for (int i = 0; i < i_max; i++) {
			for (int j = 0; j < j_max; j++) {
				if (!nurui[i] && !nuruj[j] && field[i][j] == 1) {
					result++;
				}
			}
		}
		return result;

	}
}
