import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int tmpN = n;
        int val = 0;
        int cnt = 1;
        while(tmpN -- > 0) {
            int tmp = cnt;
            int tmpCnt = cnt;
            while(tmpCnt > 0) {
                tmp += tmpCnt % 10;
                tmpCnt /= 10;
            }

            if(tmp == n) {
                val = cnt;
                break;
            }
            cnt ++;
        }

        bw.write(val + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}