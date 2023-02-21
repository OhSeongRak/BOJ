import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
iv에 먼저 전역으로 생성해두고 입력받은 후 iv에 입력하면 모든함수에서 사용가능.
main, func 에서도 쓰일 때, 함수의 인자로 넘겨주기 싫을 때
 */

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, low1, col1;
    static int lastlow, lastcol;
    //static int[][] matrix;
    static int findnumber;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        //int input = Integer.parseInt(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 2 ^ N
        low1 = Integer.parseInt(st.nextToken()); // low
        col1 = Integer.parseInt(st.nextToken()); // col
        lastcol = col1;
        lastlow = low1;

        int size = (int)Math.pow(2, N);
        //matrix = new int[size][size];

        recur(size,0 , 0, 0); // 4,4,4

//        for(int i = 0; i<size; i++){
//            for(int j = 0; j<size; j++){
//                System.out.print(matrix[i][j] + " ");
//
//            }
//            System.out.println();
//        }
        System.out.println(findnumber);

    }

    public static void recur(int N, int low, int col, int number){
        if(N == 1){
            //matrix[low][col] = number;
            if(low == low1 && col == col1)
                findnumber = number;
            return;
        }
        // 재귀횟수를 줄여야함. 딱 찾아가도록
        // N을 반씩 줄이면서 이분탐색을함.
        // 현재 low <=> low + N 사이에 있는지.

        // 재귀가 되면 low, col 이 달라짐.
        // 재귀 보내기전에 해야함.
        int lowth = low;
        int colth = col;

        // i부터 검사. 다음 i 까지 그 사이에 low1이 있는지.
        for(int i = low ; i < low + N; i += N/2){
            lowth += N/2;
            colth += N/2;
            for(int j = col ; j < col + N; j += N/2) {
                if(low1 >= i && low1 <= lowth && j <= col1 && col1 <= colth) {
                    recur(N / 2, i, j, number);
                }
                colth += N/2;
                number += N/2 * N/2;
            }
            colth = col;
        }
    }
}
