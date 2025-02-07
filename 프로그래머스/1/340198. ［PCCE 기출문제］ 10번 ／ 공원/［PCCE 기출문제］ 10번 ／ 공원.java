import java.util.*;

class Solution {
    public String[][] pk;
    public int[] mat;
    public boolean[][] visited;
    
    public void init() {
        for (int i = 0; i < pk.length; i++) {
            for (int j = 0; j < pk[0].length; j++) {
                if (!pk[i][j].equals("-1")) visited[i][j] = true;
            }
        }
    }
    
    public boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < pk.length && y < pk[0].length && pk[x][y].equals("-1");
    }
    
    public int find(int x, int y) {
        int max = 0;
        init();
        
        for (int i = 0; i < mat.length; i++) {
            int val = mat[i];
            boolean valid = true;

            for (int j = 0; j < val; j++) {
                for (int k = 0; k < val; k++) {
                    int nx = x + j;
                    int ny = y + k;

                    if (!inRange(nx, ny)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
            }

            if (valid) {
                max = Math.max(max, val);
            }
        }

        return max;
    }
    
    public int solution(int[] mats, String[][] park) {
        mat = mats;
        pk = park;
        visited = new boolean[park.length][park[0].length];
        
        int val = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                val = Math.max(val, find(i, j));
            }
        }
        
        if(val == 0) return -1;
        return val;
    }
}
