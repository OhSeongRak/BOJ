import java.io.*;
import java.math.BigInteger;
import java.util.*;
/*
iv에 먼저 전역으로 생성해두고 입력받은 후 iv에 입력하면 모든함수에서 사용가능.
main, func 에서도 쓰일 때, "함수의 인자로 넘겨주기 싫을 때"
 */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] arr2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(br.readLine()); // 정수로 입력받을 때
        //N = Integer.parseInt(st.nextToken());
        arr2 = new int[N][N];

        for(int i =0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<N; j++){
                arr2[i][j] = str.charAt(j) - '0';
            }
        }

        recur(N, 0, 0);
        System.out.println(sb);
    }

    public static void recur(int size, int low, int col){ // 뒤부터 보냄.
        int oneCount = 0;
        int zeroCount = 0;
        for(int i = low; i < low + size; i++){
            for(int j = col; j < col + size; j++){
                if(arr2[i][j] == 0){
                    zeroCount++;
                }else
                    oneCount++;
            }
        }

        if(zeroCount == size * size || oneCount == size * size){
            if(zeroCount == size * size) {
                sb.append("0");
                return;
            }else{
                sb.append("1");
                return;
            }
        }

        //검사하고.
        sb.append("(");


        size /=2;
        for(int low1 = low; low1 < low + size * 2; low1 += size){
            for(int col1 = col; col1 < col + size * 2; col1 += size){
                recur(size, low1, col1);

            }
        }

        sb.append(")");

    }
}
