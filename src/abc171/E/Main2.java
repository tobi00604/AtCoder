package abc171.E;

import java.util.*;

//�����قǂ̃\�[�X�R�[�h���o�������ƁA����Ă��邱�Ƃ͂܂�
//�u���ׂĂ̓��͂�XOR�����߂āA�e���͂Ƃ�XOR������Ă���v
//���ƋC�Â����B�܂�2�i���ϊ��Ƃ���ؕs�v�B���������������Ă݂�B
public class Main2 {

	public static void main(String[] args) {

		// ����
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long a[];
		a = new long[n];
		long XorOfAll = 0;

		// ���͂��󂯂A���ׂĂ̓��͂ǂ�����XOR���v�Z
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sc.next());
			XorOfAll = XorOfAll ^ a[i];
		}

		// �e���͂� XorOfAll �Ƃ�XOR�����̂܂ܓ���
		StringBuilder result = new StringBuilder(" ");
		for (int i = 0; i < n; i++) {
			long hoge = XorOfAll ^ a[i];
			result.append(" ").append(hoge);
		}

		System.out.println(result.toString().replace("  ", ""));
	}
}

