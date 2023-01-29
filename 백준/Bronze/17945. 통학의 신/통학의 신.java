
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		int r1 = -A + (int) Math.sqrt(A * A - B);
		int r2 = -A - (int) Math.sqrt(A * A - B);

		if (r1 == r2)
			System.out.println(r1);
		else
			System.out.println(r2 + " " + r1);

	} // end of main
}
