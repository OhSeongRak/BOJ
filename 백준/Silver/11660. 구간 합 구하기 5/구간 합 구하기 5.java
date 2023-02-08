import java.io.*;
import java.util.*;
import java.util.function.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int numberCount = Integer.parseInt(st.nextToken());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int[][] arr = new int[arrSize][arrSize];
        int[][] arrSum = new int[arrSize+1][arrSize+1];

        int lines = Integer.parseInt(st.nextToken());

        int low = 0;
        while(arrSize-- > 0){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int col = 0;
            while(st.hasMoreTokens())
                arr[low][col++] = Integer.parseInt(st.nextToken());
            low++;
        }

        arrSum[1][1] = arr[0][0];

        // arrSum 컨트롤
        for(int i = 2 ; i<arr.length+1; i++)
            arrSum[1][i] = arr[0][i-1] + arrSum[1][i-1];

        for(int i = 2 ; i<arr.length+1; i++)
            arrSum[i][1] = arr[i-1][0] + arrSum[i-1][1];

        for(int i = 2 ; i<arr.length+1; i++) { // low
            for(int j = 1+1; j<arr.length+1; j++){
                arrSum[i][j] = arr[i-1][j-1] + arrSum[i][j-1] + arrSum[i-1][j] - arrSum[i-1][j-1];
            }
        }

        // 질의
        while(lines --> 0){
            st = new StringTokenizer(br.readLine());
            int sLow = Integer.parseInt(st.nextToken());
            int sCol = Integer.parseInt(st.nextToken());
            int eLow = Integer.parseInt(st.nextToken());
            int eCol = Integer.parseInt(st.nextToken());

            int answer = arrSum[eLow][eCol] - arrSum[eLow][sCol-1] - arrSum[sLow-1][eCol] + arrSum[sLow-1][sCol-1];
            sb.append(answer).append("\n");

        }

        System.out.println(sb);



    }
}


