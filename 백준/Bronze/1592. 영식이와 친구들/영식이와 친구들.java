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
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        int num = 1;
        int cnt = 0;
        int[] person = new int[n + 1];
        while(true) {
            person[num] ++;
            if(person[num] == m) break;

            if(person[num] % 2 != 0) {
                num += l;
                if(num > n) {
                    num -= n;
                }
            }
            else {
                num -= l;
                if(num <= 0) {
                    num += n;
                }
            }
            cnt ++;
        }

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }
}