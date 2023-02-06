import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> numSet = new HashSet<>(); // 초기값 : 111~999
	
	// 중복 체크 함수
	static boolean duplicate(String s) {
		if (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2))
			return true;
        if (s.contains("0"))
			return true;
		return false;
	}

	// 1. 가능한 숫자를 찾아서 tmpSet에 추가
	// 2. numSet을 tmpSet과의 교집합만 남김.
	static void findPossibleNumber(String numStr, int strike, int ball) {
		Set<String> tmpSet = new HashSet<>();

		for (int i = 111; i < 1000; i++) { // 111 ~ 999까지 numStr과 비교
			String tmp = String.valueOf(i);
			if (!numSet.contains(tmp))
				continue;
			int sCount = 0; // tmp와 numStr 간의 strike 개수
			int bCount = 0; // tmp와 numStr 간의 ball 개수
			for (int j = 0; j < 3; j++) {
				if (tmp.charAt(j) == numStr.charAt(j)) // 위치가 같으면 sCount++
					sCount++;
				else if (numStr.contains(tmp.charAt(j) + "")) // 위치는 다르지만 포함하고 있다면 bCount++
					bCount++;
			}

			if (sCount == strike && bCount == ball) // 정보가 같다면 tmpSet에 추가
				tmpSet.add(tmp);
		}

		numSet.retainAll(tmpSet);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 111; i < 1000; i++) {
			String tmp = String.valueOf(i); 
					if (duplicate(tmp))
						continue;
			numSet.add(tmp); // 111~999를 numSet에 넣어줌
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String numStr = st.nextToken();
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			findPossibleNumber(numStr, strike, ball);
		}

		System.out.println(numSet.size());

	} // end of main
}
