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

        long cnt = 0;

        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(br.readLine());
            cnt += num;
        }

        if(n > 1) {
            cnt = cnt - n + 1;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}