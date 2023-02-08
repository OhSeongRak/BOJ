
import java.util.Scanner;

public class Solution {
	static boolean isSame(String str1, String str2) {
		if (str1.length() != str2.length()) // 길이가 다르면 무조건 false
			return false;

		// alphaGroup에서의 인덱스 == 구멍의 개수
		String[] alphaGroup = { "CEFGHIJKLMNSTUVWXYZ", "ADOPQR", "B" };

		for (int i = 0; i < str1.length(); i++) {
			int hole1 = 0; // str1의 i번째 문자의 구멍 개수
			int hole2 = 0; // str2의 i번째 문자의 구멍 개수

			for (int k = 0; k < alphaGroup.length; k++) {
				if (alphaGroup[k].contains(str1.charAt(i) + "")) // k번째 그룹에 있으면
					hole1 = k;
				if (alphaGroup[k].contains(str2.charAt(i) + ""))
					hole2 = k;
			}
			if (hole1 != hole2)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str1 = sc.next();
			String str2 = sc.next();

			if (isSame(str1, str2))
				System.out.printf("#%d SAME%n", test_case);
			else
				System.out.printf("#%d DIFF%n", test_case);
		}

	} // end of main
}
