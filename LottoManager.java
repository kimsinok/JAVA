import java.util.Arrays;
import java.util.Scanner;


class Lotto {
        // 로또 번호
	private int[] lottonums = new int[6];
	// 사용자가 입력한 로또 번호
	private int[] userLotto = new int[6];

	public Lotto() {

	}

	public int[] getLottonums() {
		return lottonums;
	}

        // 로또 번호를 생성하다.
	public void createLottoNumbers() {
		for (int i = 0; i < lottonums.length; i++) {
			lottonums[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottonums[i] == lottonums[j]) {
					i--;
					break;
				}
			}
		}
	}

	// 로또 번호를 선택 정렬을 이용하여 오름차순 정렬하다.
	public void sortLottoNumbers() {
		for (int i = 0; i < lottonums.length - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < lottonums.length; j++) {
				if (lottonums[min_idx] > lottonums[j]) {
					min_idx = j;
				}
			}
			if (i != min_idx) {
				int temp = lottonums[min_idx];
				lottonums[min_idx] = lottonums[i];
				lottonums[i] = temp;
			}
		}
		System.out.printf("로또번호 : %s%n%n", Arrays.toString(lottonums));
	}



	public void userInput() {
		Scanner scan = new Scanner(System.in);
		boolean isExit = false;

		outer: do {
			System.out.print("6개의 로또번호를 입력하세요 [1 ~ 45] ");

			for (int i = 0; i < userLotto.length; i++) {
				userLotto[i] = scan.nextInt();
			}

			for (int i = 0; i < userLotto.length; i++) {
				if (userLotto[i] <= 0 || userLotto[i] > 45) {
					System.out.println("1 ~ 45 사이의 숫자를 입력하세요\n");
					continue outer;
				}
			}

			for (int i = 0; i < userLotto.length; i++) {
				for (int j = 0; j < i; j++) {
					if (userLotto[i] == userLotto[j]) {
						System.out.println("로또번호가 중복됩니다. 다시 입력해주세요.\n");
						continue outer;
					}
				}
			}

			isExit = true;

		} while (!isExit);

	}



	public void print() {
		int count = 0;
		for (int i = 0; i < lottonums.length; i++) {
			for (int j = 0; j < lottonums.length; j++) {
				if (lottonums[i] == userLotto[j]) {
					count++;
				}
			}
		}
		switch (count) {
		case 6:
			System.out.println("축하!! 1등 당첨입니다.");
			break;
		case 5:
			System.out.println("2등 당첨입니다.");
			break;
		case 4:
			System.out.println("3등 당첨입니다.");
			break;
		default:
			System.out.println("다음 기회에 ~~");

		}
	}
}



public class LottoManager {

	public static void main(String[] args) {

		Lotto lotto = new Lotto();
		
		lotto.createLottoNumbers();		
		
		lotto.sortLottoNumbers();
		
		lotto.userInput();
		
		lotto.print();

	}

}
