import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int k;
    public static StringBuilder sb = new StringBuilder();

    public static void impl(int n, int m) throws IOException {
        int[][] grid = new int[n][n];
        int[][] tmp = new int[n][n];

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                tmp[i][j] = grid[i][j];
            }
        }

        int nm = m % 360;

        if(nm > 0) {
            while(nm != 0) {
                nm -= 45;

                for(int i = 0; i < n; i ++) {
                    tmp[i][n / 2] = grid[i][i];
                    tmp[i][n - 1 - i] = grid[i][n / 2];
                    tmp[n / 2][n - 1 - i] = grid[i][n - 1 - i];
                    tmp[i][i] = grid[n / 2][i];
                }

                for(int i = 0; i < n; i ++)
                    for(int j = 0; j < n; j ++)
                        grid[i][j] = tmp[i][j];
            }
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        else if(nm < 0) {
            while(nm != 0) {
                nm += 45;

                for(int i = 0; i < n; i ++) {
                    tmp[i][n / 2] = grid[i][n - 1 - i];
                    tmp[i][i] = grid[i][n / 2];
                    tmp[n / 2][i] = grid[i][i];
                    tmp[n - 1 - i][i] = grid[n / 2][i];
                }

                for(int i = 0; i < n; i ++)
                    for(int j = 0; j < n; j ++)
                        grid[i][j] = tmp[i][j];
            }
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        else {
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());

        while(k -- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            impl(n, m);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}