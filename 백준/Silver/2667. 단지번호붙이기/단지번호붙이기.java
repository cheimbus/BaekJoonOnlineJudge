import java.util.*;
import java.io.*;

public class Main {
    public static int n, val;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static char[][] grid;
    public static boolean[][] visited;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n && !visited[x][y] && grid[x][y] == '1';
    }

    public static void dfs(int x, int y) {
        for(int i = 0; i < 4; i ++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int cnt = 0;
            if(inRange(nx, ny)) {
                visited[nx][ny] = true;
                val ++;
                dfs(nx, ny);
            }
        }
    }

    public static int find() {
        int cnt = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(visited[i][j]) cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i ++) {
            String s = br.readLine();
            for(int j = 0; j < n; j ++) {
                grid[i][j] = s.charAt(j);
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    cnt ++;
                    val ++;
                    dfs(i, j);
                    arr.add(val);
                    val = 0;
                }
            }
        }

        Collections.sort(arr);

        sb.append(cnt).append("\n");
        for(int i = 0; i < arr.size(); i ++) {
            sb.append(arr.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}