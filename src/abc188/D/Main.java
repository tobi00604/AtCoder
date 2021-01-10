package abc188.D;

import java.util.*;

// �������@�B����C�ȏ�̎R�͍���č���C�ɂł���
public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		long mountain = Long.parseLong(sc.next());

		Stop[] sim = new Stop[n * 2];
		for (int i = 0; i < n; i++) {
			long a = Long.parseLong(sc.next());
			long b = Long.parseLong(sc.next());
			long c = Long.parseLong(sc.next());

			sim[i] = new Stop(a, c);
			sim[n + i] = new Stop(b + 1, -1 * c);
		}

		// ���t���Ƀ\�[�g
		Comparator<Stop> c = new Comparator<Stop>() {
			public int compare(Stop p, Stop q) {
				if (p.day == q.day) {
					return (q.zougen - p.zougen > 0) ? -1 : 1;
				}
				return (p.day - q.day > 0) ? 1 : -1;
			}
		};
		Arrays.sort(sim, c);

		// �m�F�p
//		for (Stop s : sim) {
//			System.out.println(s.day + " " + s.zougen);
//		}

		// ���z�v�Z
		long result = 0;
		long onedaycost = 0;
		for (int i = 0; i < n * 2 - 1; i++) {

			onedaycost += sim[i].zougen;
			long temp1 = sim[i + 1].day - sim[i].day;
			long temp2 = Math.min(onedaycost, mountain);
//			System.out.println(sim[i + 1].day + "�`" + sim[i].day + " " + temp2
//					+ "�~");
			result += temp1 * temp2;
		}

		System.out.println(result);

	}

	static class Stop {
		long day;
		long zougen;

		// �R���X�g���N�^
		public Stop(long day, long zougen) {
			super();
			this.day = day;
			this.zougen = zougen;
		}
	}
}
