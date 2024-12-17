import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new long[n + 1];

        visited[0] = 0;
        if(n >= 1) {
            visited[1] = 1;
        }

        for(int i = 2; i <= n; i ++) {
            visited[i] = visited[i - 1] + visited[i - 2];
        }

        bw.write(visited[n] + "");
        bw.flush();
    }
}