import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static List<Integer> lastTimes = new ArrayList<>();
    static int low;
    static int col;
    static int[][] arr;
    static int maxPoint = 0;
    static int tempPoint = 0;

    //StringTokenizer
    //br.readLine()
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        low = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        arr = new int[low][col];

        int flow = low;
        int fflow = 0;
        int ffcol = 0;
        while(flow--> 0){
            ffcol = 0;
            StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
            while(st1.hasMoreTokens())
                arr[fflow][ffcol++] = Integer.parseInt(st1.nextToken());
            fflow++;
        }


        for(int i = 0; i<low; i++){
            for(int j = 0; j<col; j++){
                func(i, j); // start point
            }
        }

        System.out.println(maxPoint);

    }

    public static void func(int lowN, int colN){ // lowN < low // colN < col
        shape1(lowN, colN);
        shape2(lowN, colN);
        shape3(lowN, colN);
        shape4(lowN, colN);
        shape5(lowN, colN);

    }

    public static void shape1(int lowN, int colN){
        NodeShape n1 = new NodeShape(lowN, colN, arr, low, col);
        n1.right();
        n1.right();
        n1.right();
        if(n1.check){
            max(n1.point);
        }

        NodeShape n2 = new NodeShape(lowN, colN, arr, low, col);
        n2.down();
        n2.down();
        n2.down();
        if(n2.check){
            max(n2.point);
        }
    }

    public static void shape2(int lowN, int colN){
        NodeShape n1 = new NodeShape(lowN, colN, arr, low, col);
        n1.right();
        n1.down();
        n1.left();
        if(n1.check){
            max(n1.point);
        }
    }

    public static void shape3(int lowN, int colN){
        NodeShape n1 = new NodeShape(lowN, colN, arr, low, col);
        n1.up();
        n1.up();
        n1.left();
        if(n1.check){
            max(n1.point);
        }

        NodeShape n2 = new NodeShape(lowN, colN, arr, low, col);
        n2.up();
        n2.up();
        n2.right();
        if(n2.check){
            max(n2.point);
        }

        NodeShape n3= new NodeShape(lowN, colN, arr, low, col);
        n3.down();
        n3.down();
        n3.right();
        if(n3.check){
            max(n3.point);
        }

        NodeShape n4 = new NodeShape(lowN, colN, arr, low, col);
        n4.down();
        n4.down();
        n4.left();
        if(n4.check){
            max(n4.point);
        }

        NodeShape n5 = new NodeShape(lowN, colN, arr, low, col);
        n5.left();
        n5.left();
        n5.up();
        if(n5.check){
            max(n5.point);
        }

        NodeShape n6 = new NodeShape(lowN, colN, arr, low, col);
        n6.left();
        n6.left();
        n6.down();
        if(n6.check){
            max(n6.point);
        }

        NodeShape n7 = new NodeShape(lowN, colN, arr, low, col);
        n7.right();
        n7.right();
        n7.up();
        if(n7.check){
            max(n7.point);
        }

        NodeShape n8 = new NodeShape(lowN, colN, arr, low, col);
        n8.right();
        n8.right();
        n8.down();
        if(n8.check){
            max(n8.point);
        }
    }

    public static void shape4(int lowN, int colN){
        NodeShape n1 = new NodeShape(lowN, colN, arr, low, col);
        n1.down();
        n1.left();
        n1.down();
        if(n1.check){
            max(n1.point);
        }

        NodeShape n2 = new NodeShape(lowN, colN, arr, low, col);
        n2.down();
        n2.right();
        n2.down();
        if(n2.check){
            max(n2.point);
        }

        NodeShape n3= new NodeShape(lowN, colN, arr, low, col);
        n3.left();
        n3.up();
        n3.left();
        if(n3.check){
            max(n3.point);
        }

        NodeShape n4 = new NodeShape(lowN, colN, arr, low, col);
        n4.left();
        n4.down();
        n4.left();
        if(n4.check){
            max(n4.point);
        }
    }

    public static void shape5(int lowN, int colN){
        NodeShape n1 = new NodeShape(lowN, colN, arr, low, col);
        n1.down();
        n1.down();
        n1.moveUP();
        n1.left();
        if(n1.check){
            max(n1.point);
        }

        NodeShape n2 = new NodeShape(lowN, colN, arr, low, col);
        n2.down();
        n2.down();
        n2.moveUP();
        n2.right();
        if(n2.check){
            max(n2.point);
        }

        NodeShape n3= new NodeShape(lowN, colN, arr, low, col);
        n3.right();
        n3.right();
        n3.moveLeft();
        n3.up();
        if(n3.check){
            max(n3.point);
        }

        NodeShape n4 = new NodeShape(lowN, colN, arr, low, col);
        n4.right();
        n4.right();
        n4.moveLeft();
        n4.down();
        if(n4.check){
            max(n4.point);
        }

    }



    public static void max(int n){
        maxPoint = Math.max(maxPoint, n);
    }



}


class NodeShape{
    int point;
    boolean check;
    int low, col, arrLow, arrCol;
    int[][] arr;

    public NodeShape(int low, int col ,int[][] arr, int arrLow, int arrCol){
        point = arr[low][col];

        this.low = low;
        this.col = col;
        this.arr = arr;

        this.arrLow = arrLow;
        this.arrCol = arrCol;

        this.check = true;

    }

    public void checkFunc(boolean b){
        check = b;
    }

    public boolean rangeCheck(){
        if(this.low>=0 && low < arrLow && col >=0 && col < arrCol)
            return true;
        else
            return false;
    }

    public void up(){
        this.low -= 1;
        if(rangeCheck())
            point += arr[low][col];
        else
            checkFunc(false);
    }

    public void down(){
        this.low += 1;
        if(rangeCheck())
            point += arr[low][col];
        else
            checkFunc(false);
    }

    public void left(){
        this.col -= 1;
        if(rangeCheck())
            point += arr[low][col];
        else
            checkFunc(false);
    }
    public void right(){
        this.col += 1;
        if(rangeCheck())
            point += arr[low][this.col];
        else
            checkFunc(false);
    }

    public void moveUP(){
        this.low -= 1;
    }
    public void moveDown(){
        this.low += 1;
    }
    public void moveLeft(){
        this.col -= 1;
    }
    public void moveRight(){
        this.col += 1;
    }
}

