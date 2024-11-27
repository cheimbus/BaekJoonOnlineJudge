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
        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            int[][] arr = new int[h][w];
            int fw = 101;
            int copy = fw;
            for(int i = 0; i < h; i ++) {
                for(int j = 0; j < w; j ++) {
                    arr[i][j] = copy ++;
                }
                copy = fw;
                fw += 100;
                copy += 100;
            }

            int cnt = m;
            int ans = 0;
            for(int i = 0; i < w; i ++) {
                for(int j = 0; j < h; j ++) {
                    if(cnt == 0) break;
                    else {
                        ans = arr[j][i];
                        cnt --;
                    }
                }
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}