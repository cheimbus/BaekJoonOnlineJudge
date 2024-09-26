import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        boolean[] isEmpty = new boolean[101];
        int cnt = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            int parson = Integer.parseInt(stk.nextToken());
            if(!isEmpty[parson]) isEmpty[parson] = true;
            else cnt++;
        }
        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }
}