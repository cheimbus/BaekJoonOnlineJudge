import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int N = 9;
    public static int maxVal, x, y;
    public static int[][] grid = new int[N + 1][N + 1];

    public static void findMaxNumAndPos() {
        int val = -1;
        for(int i = 1; i <= N; i ++) {
            for(int j = 1; j <= N; j ++) {
                if(val < grid[i][j]) {
                    val = grid[i][j];
                    x = i; y = j;
                }
            }
        }
        maxVal = val;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 1; i <= N; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j ++) {
                int num = Integer.parseInt(stk.nextToken());
                grid[i][j] = num;
            }
        }

        findMaxNumAndPos();

        StringBuilder sb = new StringBuilder();
        sb.append(maxVal).append("\n").append(x + " " + y);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}