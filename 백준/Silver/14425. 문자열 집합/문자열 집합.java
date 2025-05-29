import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < n; i ++) {
            hs.add(br.readLine());
        }

        int cnt = 0;
        for(int i = 0; i < m; i ++) {
            if(hs.contains(br.readLine())) cnt ++;
        }

        bw.write(cnt + "");
        bw.flush();
        br.close();
    }
}
