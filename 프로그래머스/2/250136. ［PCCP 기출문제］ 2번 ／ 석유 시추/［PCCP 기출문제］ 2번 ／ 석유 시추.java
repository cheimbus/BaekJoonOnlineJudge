import java.util.*;
class Solution {
    public int n;
    public int m;
    public int[][] grid;
    public int[] ansArr;
    public boolean[][] visited;
    public int[] dx = new int[]{-1, 0, 1, 0};
    public int[] dy = new int[]{0, 1, 0, -1};
    
    public boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < m && grid[x][y] == 1 && !visited[x][y];
    }
    
    public void bfs(int x, int y) {
        visited[x][y] = true;
        HashSet<Integer> hs = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        hs.add(y);
        int val = 1;
        
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            
            for(int i = 0; i < 4; i ++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];
                if(inRange(nx, ny)) {
                    visited[nx][ny] = true;
                    val ++;
                    q.add(new int[]{nx, ny});
                    hs.add(ny);
                }
            }
        }
        
        for(int i : hs) {
            ansArr[i] += val;
        }
    }
    
    public int solution(int[][] land) {
        grid = land;
        n = land.length;
        m = land[0].length;
        ansArr = new int[m];
        visited = new boolean[n][m];
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[j][i] == 1 && !visited[j][i]) {
                    bfs(j, i);
                }
            }
        }
        
        int answer = 0;
        for(int i : ansArr) {
            answer = Math.max(answer, i);
        }
        
        return answer;
    }
}