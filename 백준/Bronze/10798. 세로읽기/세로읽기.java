import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static int maxLen = 0;
    public static String[][] grid = new String[5][15];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 15; j ++) {
                grid[i][j] = "-";
            }
        }

        for(int i = 0; i < 5; i ++) {
            String[] s = br.readLine().split("");
            int len = s.length;
            maxLen = Math.max(maxLen, len);
            for(int j = 0; j < len; j ++) {
                grid[i][j] = s[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < maxLen; i ++)
            for(int j = 0; j < 5; j ++) {
                if(!grid[j][i].equals("-")) sb.append(grid[j][i]);
            }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}