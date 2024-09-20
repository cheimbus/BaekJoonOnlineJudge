import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        
        char[][] grid = new char[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                grid[i][j] = c;
            }
        }
        int rowVal = 0;

        for(int i = 0; i < n; i++) {
            int rowCnt = 0;
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '.') {
                    rowCnt++;
                }
            }
            if(rowCnt == m) {
                rowVal++;
            }
        }
        
        int colVal = 0;
        
        for(int j = 0; j < m; j++) {
            int colCnt = 0;
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == '.') {
                    colCnt++;
                }
            }
            if(colCnt == n) {
                colVal++;
            }
        }
        
        int result = Math.max(rowVal, colVal);
        System.out.print(result);
    }
}