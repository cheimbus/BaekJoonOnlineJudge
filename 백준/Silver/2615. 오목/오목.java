import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[][] grid = new int[19][19];
    public static int[][][] visited = new int[19][19][4];
    public static int[] dx = new int[]{1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < 19 && y < 19;
    }

    public static int calc(int x, int y, int dir, int val) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(inRange(nx, ny) && grid[nx][ny] == val) {
            return visited[nx][ny][dir] = calc(nx, ny, dir, val) + 1;
        }

        return 1;
    }

    public static String impl() {
        for(int j = 0; j < 19; j ++) {
            for(int i = 0; i < 19; i ++) {
                if(grid[i][j] != 0) {
                    for(int d = 0; d < 4; d ++) {
                        if(visited[i][j][d] == 0 && calc(i, j, d, grid[i][j]) == 5) {
                            sb.append(grid[i][j] + "\n").append(i + 1 +" ").append(j + 1);
                            return sb.toString();
                        }
                    }
                }
            }
        }
        return "0";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 19; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        bw.write(impl());
        bw.flush();
    }
}