import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k;
    public static char[][] grid;
    public static char[][] tmp;
    public static int cnt;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < m;
    }

    public static void bomb() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                if(grid[i][j] == 'O') {
                    tmp[i][j] = '.';
                    for(int h = 0; h < 4; h ++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];
                        if(inRange(nx, ny)) {
                            tmp[nx][ny] = '.';
                        }
                    }
                }
            }
        }
    }

    public static void find() {
        for(int i = 1; i < k; i ++) {
            cnt ++;
            if(cnt == 1) {
                for(int j = 0; j < n; j ++) {
                    for(int h = 0; h < m; h ++) {
                        tmp[j][h] = 'O';
                    }
                }
            }
            else if(cnt == 2) {
                bomb();
                for(int j = 0; j < n; j ++) {
                    for(int h = 0; h < m; h ++) {
                        grid[j][h] = tmp[j][h];
                    }
                }
                cnt = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        grid = new char[n][m];
        tmp = new char[n][m];

        for(int i = 0; i < n; i ++) {
            String s = br.readLine();
            for(int j = 0; j < m; j ++) {
                grid[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                tmp[i][j] = grid[i][j];
            }
        }
        find();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j ++) {
                sb.append(tmp[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}